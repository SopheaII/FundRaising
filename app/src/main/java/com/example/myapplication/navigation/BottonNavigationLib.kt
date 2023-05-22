package com.example.myapplication.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.VectorizedAnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max
import kotlin.math.roundToInt

// TODO: b/149825331 add documentation references to Scaffold here and samples for using
// BottomNavigation inside a Scaffold
/**
 * <a href="https://material.io/components/bottom-navigation" class="external" target="_blank">Material Design bottom navigation</a>.
 *
 * Bottom navigation bars allow movement between primary destinations in an app.
 *
 * ![Bottom navigation image](https://developer.android.com/images/reference/androidx/compose/material/bottom-navigation.png)
 *
 * BottomNavigation should contain multiple [BottomNavigationItem]s, each representing a singular
 * destination.
 *
 * A simple example looks like:
 *
 * @sample androidx.compose.material.samples.BottomNavigationSample
 *
 * See [BottomNavigationItem] for configuration specific to each item, and not the overall
 * BottomNavigation component.
 *
 * For more information, see [Bottom Navigation](https://material.io/components/bottom-navigation/)
 *
 * @param modifier optional [Modifier] for this BottomNavigation
 * @param backgroundColor The background color for this BottomNavigation
 * @param contentColor The preferred content color provided by this BottomNavigation to its
 * children. Defaults to either the matching content color for [backgroundColor], or if
 * [backgroundColor] is not a color from the theme, this will keep the same value set above this
 * BottomNavigation.
 * @param elevation elevation for this BottomNavigation
 * @param content destinations inside this BottomNavigation, this should contain multiple
 * [BottomNavigationItem]s
 */
@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = BottomNavigationDefaults.Elevation,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        modifier = modifier
    ) {
        Row(
            Modifier
                .padding(start = 10.dp, end = 10.dp)
                .height(BottomNavigationHeight)
                .selectableGroup(),
            content = content
        )
    }
}

/**
 * <a href="https://material.io/components/bottom-navigation" class="external" target="_blank">Material Design bottom navigation</a> item.
 *
 * The recommended configuration for a BottomNavigationItem depends on how many items there are
 * inside a [BottomNavigation]:
 *
 * - Three destinations: Display icons and text labels for all destinations.
 * - Four destinations: Active destinations display an icon and text label. Inactive destinations
 * display icons, and text labels are recommended.
 * - Five destinations: Active destinations display an icon and text label. Inactive destinations
 * use icons, and use text labels if space permits.
 *
 * A BottomNavigationItem always shows text labels (if it exists) when selected. Showing text
 * labels if not selected is controlled by [alwaysShowLabel].
 *
 * @param selected whether this item is selected
 * @param onClick the callback to be invoked when this item is selected
 * @param icon icon for this item, typically this will be an [Icon]
 * @param modifier optional [Modifier] for this item
 * @param enabled controls the enabled state of this item. When `false`, this item will not
 * be clickable and will appear disabled to accessibility services.
 * @param label optional text label for this item
 * @param alwaysShowLabel whether to always show the label for this item. If false, the label will
 * only be shown when this item is selected.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this BottomNavigationItem. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this BottomNavigationItem in different [Interaction]s.
 * @param selectedContentColor the color of the text label and icon when this item is selected,
 * and the color of the ripple.
 * @param unselectedContentColor the color of the text label and icon when this item is not selected
 */
@Composable
fun RowScope.BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = ContentAlpha.medium)
) {
    // The color of the Ripple should always the selected color, as we want to show the color
    // before the item is considered selected, and hence before the new contentColor is
    // provided by BottomNavigationTransition.
    val ripple = rememberRipple(bounded = false, color = selectedContentColor)

    Box(
        modifier
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = ripple
            )
            .weight(if(selected) 1f else 0.5f),

        contentAlignment = Alignment.Center
    ) {
        BottomNavigationTransition(
            selectedContentColor,
            unselectedContentColor,
            selected
        ) { progress ->
            BottomNavigationItemBaselineLayout(
                icon = icon
            )
        }
    }
}

/**
 * Contains default values used for [BottomNavigation].
 */
object BottomNavigationDefaults {
    /**
     * Default elevation used for [BottomNavigation].
     */
    val Elevation = 8.dp
}

/**
 * Transition that animates [LocalContentColor] between [inactiveColor] and [activeColor], depending
 * on [selected]. This component also provides the animation fraction as a parameter to [content],
 * to allow animating the position of the icon and the scale of the label alongside this color
 * animation.
 *
 * @param activeColor [LocalContentColor] when this item is [selected]
 * @param inactiveColor [LocalContentColor] when this item is not [selected]
 * @param selected whether this item is selected
 * @param content the content of the [BottomNavigationItem] to animate [LocalContentColor] for,
 * where the animationProgress is the current progress of the animation from 0f to 1f.
 */
@Composable
private fun BottomNavigationTransition(
    activeColor: Color,
    inactiveColor: Color,
    selected: Boolean,
    content: @Composable (animationProgress: Float) -> Unit
) {
    val animationProgress by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = BottomNavigationAnimationSpec
    )

    val color = lerp(inactiveColor, activeColor, animationProgress)

    CompositionLocalProvider(
        LocalContentColor provides color.copy(alpha = 1f),
        LocalContentAlpha provides color.alpha,
    ) {
        content(animationProgress)
    }
}

/**
 * Base layout for a [BottomNavigationItem]
 *
 * @param icon icon for this item
 * @param label text label for this item
 * @param iconPositionAnimationProgress progress of the animation that controls icon position,
 * where 0 represents its unselected position and 1 represents its selected position. If both the
 * [icon] and [label] should be shown at all times, this will always be 1, as the icon position
 * should remain constant.
 */
@Composable
private fun BottomNavigationItemBaselineLayout(
    icon: @Composable () -> Unit,
) {
    Layout(
        {
            Box(Modifier.layoutId("icon")) { icon() }
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)

        placeIcon(iconPlaceable, constraints)
    }
}

/**
 * Places the provided [iconPlaceable] in the vertical center of the provided [constraints]
 */
private fun MeasureScope.placeIcon(
    iconPlaceable: Placeable,
    constraints: Constraints
): MeasureResult {
    val height = constraints.maxHeight
    val iconY = (height - iconPlaceable.height) / 2
    return layout(iconPlaceable.width, height) {
        iconPlaceable.placeRelative(0, iconY)
    }
}

/**
 * [VectorizedAnimationSpec] controlling the transition between unselected and selected
 * [BottomNavigationItem]s.
 */
private val BottomNavigationAnimationSpec = TweenSpec<Float>(
    durationMillis = 150,
    easing = FastOutSlowInEasing
)

/**
 * Height of a [BottomNavigation] component
 */
private val BottomNavigationHeight = 56.dp
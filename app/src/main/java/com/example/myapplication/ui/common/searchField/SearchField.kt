package com.example.myapplication.ui.common.searchField

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.common.CustomText
import com.example.myapplication.ui.theme.Dark_Blue
import com.example.myapplication.ui.theme.Gray_Text
import com.example.myapplication.ui.theme.White_Color

@Composable
internal fun SearchField(
    modifier: Modifier = Modifier
) {

    var text by rememberSaveable {
        mutableStateOf(
            ""
        )
    }
    val ripple = rememberRipple(
        bounded = false, color = Gray_Text
    )
    val interactionSource: MutableInteractionSource =
        remember { MutableInteractionSource() }
    TextField(
        value = text,
        modifier = modifier
            .height(50.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(
                    30.dp
                )
                clip = true
            }
            .border(
                BorderStroke(
                    1.5.dp, Gray_Text
                ), RoundedCornerShape(30.dp)
            ),
        onValueChange = { text = it },
        placeholder = {
            CustomText(
                text = "Search campaign",
            )
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = Dark_Blue,
            fontWeight = FontWeight.Medium
        ),
        trailingIcon = {
            Box(modifier = Modifier
                .selectable(
                    selected = true,
                    onClick = {},
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = ripple
                )
                .padding(5.dp)
                .graphicsLayer {
                    shape = RoundedCornerShape(
                        50
                    )
                    clip = true
                }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_remove),
                    contentDescription = "",
                    Modifier.size(20.dp)
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Dark_Blue,
            disabledTextColor = Color.Transparent,
            backgroundColor = White_Color,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}

@Preview
@Composable
fun Preview(
) {
    SearchField()
}
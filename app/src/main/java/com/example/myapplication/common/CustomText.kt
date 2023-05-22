package com.example.myapplication.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.R
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Dark_Blue

val CustomFontFamily = FontFamily(
    Font(R.font.nunito_regular),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(
        R.font.nunito_semi_bold,
        FontWeight.SemiBold
    ),
    Font(R.font.nunito_medium, FontWeight.Medium),
    Font(R.font.nunito_light, FontWeight.Light),
    Font(
        R.font.nunito_extra_light,
        FontWeight.ExtraLight
    ),
    Font(R.font.nunito_extra_bold, FontWeight.ExtraBold),
    Font(R.font.nunito_black, FontWeight.Black),
)

val LocalCustomFont =
    staticCompositionLocalOf { CustomFontFamily }

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Dark_Blue,
    ),
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    val customFontFamily = LocalCustomFont.current

    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = style.copy(
            fontFamily = customFontFamily,
            fontSize = style.fontSize,
            textAlign = TextAlign.Center
        ),
    )
}

@Composable
fun CustomText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(
        fontSize = 14.sp,
        color = Dark_Blue
    ),
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    val customFontFamily = LocalCustomFont.current

    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = style.copy(
            fontFamily = customFontFamily,
            fontSize = style.fontSize,
            textAlign = TextAlign.Center
        ),
    )
}
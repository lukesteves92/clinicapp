package com.inspirecoding.clinicapp.ds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.inspirecoding.clinicapp.ds.R
import com.inspirecoding.clinicapp.ds.mask.MaskVisualTransformation
import com.inspirecoding.clinicapp.ds.typography.Typography


@Composable
fun InputCustomField(
    modifier: Modifier = Modifier,
    text: MutableState<String>,
    label: String,
    mask: String? = null,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int? = null,
    errorMessage: String = "",
    descriptionMessage: String = "",
    state: TextFieldState = TextFieldState.DEFAULT,
    onTextChange: (String) -> Unit = {}
) {
    BaseTextField(
        modifier = modifier,
        text = text.value,
        onTextChange = {
            onTextChange.invoke(it)
            text.value = it
        },
        maxLength = maxLength,
        mask = mask,
        label = label,
        state = state,
        enabled = enabled,
        errorMessage = errorMessage,
        descriptionMessage = descriptionMessage,
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    hintText: String = "",
    maxLines: Int = 1,
    maxLength: Int? = null,
    enabled: Boolean = true,
    text: String,
    label: String = "",
    mask: String? = null,
    errorMessage: String = "",
    descriptionMessage: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    state: TextFieldState = TextFieldState.DEFAULT,
    singleLine: Boolean = true,
    onTextChange: (String) -> Unit
) {
    var mutableState = state
    val absoluteMaxLength = mask?.count { it == MaskVisualTransformation.MASK_DIGIT } ?: maxLength

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = when (mutableState) {
                    TextFieldState.SUCCESS -> Color.Green
                    TextFieldState.ERROR -> Color.Red
                    TextFieldState.DEFAULT -> Color.DarkGray
                },
                shape = RoundedCornerShape(8.dp)
            ),
    ) {
        val containerColor = if (mutableState == TextFieldState.ERROR) Color.Red else Color.White
        TextField(
            value = text,
            shape = RoundedCornerShape(8.dp),
            onValueChange = { text ->
                mutableState = TextFieldState.DEFAULT
                absoluteMaxLength?.let { length ->
                    if (text.length <= length)
                        onTextChange(
                            if (mask.isNullOrEmpty())
                                text
                            else
                                text.filter { it.isDigit() }
                        )

                } ?: run {
                    onTextChange(text)
                }
            },
            label = {
                Text(
                    text = label, style = Typography.bodyMedium, color = when (mutableState) {
                        TextFieldState.SUCCESS -> Color.Green
                        TextFieldState.ERROR -> Color.Red
                        TextFieldState.DEFAULT -> Color.Gray
                    }
                )
            },
            placeholder = { Text(text = hintText, style = Typography.bodyMedium) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = containerColor,
                unfocusedIndicatorColor = containerColor,
                disabledIndicatorColor = containerColor
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
            maxLines = maxLines,
            enabled = enabled,
            textStyle = Typography.bodyMedium,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            visualTransformation = if (mask.isNullOrEmpty()) {
                VisualTransformation.None
            } else {
                MaskVisualTransformation(mask)
            }
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if ((mutableState == TextFieldState.ERROR && errorMessage.isNotEmpty()) ||
            descriptionMessage.isNotEmpty()
        ) {
            Image(
                modifier = Modifier.padding(start = 16.dp),
                imageVector = ImageVector.vectorResource(
                    id = when (mutableState) {
                        TextFieldState.SUCCESS -> R.drawable.clinicapp_ic_checkmark_circle
                        TextFieldState.ERROR -> R.drawable.clinicapp_ic_warning
                        TextFieldState.DEFAULT -> R.drawable.clinicapp_ic_info
                    }
                ),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(horizontal = 6.dp),
                text = if (mutableState == TextFieldState.ERROR)
                    errorMessage.ifEmpty { descriptionMessage }
                else
                    descriptionMessage,
                color = when (mutableState) {
                    TextFieldState.SUCCESS -> Color.Green
                    TextFieldState.ERROR -> Color.Red
                    TextFieldState.DEFAULT -> Color.Gray
                },
                style = Typography.displaySmall
            )
        }
    }

}

enum class TextFieldState {
    DEFAULT, SUCCESS, ERROR
}
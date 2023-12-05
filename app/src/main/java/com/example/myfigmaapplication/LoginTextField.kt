package com.example.myfigmaapplication

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myfigmaapplication.ui.theme.Black
import com.example.myfigmaapplication.ui.theme.textFieldContainer
import com.example.myfigmaapplication.ui.theme.unfocusedTextFieldText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String,
) {
    var text by remember {
        mutableStateOf("")
    }

    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
        },
        label = {
            Text(
                modifier = modifier,
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = uiColor
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            placeholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            containerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        trailingIcon = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }
    )
}
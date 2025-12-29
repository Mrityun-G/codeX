package com.example.textfielddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldView()
        }
    }
}

@Composable
fun TextFieldView() {
    // State for text
    val textState = remember { mutableStateOf("") }
    // State for border color
    val focusColor = remember { mutableStateOf(Color.Gray) }

    TextField(
        value = textState.value,
        onValueChange = { newText ->
            textState.value = newText
        },
        modifier = Modifier
            .height(70.dp)
            .border(
                width = 3.dp,
                color = focusColor.value,
                shape = RoundedCornerShape(8.dp)
            )
            .onFocusChanged {
                focusColor.value = if (it.isFocused) Color.Blue else Color.Gray
            },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        placeholder = { Text("Enter email") }
    )
}

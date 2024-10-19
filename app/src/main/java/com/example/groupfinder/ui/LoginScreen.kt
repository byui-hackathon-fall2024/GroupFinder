package com.example.groupfinder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groupfinder.ui.theme.GroupFinderTheme

@Composable
fun LoginScreen(
    // nav parameters
    modifier: Modifier = Modifier
) {
    Column {  }
}

@Preview
@Composable
fun LoginScreenPreview() {
    GroupFinderTheme {
        LoginScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}
package com.example.groupfinder.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groupfinder.R
import com.example.groupfinder.ui.theme.GroupFinderTheme

/*
* TODO:
* function to check if skills are in list of skills
* fix the circle being cut off on the profile page
* */

@Composable
fun ProfileScreen(skills: List<String>) {

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.defaultprofilepic),
                contentDescription = "Profile Image"
            )
            Text(text = "fName lName",)
        }
    }
}



@Preview
@Composable
fun ProfileScreenPreview() {
    GroupFinderTheme {
        ProfileScreen(skills = listOf("Option 1", "Option 2", "Option 3", "Option 4") )
    }
}
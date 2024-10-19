package com.example.groupfinder.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupfinder.ui.theme.GroupFinderTheme

@Composable
fun MyGroups(
    modifier: Modifier = Modifier
) {
    val groups = listOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5")
    //val constraints = ConstraintSet
    Column(
        modifier = modifier
            .background(Color(0xFF24293E))
            .padding(16.dp, top = 80.dp, 16.dp, 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,

    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "My Groups",
                color = Color(0xFFCCCCCC),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                //.background(color = Color.Green)
        ) {
            items(groups.size) { index ->
                GroupCard(
                    groups[index])
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.width(140.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8EBBFF),
                    contentColor = Color(0xFF24293E)
                ),
                onClick = {}) {
                Text("Join Group")
            }

            Button(
                modifier = Modifier.width(140.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8EBBFF),
                    contentColor = Color(0xFF24293E)
                ),
                onClick = {}) {
                Text("Create Group")
            }
        }
    }
}

@Composable
fun GroupCard(groupName: String) {
    Card(modifier = Modifier
        .padding(6.dp)
        .fillMaxSize()
        .height(60.dp)
        .clickable(
            onClick = {}
        ),
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF434d73)) //313853  34495B
            .padding(4.dp)) {
            Text(
                text = groupName,
                color = Color(0xFFCCCCCC),
                fontSize = 30.sp
            )
        }
    }
}


@Preview
@Composable
fun MyGroupsPreview() {
    GroupFinderTheme {
        MyGroups()
    }
}
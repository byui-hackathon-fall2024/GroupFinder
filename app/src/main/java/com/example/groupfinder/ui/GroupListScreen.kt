package com.example.groupfinder.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groupfinder.model.Group


@Composable
fun GroupListScreen(viewModel: GroupsViewModel = viewModel()) {

    val groups by viewModel.groupList.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(20.dp),
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
//            items(groups) { user ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 10.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text(
//                        text = user.name.toString(),
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
            item {
                Button(onClick = { viewModel.createGroup() }) {
                    Text(text = "Create new User")
                }
                Button(onClick = { viewModel.updateGroup() }) {
                    Text(text = "Update User")
                }
            }
        }
    }
}
//
//@Composable
//fun GroupCard(group: Group) {
//    // Create a wide card for the group
//    Card(
//        shape = RoundedCornerShape(8.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color(0xFFF5F5F5))
//                .padding(16.dp)
//        ) {
//            // Group Name
//            Text(
//                text = group.name,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            // Skills Needed Section
//            Text(
//                text = "Skills Needed:",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
//            group.skillsNeeded.forEach { skill ->
//                Text(
//                    text = "- $skill",
//                    fontSize = 14.sp,
//                    color = Color.Gray,
//                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
//                )
//            }
//
//            // Divider between sections
//            HorizontalDivider(
//                modifier = Modifier.padding(vertical = 8.dp),
//                thickness = 1.dp,
//                color = Color.Gray
//            )
//
//            // Team Members Section
//            Text(
//                text = "Team Members:",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
//            group.teamMembers.forEach { member ->
//                Text(
//                    text = "- $member",
//                    fontSize = 14.sp,
//                    color = Color.Gray,
//                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
//                )
//            }
//        }
//    }
//}
//

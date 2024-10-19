package com.example.groupfinder.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groupfinder.ui.theme.ButtonBlue
import com.example.groupfinder.ui.theme.DarkBlue
import com.example.groupfinder.ui.theme.GroupFinderTheme
import com.example.groupfinder.ui.theme.Peach

/*
* TODO:
* populate dynamically
* */

@Composable
fun ProfileScreen(viewModel: UserViewModel = viewModel()) {

    val user by viewModel.user.collectAsStateWithLifecycle() // get car

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF73C2FB), Color(0xFF24293E))
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        // Name
        user?.let {
            Text(
                text = it.name,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp, top = 30.dp)
            )
        }

        // Email
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            user?.let {
                Text(
                    text = it.email,
                    fontSize = 20.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }

        // Divider
        Divider(
            color = Color.White.copy(alpha = 0.7f),
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        )

        // Skills List
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Skills:",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            user?.skills?.forEach { skill ->
                Text(
                    text = "- $skill",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}




//Column (
//modifier = Modifier
//.fillMaxWidth() // Make the column fill the entire width
//.fillMaxHeight(1f / 3f) // 1/3 of the screen height
//.padding(20.dp)
//.background(color = ButtonBlue)
//){
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = Peach),
//        contentAlignment = Alignment.TopCenter
//    ) {
//        Text(text = "${user?.name}",
//            fontSize = 36.sp,
//            fontWeight = FontWeight.Medium
//        )
//        Text(text = "Email: ${user?.email}",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Medium
//        )
//    }
//}
//}



//@Preview
//@Composable
//fun ProfileScreenPreview() {
//    GroupFinderTheme {
//        ProfileScreen(viewModel = viewModel())
//    }
//}
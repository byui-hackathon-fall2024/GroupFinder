package com.example.groupfinder.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groupfinder.ui.theme.GroupFinderTheme

/*
* TODO:
* function to check if skills are in list of skills
* fix the circle being cut off on the profile page
* formatting
* */

@Composable
fun ProfileScreen2(viewModel: UserViewModel = viewModel()) {

    val user by viewModel.user.collectAsStateWithLifecycle() // get car

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "${user?.id} - ${user?.name}",
            fontSize = 36.sp,
            fontWeight = FontWeight.Medium)
    }
}

@Composable
fun ProfileScreen1(viewModel: UsersViewModel = viewModel()) {

    val users by viewModel.userList.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        LazyColumn (
            contentPadding = PaddingValues(20.dp),
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(users) { user ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text = user.name.toString(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = user.email.toString(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            item {
                Button(onClick = { viewModel.createUser() } ) {
                    Text(text = "Create new User")
                }
                Button(onClick = { viewModel.updateCar() } ) {
                    Text(text = "Update User")
                }
            }
        }
    }






}
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp)
//        ){
//            Image(
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(bottom = 16.dp)
//                    .clip(CircleShape),
//                painter = painterResource(id = R.drawable.defaultprofilepic),
//                contentDescription = "Profile Image"
//            )
//            Text(text = "fName lName",)
//        }
//    }
// }



@Preview
@Composable
fun ProfileScreenPreview() {
    GroupFinderTheme {
        ProfileScreen1(viewModel = viewModel())
    }
}
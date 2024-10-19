package com.example.groupfinder

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groupfinder.ui.LoginScreen
import com.example.groupfinder.data.LoginUiState
import com.example.groupfinder.ui.CreateGroup
import com.example.groupfinder.ui.GroupListScreen
import com.example.groupfinder.ui.MyGroups
import com.example.groupfinder.ui.ProfileScreen
//import com.example.groupfinder.ui.ProfileSearch
import com.example.groupfinder.ui.UserViewModel
import kotlin.math.log

enum class GroupFinderScreen(@StringRes val title: Int) {
    LoginScreen(title = R.string.app_name),
    RegisterScreen(title = R.string.register),
    ProfileScreen(title = R.string.profile),
    MyGroupsScreen(title = R.string.my_groups),
    CreateGroupScreen(title = R.string.create_group),
    GroupListScreen(title = R.string.groups),
    ProfileSearchScreen(title = R.string.profile_search),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupFinderAppBar(
    currentScreen: GroupFinderScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GroupFinderApp(
//    viewModel: ViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
) {
    //val loginUiState = LoginUiState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = GroupFinderScreen.valueOf(
        backStackEntry?.destination?.route ?: GroupFinderScreen.LoginScreen.name)

    //Text("Is this working")

    Scaffold(
        topBar = {
            GroupFinderAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = GroupFinderScreen.LoginScreen.name,
        ) {
            composable(route = GroupFinderScreen.LoginScreen.name) {
                LoginScreen() { email, password ->
                    navController.navigate(GroupFinderScreen.ProfileScreen.name)
                }
            }
            composable(route = GroupFinderScreen.ProfileScreen.name) {
                val userViewModel = UserViewModel()
                ProfileScreen(viewModel = userViewModel)
            }
            composable(route = GroupFinderScreen.MyGroupsScreen.name) {
                //val userViewModel = UserViewModel()
                MyGroups()
            }
            composable(route = GroupFinderScreen.CreateGroupScreen.name) {
                //val userViewModel = UserViewModel()
                CreateGroup()
            }
            composable(route = GroupFinderScreen.GroupListScreen.name) {
                //val userViewModel = UserViewModel()
                GroupListScreen()
            }
//            composable(route = GroupFinderScreen.ProfileSearchScreen.name) {
//                //val userViewModel = UserViewModel()
//                ProfileSearch()
//            }
        }
    }
}
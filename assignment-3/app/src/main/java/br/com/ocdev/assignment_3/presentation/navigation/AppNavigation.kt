import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.ocdev.assignment_3.presentation.details_screen.DetailViewModel
import br.com.ocdev.assignment_3.presentation.home_screen.DetailScreen
import br.com.ocdev.assignment_3.presentation.home_screen.HomeScreen
import br.com.ocdev.assignment_3.presentation.home_screen.HomeViewModel
import br.com.ocdev.assignment_3.presentation.list_screen.UserScreen
import br.com.ocdev.assignment_3.presentation.list_screen.UsersViewModel
import br.com.ocdev.assignment_3.presentation.navigation.TopLevelDestination
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = if (homeViewModel.populated.value) TopLevelDestination.Home.route else TopLevelDestination.Users.route
    ) {
        composable(route = TopLevelDestination.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()

            HomeScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }
        composable(route = TopLevelDestination.Users.route) {
            val usersViewModel = hiltViewModel<UsersViewModel>()

            UserScreen(
                navController = navController,
                usersViewModel = usersViewModel
            )
        }
        composable(route = TopLevelDestination.Detail.route + "/{idUser}", arguments = listOf(
            navArgument("idUser") {
                type = NavType.StringType
            }
        )) { backStackEntry ->
            val detailViewModel = hiltViewModel<DetailViewModel>()
            val idUser = backStackEntry.arguments?.getString("idUser") ?: return@composable

            DetailScreen(
                navController = navController,
                detailViewModel = detailViewModel,
                idUser
            )
        }

        /*        composable(
        //            route = TopLevelDestination.Detail.route + "?from={from}",
                    route = TopLevelDestination.Detail.route + "/{from}",
                    arguments = listOf(
                        navArgument("from") {
                            type = NavType.StringType
        //                    defaultValue = "DefaultScreen"
                        }
                    )
                ) { backStackEntry ->
        //            // Pass backStackEntry in hilt function to share ViewModel between navigation destinations
        //            val homeViewModel = hiltViewModel<HomeViewModel>(backStackEntry)

                    val from = backStackEntry.arguments?.getString("from") ?: return@composable
                    DetailScreen(navController = navController, from)
                }*/
    }
}
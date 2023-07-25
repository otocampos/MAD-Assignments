package br.com.ocdev.assignment_3.presentation.navigation

sealed class TopLevelDestination(
    val title: String,
    val route: String
) {
    object Home : TopLevelDestination(
        title = "Home",
        route = "home",
    )
    object Users : TopLevelDestination(
        title = "Users",
        route = "users"
    )

    object Detail : TopLevelDestination(
        title = "Detail",
        route = "detail"
    )

    /**
     * Use this function to pass arguments to navigation destination
     */
    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
package yegor.cheprasov.newscreatorkit.compose.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import yegor.cheprasov.newscreatorkit.compose.login.LoginScreen
import yegor.cheprasov.newscreatorkit.decompose.root.AppRootComponent

@Composable
fun RootScreen(component: AppRootComponent, modifier: Modifier = Modifier) {
    Children(component.childStack, modifier = modifier) {
        when (val instance = it.instance) {
            is AppRootComponent.Child.Login -> LoginScreen(instance.component)
        }
    }
}
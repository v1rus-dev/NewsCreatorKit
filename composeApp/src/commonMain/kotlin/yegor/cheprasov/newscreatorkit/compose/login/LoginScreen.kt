package yegor.cheprasov.newscreatorkit.compose.login

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import yegor.cheprasov.newscreatorkit.compose.login.register.RegisterScreen
import yegor.cheprasov.newscreatorkit.compose.login.signIn.SignInScreen
import yegor.cheprasov.newscreatorkit.decompose.login.LoginComponent

@Composable
fun LoginScreen(component: LoginComponent) {
    Children(component.childStack) {
        when(val instance = it.instance) {
            is LoginComponent.Child.SignIn -> SignInScreen(instance.component)
            is LoginComponent.Child.Register -> RegisterScreen(instance.component)
        }
    }
}
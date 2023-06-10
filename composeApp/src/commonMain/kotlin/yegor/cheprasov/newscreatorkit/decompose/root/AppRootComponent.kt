package yegor.cheprasov.newscreatorkit.decompose.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import yegor.cheprasov.newscreatorkit.decompose.login.LoginComponent

interface AppRootComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Login(val component: LoginComponent) : Child()
    }

}
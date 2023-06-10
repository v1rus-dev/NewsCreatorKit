package yegor.cheprasov.newscreatorkit.decompose.login

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import yegor.cheprasov.newscreatorkit.decompose.login.register.RegisterComponent
import yegor.cheprasov.newscreatorkit.decompose.login.signIn.SignInComponent

interface LoginComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {

        class SignIn(val component: SignInComponent) : Child()

        class Register(val component: RegisterComponent) : Child()

    }

}
package yegor.cheprasov.newscreatorkit.decompose.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import io.github.aakira.napier.Napier
import yegor.cheprasov.newscreatorkit.decompose.BaseComponent
import yegor.cheprasov.newscreatorkit.decompose.login.signIn.RealSignInComponent
import yegor.cheprasov.newscreatorkit.decompose.login.signIn.SignInComponent

class RealLoginComponent(
    componentContext: ComponentContext
) : BaseComponent(componentContext), LoginComponent {

    private val navigation = StackNavigation<ParentConfiguration>()

    private val _childStack = childStack(
        source = navigation,
        initialConfiguration = ParentConfiguration.SignIn,
        handleBackButton = false,
        childFactory = ::childFactory
    )

    init {
        Napier.d { "InitLoginComponent" }
    }

    override val childStack: Value<ChildStack<*, LoginComponent.Child>> = _childStack

    private fun childFactory(configuration: ParentConfiguration, componentContext: ComponentContext): LoginComponent.Child =
        when(configuration) {
            ParentConfiguration.SignIn -> LoginComponent.Child.SignIn(signIn(componentContext))
        }

    private fun signIn(componentContext: ComponentContext): SignInComponent =
        RealSignInComponent(componentContext)

    private sealed class ParentConfiguration : Parcelable {

        @Parcelize
        object SignIn : ParentConfiguration()

    }

}
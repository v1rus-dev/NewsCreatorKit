package yegor.cheprasov.newscreatorkit.decompose.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import yegor.cheprasov.newscreatorkit.decompose.BaseComponent
import yegor.cheprasov.newscreatorkit.decompose.login.register.RealRegisterComponent
import yegor.cheprasov.newscreatorkit.decompose.login.register.RegisterComponent
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

    override val childStack: Value<ChildStack<*, LoginComponent.Child>> = _childStack

    private fun childFactory(configuration: ParentConfiguration, componentContext: ComponentContext): LoginComponent.Child =
        when(configuration) {
            ParentConfiguration.SignIn -> LoginComponent.Child.SignIn(signIn(componentContext))
            ParentConfiguration.Register -> LoginComponent.Child.Register(register(componentContext))
        }

    private fun signIn(componentContext: ComponentContext): SignInComponent =
        RealSignInComponent(componentContext) { event ->
            when(event) {
                SignInComponent.PublicEvent.OnRegister -> navigation.push(ParentConfiguration.Register)
            }
        }

    private fun register(componentContext: ComponentContext): RegisterComponent =
        RealRegisterComponent(componentContext) { event ->
            when(event) {
                RegisterComponent.PublicEvent.OnBack -> navigation.pop()
            }
        }

    private sealed class ParentConfiguration : Parcelable {

        @Parcelize
        object SignIn : ParentConfiguration()

        @Parcelize
        object Register : ParentConfiguration()

    }

}
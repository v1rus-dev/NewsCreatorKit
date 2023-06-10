package yegor.cheprasov.newscreatorkit.decompose.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import yegor.cheprasov.newscreatorkit.decompose.BaseComponent
import yegor.cheprasov.newscreatorkit.decompose.login.LoginComponent
import yegor.cheprasov.newscreatorkit.decompose.login.RealLoginComponent

class RealAppRootComponent(
    componentContext: ComponentContext
) : BaseComponent(componentContext), AppRootComponent {

    private val navigation = StackNavigation<ParentConfiguration>()

    private val _childStack = childStack(
        source = navigation,
        initialConfiguration = ParentConfiguration.Login,
        handleBackButton = false,
        childFactory = ::childFactory
    )

    override val childStack: Value<ChildStack<*, AppRootComponent.Child>> = _childStack

    private fun childFactory(configuration: ParentConfiguration, componentContext: ComponentContext): AppRootComponent.Child =
        when(configuration) {
            ParentConfiguration.Login -> AppRootComponent.Child.Login(login(componentContext))
        }

    private fun login(componentContext: ComponentContext): LoginComponent =
        RealLoginComponent(componentContext)

    private sealed class ParentConfiguration : Parcelable {

        @Parcelize
        object Login : ParentConfiguration()

    }
}
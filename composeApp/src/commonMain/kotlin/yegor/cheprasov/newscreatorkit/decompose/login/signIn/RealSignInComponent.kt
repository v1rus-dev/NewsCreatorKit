package yegor.cheprasov.newscreatorkit.decompose.login.signIn

import com.arkivanov.decompose.ComponentContext
import yegor.cheprasov.newscreatorkit.decompose.BaseComponent

class RealSignInComponent(
    componentContext: ComponentContext,
    private val _onEvent: (SignInComponent.PublicEvent) -> Unit
) : BaseComponent(componentContext), SignInComponent {
    override fun event(event: SignInComponent.Event) {
        when(event) {
            SignInComponent.Event.OnRegister -> _onEvent(SignInComponent.PublicEvent.OnRegister)
        }
    }
}
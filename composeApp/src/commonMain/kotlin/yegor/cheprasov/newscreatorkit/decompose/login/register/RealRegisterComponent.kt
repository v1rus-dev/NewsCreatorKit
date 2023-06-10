package yegor.cheprasov.newscreatorkit.decompose.login.register

import com.arkivanov.decompose.ComponentContext
import yegor.cheprasov.newscreatorkit.decompose.BaseComponent

class RealRegisterComponent(
    componentContext: ComponentContext,
    private val _onEvent: (RegisterComponent.PublicEvent) -> Unit
) : BaseComponent(componentContext), RegisterComponent {
    override fun event(event: RegisterComponent.Event) {
        when(event) {
            RegisterComponent.Event.OnBack -> _onEvent(RegisterComponent.PublicEvent.OnBack)
        }
    }

}
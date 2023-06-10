package yegor.cheprasov.newscreatorkit.decompose.login.signIn

interface SignInComponent {

    fun event(event: Event)

    sealed interface PublicEvent {
        object OnRegister : PublicEvent
    }

    sealed interface Event {
        object OnRegister : Event
    }

}
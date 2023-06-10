package yegor.cheprasov.newscreatorkit.decompose.login.register

interface RegisterComponent {

    fun event(event: Event)

    sealed interface PublicEvent {
        object OnBack : PublicEvent
    }

    sealed interface Event {
        object OnBack : Event
    }

}
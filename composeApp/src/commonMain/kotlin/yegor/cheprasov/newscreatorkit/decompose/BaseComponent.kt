package yegor.cheprasov.newscreatorkit.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackCallback
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatformTools
import yegor.cheprasov.newscreatorkit.di.DefaultDispatcherName
import yegor.cheprasov.newscreatorkit.di.IODispatcherName
import yegor.cheprasov.newscreatorkit.di.MainDispatcherName
import yegor.cheprasov.newscreatorkit.utils.CoroutineScope
import kotlin.coroutines.CoroutineContext

open class BaseComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, KoinComponent {

    protected val dispatcherIO by injectIODispatcher()
    protected val dispatcherDefault by injectDefaultDispatcher()
    protected val dispatcherMain by injectMainDispatcher()
    protected val scope = CoroutineScope(dispatcherDefault, lifecycle)

    open val callbackEnabled = true
    protected val backCallback = BackCallback(isEnabled = callbackEnabled) {
        onBack()
    }

    init {
        backHandler.register(backCallback)
    }

    open fun onBack() = Unit

}

inline fun KoinComponent.injectIODispatcher(): Lazy<CoroutineContext> =
    lazy(KoinPlatformTools.defaultLazyMode()) {
        get(qualifier = named(IODispatcherName))
    }

inline fun KoinComponent.injectDefaultDispatcher(): Lazy<CoroutineContext> =
    lazy(KoinPlatformTools.defaultLazyMode()) {
        get(qualifier = named(DefaultDispatcherName))
    }

inline fun KoinComponent.injectMainDispatcher(): Lazy<CoroutineContext> =
    lazy(KoinPlatformTools.defaultLazyMode()) {
        get(qualifier = named(MainDispatcherName))
    }
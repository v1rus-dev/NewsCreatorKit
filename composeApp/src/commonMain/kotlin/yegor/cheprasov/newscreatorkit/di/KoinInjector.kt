package yegor.cheprasov.newscreatorkit.di

import org.koin.core.KoinApplication

expect object KoinInjector {

}

fun KoinApplication.injectAppModules() {
    modules(
        coroutineModule
    )
}
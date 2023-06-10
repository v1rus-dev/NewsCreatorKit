package yegor.cheprasov.newscreatorkit.di

import org.koin.core.context.startKoin

actual object KoinInjector {

    fun inject() {
        startKoin {
            injectAppModules()
        }
    }

}
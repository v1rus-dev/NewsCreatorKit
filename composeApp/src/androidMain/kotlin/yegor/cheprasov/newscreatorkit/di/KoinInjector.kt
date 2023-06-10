package yegor.cheprasov.newscreatorkit.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

actual object KoinInjector {

    fun inject(context: Context) {
        startKoin {
            injectAppModules()
        }.androidContext(context)
    }

}
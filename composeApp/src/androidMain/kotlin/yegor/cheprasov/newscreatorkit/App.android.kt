package yegor.cheprasov.newscreatorkit

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.arkivanov.decompose.defaultComponentContext
import yegor.cheprasov.newscreatorkit.compose.root.RootScreen
import yegor.cheprasov.newscreatorkit.decompose.root.RealAppRootComponent
import yegor.cheprasov.newscreatorkit.di.KoinInjector

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        KoinInjector.inject(INSTANCE)
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RealAppRootComponent(
            componentContext = defaultComponentContext()
        )

        setContent { MaterialTheme {
            Surface {
                RootScreen(root)
            }
        } }
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}
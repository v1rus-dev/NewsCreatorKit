import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import yegor.cheprasov.newscreatorkit.compose.root.RootScreen
import yegor.cheprasov.newscreatorkit.decompose.root.RealAppRootComponent
import yegor.cheprasov.newscreatorkit.di.KoinInjector
import yegor.cheprasov.newscreatorkit.utils.runOnUiThread

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    KoinInjector.inject()

    val root = runOnUiThread {
        RealAppRootComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle)
        )
    }

    application {
        val windowState = rememberWindowState(width = 800.dp, height = 600.dp)

        LifecycleController(lifecycle, windowState)

        Window(
            title = "NewsCreatorKit",
            state = windowState,
            onCloseRequest = ::exitApplication,
        ) {
            MaterialTheme {
                Surface {
                    RootScreen(root, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
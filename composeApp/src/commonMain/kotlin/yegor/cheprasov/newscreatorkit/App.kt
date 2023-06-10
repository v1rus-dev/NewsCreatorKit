package yegor.cheprasov.newscreatorkit

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import yegor.cheprasov.newscreatorkit.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() = AppTheme {

}

internal expect fun openUrl(url: String?)
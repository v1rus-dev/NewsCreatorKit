package yegor.cheprasov.newscreatorkit.preview

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import yegor.cheprasov.newscreatorkit.compose.login.signIn.SignInScreen
import yegor.cheprasov.newscreatorkit.decompose.login.signIn.PreviewSignInComponent

@Preview
@Composable
private fun PreviewSignInScreen() {
    MaterialTheme {
        SignInScreen(PreviewSignInComponent())
    }
}
package yegor.cheprasov.newscreatorkit.compose.login.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import yegor.cheprasov.newscreatorkit.decompose.login.register.RegisterComponent

@Composable
fun RegisterScreen(component: RegisterComponent) {
    Column(modifier = Modifier.fillMaxSize()) {
        TextButton({
            component.event(RegisterComponent.Event.OnBack)
        }) {
            Text("Назад")
        }
    }
}
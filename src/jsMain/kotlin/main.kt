import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput
import org.jetbrains.compose.web.renderComposableInBody

fun main() {
    renderComposableInBody { App() }
}

@Composable
fun App() {
    Div {
        Text("1")
        TextInput("2")
        Text("3")
    }
}
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import kotlin.random.Random

fun main() {
    renderComposable("root") {
        var count by remember { mutableStateOf(0) }
        Button({
            onClick { count++ }
        }) { Text("Increment") }
        Text("Counter: $count")
        println("outer")
        CustomRow { // no extra recompositions
            println("inner1")
            val randomValue = Random.nextInt()
            Text("Random1: $randomValue")
        }
        CustomRow(modifier = CustomModifier) { // extra recompositions
            println("inner2")
            val randomValue = Random.nextInt()
            Text("Random2: $randomValue")
        }
    }
}
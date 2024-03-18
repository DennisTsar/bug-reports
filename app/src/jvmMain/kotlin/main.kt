import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.singleWindowApplication
import kotlin.random.Random

fun main() {
    singleWindowApplication {
        Column {
            var count by remember { mutableStateOf(0) }
            Button({ count++ }) { Text("Increment") }
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
}
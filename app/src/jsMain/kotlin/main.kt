import com.example.Modifier
import com.example.color
import org.jetbrains.compose.web.css.Color

fun main() {
    val a = Modifier.color(Color.aquamarine)
    val b = Color("color")
    println("$a $b")
}
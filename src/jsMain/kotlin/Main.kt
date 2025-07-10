import org.jetbrains.compose.web.css.StyleScopeBuilder
import org.jetbrains.compose.web.css.div
import org.jetbrains.compose.web.css.flexBasis
import org.jetbrains.compose.web.css.percent

fun main() {
    StyleScopeBuilder()
        .flexBasis(100.percent / 5)
}
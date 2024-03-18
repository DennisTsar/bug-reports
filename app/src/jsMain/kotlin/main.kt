import kotlinx.browser.document
import org.jetbrains.compose.web.renderComposable

fun main() {
    val x = CssStyle {}
    PublicStyleSheet.registerStyle("test") {
//        val test = "test" // !! Un-comment this line
    }
    renderComposable(document.createElement("div")) {
        x.toModifier()
    }
}
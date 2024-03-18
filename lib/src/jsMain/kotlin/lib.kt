import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

interface CustomModifier {
    companion object : CustomModifier
}

//@Immutable // fixes recompositions
interface RowScope

internal object RowScopeInstance : RowScope

fun <A> CustomModifier.toAttrs(finalHandler: (A.() -> Unit)? = null): A.() -> Unit {
    return {
        finalHandler?.invoke(this)
    }
}

@Composable
fun CustomRow(
    modifier: CustomModifier = CustomModifier,
    content: @Composable RowScope.() -> Unit,
) {
    Div(modifier.toAttrs()) {
        RowScopeInstance.content()
    }
}
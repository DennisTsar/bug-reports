import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface CustomModifier {
    companion object : CustomModifier
}

//@Immutable // fixes recompositions
interface RowScope

internal object RowScopeInstance : RowScope

fun <A> CustomModifier.toAttrs(finalHandler: (A.() -> Unit)? = null): Modifier {
    return Modifier
}

@Composable
fun CustomRow(
    modifier: CustomModifier = CustomModifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(modifier.toAttrs<String>()) {
        RowScopeInstance.content()
    }
}
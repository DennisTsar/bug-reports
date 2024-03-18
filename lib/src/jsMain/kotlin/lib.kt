import androidx.compose.runtime.Composable

val PublicStyleSheet: CssStyleRegistrar = SilkStylesheetInstance

sealed interface CssKind

sealed interface GeneralKind : CssKind

internal value class ClassSelectors(private val value: List<String>) {
    operator fun plus(other: ClassSelectors) = ClassSelectors(value + other.value)
}

abstract class StyleScope

abstract class CssStyle<K : CssKind> internal constructor(
    internal val init: CssStyleScope.() -> Unit,
) {
    internal fun addStylesInto(
        selector: String,
        layer: String?,
    ): ClassSelectors {
        val classNames = mutableListOf(selector)
        return ClassSelectors(classNames)
    }

    internal fun intoImmutableStyle(classSelectors: ClassSelectors) =
        ImmutableCssStyle(classSelectors)

    companion object // for extensions
}

internal class SimpleCssStyle(
    val selector: String,
    init: CssStyleScope.() -> Unit,
    val layer: String?,
) : CssStyle<GeneralKind>(init)


internal class ImmutableCssStyle(
    classSelectors: ClassSelectors,
)


interface CssStyleScopeBase
class CssStyleScope internal constructor() : CssStyleScopeBase, StyleScope()


fun CssStyle(init: CssStyleScope.() -> Unit) =
    object : CssStyle<GeneralKind>(init) {}

@Composable
fun CssStyle<GeneralKind>.toModifier() = Unit

interface CssStyleRegistrar {
    fun registerStyle(cssSelector: String, init: StyleScope.() -> Unit)
}

interface SilkStylesheet : CssStyleRegistrar {
    val cssLayers: MutableList<String>
    fun layer(name: String, block: CssStyleRegistrar.() -> Unit)
}

private class CssStyleRegistrarImpl : CssStyleRegistrar {
    class Entry(val cssSelector: String, val init: StyleScope.() -> Unit)

    private val _entries = mutableListOf<Entry>()
    val entries: List<Entry> = _entries

    override fun registerStyle(
        cssSelector: String,
        init: StyleScope.() -> Unit,
    ) {
        _entries.add(Entry(cssSelector, init))
    }
}


internal object SilkStylesheetInstance : SilkStylesheet {
    private val styles = mutableListOf<SimpleCssStyle>()

    override val cssLayers = mutableListOf<String>()

    override fun registerStyle(
        cssSelector: String,
        init: StyleScope.() -> Unit,
    ) {
        styles.add(SimpleCssStyle(cssSelector, init, layer = "base"))
    }

    override fun layer(name: String, block: CssStyleRegistrar.() -> Unit) {
        CssStyleRegistrarImpl().apply(block).entries.forEach { entry ->
            styles.add(
                SimpleCssStyle(
                    entry.cssSelector,
                    entry.init,
                    layer = name.takeIf { it.isNotEmpty() }
                )
            )
        }
    }
}
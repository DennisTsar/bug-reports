package lib

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable

// non-inline composable
@Composable
fun RowWrapper(content: @Composable () -> Unit) {
    Row {
        content()
    }
}

@Composable
fun UsedFunction() {
    RowWrapper {
        BasicText("This function is USED")
    }
}

@Composable
fun UnusedFunction() {
    RowWrapper {
        BasicText("This function is UNUSED")
    }
}
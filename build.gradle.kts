plugins {
    kotlin("multiplatform") version "2.2.0"
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
    sourceSets.jsMain.dependencies {
        implementation("org.jetbrains.compose.html:html-core:1.8.0")
        implementation("com.varabyte.kobweb:kobweb-silk:0.23.0") // not used but needed for the exception
    }
}
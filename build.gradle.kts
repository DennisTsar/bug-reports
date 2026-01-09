plugins {
    kotlin("multiplatform") version "2.1.0"
    kotlin("plugin.compose") version "2.1.0"
}

repositories {
    mavenCentral()
    google()
}

kotlin {
    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation("org.jetbrains.compose.html:html-core:1.9.3")
            implementation("org.jetbrains.compose.runtime:runtime:1.9.3")
        }
    }
}
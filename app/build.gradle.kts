plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
    id("org.jetbrains.compose") version "1.6.11"
    // No issue with the below versions on JS
//    kotlin("multiplatform") version "1.9.22"
//    id("org.jetbrains.compose") version "1.5.12"
}

group = "com.example"

kotlin {
    jvm()
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(project(":lib"))
        }
        jsMain.dependencies {
            implementation(compose.html.core)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.common)
            implementation(compose.desktop.currentOs)
        }
    }
}
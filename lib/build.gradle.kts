plugins {
    kotlin("multiplatform") version "2.0.20"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.20"
    id("org.jetbrains.compose") version "1.7.1"
}

group = "com.example"

kotlin {
    jvm()
    js {
        browser()
        binaries.library()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
        }
    }
}
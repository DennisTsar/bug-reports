plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
    }
    sourceSets {
        jsMain.dependencies {
            implementation("org.jetbrains.compose.runtime:runtime:1.6.10")
        }
    }
}
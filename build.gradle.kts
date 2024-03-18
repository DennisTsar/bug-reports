plugins {
    kotlin("multiplatform") version "2.0.0-Beta4"
    id("org.jetbrains.compose") version "1.6.1"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
    }
}
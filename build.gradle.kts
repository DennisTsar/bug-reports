plugins {
    kotlin("multiplatform") version "2.0.0-RC1"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
}
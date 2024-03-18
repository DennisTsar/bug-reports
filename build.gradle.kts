plugins {
    kotlin("multiplatform") version "2.1.20-Beta2"
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
    }
}
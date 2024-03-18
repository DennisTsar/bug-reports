plugins {
    kotlin("multiplatform") version "2.2.20-RC"
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {
            commonWebpackConfig {} // comment out this line to fix
        }
        binaries.executable()
    }
}
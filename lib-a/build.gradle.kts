plugins {
    kotlin("multiplatform") version "2.0.0"
}

group = "com.example"

repositories {
    mavenCentral()
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
}

kotlin {
    js {
        browser()
    }
    sourceSets {
        jsMain.dependencies {
            implementation("org.jetbrains.compose.html:html-core:1.6.2")
        }
    }
}
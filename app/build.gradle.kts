plugins {
    kotlin("multiplatform") version "2.0.0"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
        compilerOptions.target = "es2015"
    }
    sourceSets {
        jsMain.dependencies {
            implementation("org.jetbrains.compose.html:html-core:1.6.2")
            implementation(project(":lib-a"))
        }
    }
}
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

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
        binaries.executable()
        // Issue is present with or without es2015 target
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.target = "es2015"
    }
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(project(":lib"))
        }
        jvmMain.dependencies {
            implementation(compose.desktop.common)
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop.application {
    mainClass = "MainKt"

    nativeDistributions {
        targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
    }
}
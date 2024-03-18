import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform") version "2.0.0-Beta5"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser()
        binaries.executable()
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.freeCompilerArgs.add("-Xir-generate-inline-anonymous-functions")
    }
}
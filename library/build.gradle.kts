plugins {
    kotlin("multiplatform") version "2.0.0-Beta4"
}

group = "com.example"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        browser()
    }
}
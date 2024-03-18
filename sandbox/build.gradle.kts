plugins {
    kotlin("multiplatform") version "2.0.0-Beta4"
}

repositories {
    mavenCentral()
}

group = "com.example"

kotlin {
    jvm()
    js {
        browser()
    }
    sourceSets {
        // replace with jvmMain and the issue goes away
        jsMain.dependencies {
            api("com.example:library")
        }
    }
}
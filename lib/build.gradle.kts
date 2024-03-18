plugins {
    kotlin("multiplatform")
}

group = "com.example"

kotlin {
    jvm()
    js {
        browser()
        binaries.library()
    }
}
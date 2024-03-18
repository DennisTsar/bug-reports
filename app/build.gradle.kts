plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
}

group = "com.example"

kotlin {
    jvm()
    js {
        browser()
        binaries.executable()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(project(":lib"))
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":test-processor"))
    add("kspJvm", project(":test-processor"))
    add("kspJs", project(":test-processor"))
}
pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "example"

includeBuild("library")
includeBuild("sandbox")
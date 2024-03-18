pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "example"

includeBuild("sandbox")

include(":library")
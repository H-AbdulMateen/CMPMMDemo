rootProject.name = "CMPMMDemo"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core:common")
include(":core:domain")
include(":core:network")
include(":core:ui")
include(":core:navigation")
include(":feature:auth")
include(":feature:main")
include(":feature:products")
include(":feature:profile")
include(":feature:cart")
include(":feature:wishlist")
include(":di")
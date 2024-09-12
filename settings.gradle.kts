pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Keep Safe"
include(":app")
include(":core:data:room_db")
include(":core:ui:theme")
include(":navigation")
include(":features:auth")
include(":features:home")
include(":core:model")
include(":core:application")
include(":core:utils")
include(":features:familyinfo")

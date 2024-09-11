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

rootProject.name = "Keepsafe"
include(":app")
include(":navigation")
include(":theme")
include(":features:fam_info")
include(":core:data:preferences")
include(":core:data:firebase")
include(":core:data:room_db")
include(":core:domain")
include(":components")
include(":core:work")
include(":core:utils")
include(":features:home")
include(":features:settings")
include(":features:gallery")

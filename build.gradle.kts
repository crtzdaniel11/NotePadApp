plugins {
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.kapt") // Explicitly apply kapt}

// You may include any global repositories or configurations here:
    dependencyResolutionManagement {
        repositories {
            google()
            mavenCentral()
        }
    }

    rootProject.name = "NotepadApp"
    //change 1
//change 2

}

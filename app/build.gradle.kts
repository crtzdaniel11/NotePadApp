plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt") // Explicitly apply kapt plugin
}

android {
    namespace = "com.example.notepadapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notepadapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Update if using a newer Compose version
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Compose UI
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.tooling.preview)
    implementation(libs.activity.compose)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material.icons.core)
    implementation(libs.compose.material.icons.extended)

    // Navigation for Compose
    implementation(libs.compose.navigation)

    // AndroidX
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    // Room Database
    kapt("androidx.room:room-compiler:2.5.0") // Ensure this is present
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    // Testing Dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Debugging Tools for Compose
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}

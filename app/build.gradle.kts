plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.stableproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.stableproject"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        android {
            buildFeatures {
                viewBinding = true
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    //implementation(libs.androidx.ui)
    implementation(libs.androidx.appcompat)
    //implementation(libs.androidx.camera.core)
    //implementation(libs.androidx.camera.camera2)
    //implementation(libs.androidx.camera.lifecycle)
    //implementation(libs.androidx.camera.video)
    //implementation(libs.androidx.camera.view)
    //implementation(libs.androidx.camera.extensions)
    implementation(libs.androidx.constraintlayout)
    //implementation(libs.play.services.location)
    //implementation(libs.androidx.recyclerview)
    //implementation(libs.androidx.ui)
    //implementation(libs.recyclerview.v7)
    //implementation(libs.androidx.ui.tooling)
    implementation(libs.material)
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.play.services.location)
    implementation(libs.androidx.camera.view)
    //implementation(libs.androidx.recyclerview)
    //implementation(libs.androidx.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //androidTestImplementation(platform(libs.androidx.compose.bom))
    //androidTestImplementation(libs.androidx.ui.test.junit4)
    //debugImplementation(libs.androidx.ui.tooling)
    //debugImplementation(libs.androidx.ui.test.manifest)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}
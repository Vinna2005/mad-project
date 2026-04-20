plugins {
<<<<<<< HEAD
    alias(libs.plugins.android.application)
=======
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
}

android {
    namespace = "com.example.expirytracker"
<<<<<<< HEAD
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }
=======
    compileSdk = 34
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3

    defaultConfig {
        applicationId = "com.example.expirytracker"
        minSdk = 24
<<<<<<< HEAD
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
=======
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
<<<<<<< HEAD
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Add this line:
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
=======

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = false
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.android.gms:play-services-auth:21.0.0")
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
}
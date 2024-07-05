plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.mint.newsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mint.newsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material:material") // Compose Material Components
//
//    // Retrofit core library
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    // Gson converter for Retrofit
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    // OkHttp library (optional, if you need advanced logging)
//    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
//
//    // Coroutine dependencies
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
//
//    // Coil for image loading
//    implementation("io.coil-kt:coil-compose:1.3.2")
//
//    // Navigation Component for Compose
//    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
//
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//}
//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material:material") // Compose Material Components
//
//    // Retrofit core library
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    // Gson converter for Retrofit
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    // OkHttp library (optional, if you need advanced logging)
//    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
//
//    // Coroutine dependencies
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
//
//    // Coil for image loading
//    implementation("io.coil-kt:coil-compose:1.3.2")
//
//    // Navigation Component for Compose
//    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
//
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")

    // Retrofit core library
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter for Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // OkHttp library (optional, if you need advanced logging)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Coroutine dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    // Coil for image loading
    implementation("io.coil-kt:coil-compose:1.3.2")

    // Navigation Component for Compose
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")

    // Compose runtime
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.runtime:runtime-livedata")

    // For collectAsState
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha01")
    implementation(libs.androidx.material3.android)
    implementation(libs.generativeai)
    implementation(libs.androidx.room.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
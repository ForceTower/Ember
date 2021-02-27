plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jmailen.kotlinter")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(platform(project(":dependencies")))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":model"))

    // Kotlin
    implementation(Libs.KOTLIN_STDLIB)

    // Networking
    implementation(Libs.OK_HTTP)
    implementation(Libs.OK_HTTP_LOGGING)
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)

    // Tests
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROID_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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

    buildFeatures {
        dataBinding = true
    }

    kapt {
        correctErrorTypes = true
        javacOptions {
            option("-Xmaxerrs", 1000)
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
    implementation(Libs.KOTLIN_STDLIB)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android X
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.SWIPE_REFRESH)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.MATERIAL)
    implementation(Libs.FRAGMENT)

    // Navigation
    implementation(Libs.NAVIGATION_UI)
    implementation(Libs.NAVIGATION_FRAGMENT)

    // Paging
    implementation(Libs.PAGING)

    // Dependency injection
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_COMPILER)

    // Logs
    implementation(Libs.TIMBER)

    // Image
    implementation(Libs.GLIDE)
    implementation(Libs.GLIDE_TRANSFORMATIONS)

    // Network
    implementation(Libs.OK_HTTP)

    // Tests
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROID_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}

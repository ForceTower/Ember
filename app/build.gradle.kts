plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("org.jmailen.kotlinter")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)

    defaultConfig {
        applicationId = "dev.forcetower.ember"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        ndkVersion = "21.3.6528147"
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

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }

    kapt {
        correctErrorTypes = true
        javacOptions {
            option("-Xmaxerrs", 1000)
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        targetCompatibility =  JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        exclude("META-INF/gradle/*")
    }
}

dependencies {
    api(platform(project(":dependencies")))
    kapt(platform(project(":dependencies")))

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation(Libs.KOTLIN_STDLIB)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":toolkit"))

    implementation(Libs.CORE_KTX)

    // UI
    implementation(Libs.APPCOMPAT)
    implementation(Libs.SWIPE_REFRESH)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.FRAGMENT)
    implementation(Libs.MATERIAL)
    implementation(Libs.RECYCLER_VIEW)
    implementation(Libs.VIEW_PAGER_2)

    // Dependency Injection
    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)

    // Navigation
    implementation(Libs.NAVIGATION_UI)
    implementation(Libs.NAVIGATION_FRAGMENT)

    // Paging
    implementation(Libs.PAGING)

    // Logs
    implementation(Libs.TIMBER)

    // Image
    implementation(Libs.GLIDE)
    kapt(Libs.GLIDE_COMPILER)

    // Tests
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROID_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}
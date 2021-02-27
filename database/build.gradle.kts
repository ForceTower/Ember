plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
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

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
                arguments["room.schemaLocation"] = "$projectDir/schemas"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    kapt(platform(project(":dependencies")))
    implementation(Libs.KOTLIN_STDLIB)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":model"))

    // Android X
    implementation(Libs.CORE_KTX)

    // Room
    implementation(Libs.ROOM_KTX)
    implementation(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_COMPILER)

    // Paging
    implementation(Libs.PAGING)

    // Logs
    implementation(Libs.TIMBER)

    // Tests
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.ANDROID_JUNIT)
    androidTestImplementation(Libs.ESPRESSO)
}
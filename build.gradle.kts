// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
        maven("http://oss.sonatype.org/content/repositories/snapshots")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}")
        classpath("com.github.triplet.gradle:play-publisher:${Versions.PLAY_PUBLISHER}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("org.jmailen.gradle:kotlinter-gradle:${Versions.KOTLIN_LINT}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
        maven("http://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io")
    }
}

subprojects {
    if (!name.contains("toolkit")) {
        tasks.whenTaskAdded {
            if (name == "preBuild") {
                mustRunAfter("lintKotlin")
            }
        }
    }
}

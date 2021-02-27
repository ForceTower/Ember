plugins {
    id("java-platform")
}

val appcompat = "1.1.0"
val core = "1.5.0-beta01"
val hiltJetPack = "1.0.0-alpha03"
val hilt = Versions.HILT
val swipeRefresh = "1.1.0"
val constraintLayout = "2.0.4"
val material = "1.3.0"
val recyclerView = "1.2.0-beta02"
val fragment = "1.3.0"
val viewPager2 = "1.0.0"
val paging = "3.0.0-beta01"
val timber = "4.7.1"
val okhttp = "4.9.0"
val retrofit = "2.9.0"
val glide = "4.12.0"
val glideTransformations = "4.1.0"
val room = "2.3.0-beta02"
val coroutines = "1.3.9"

val junit = "4.13.2"
val androidJUnit = "1.1.2"
val espresso = "3.3.0"


dependencies {
    constraints {
        api("${Libs.ANDROIDX_HILT_COMPILER}:$hiltJetPack")
        api("${Libs.APPCOMPAT}:$appcompat")
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.HILT_ANDROID}:$hilt")
        api("${Libs.HILT_COMPILER}:$hilt")
        api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")
        api("${Libs.SWIPE_REFRESH}:$swipeRefresh")
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.RECYCLER_VIEW}:$recyclerView")
        api("${Libs.FRAGMENT}:$fragment")
        api("${Libs.VIEW_PAGER_2}:$viewPager2")
        api("${Libs.NAVIGATION_UI}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_FRAGMENT}:${Versions.NAVIGATION}")
        api("${Libs.PAGING}:$paging")
        api("${Libs.TIMBER}:$timber")
        api("${Libs.OK_HTTP}:$okhttp")
        api("${Libs.OK_HTTP_LOGGING}:$okhttp")
        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.RETROFIT_GSON}:$retrofit")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.GLIDE_COMPILER}:$glide")
        api("${Libs.GLIDE_TRANSFORMATIONS}:$glideTransformations")
        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")
        api("${Libs.COROUTINES}:$coroutines")

        api("${Libs.JUNIT}:$junit")
        api("${Libs.ANDROID_JUNIT}:$androidJUnit")
        api("${Libs.ESPRESSO}:$espresso")
    }
}
include(":network")
include(":data")
include (
    ":dependencies",
    ":toolkit",
    ":model",
    ":database",
    ":app"
)
project(":toolkit").projectDir = File(rootDir, "android-toolkit/toolkit")
rootProject.name = "Ember"
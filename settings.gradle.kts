include (
    ":dependencies",
    ":toolkit",
    ":model",
    ":database",
    ":network",
    ":domain",
    ":app"
)
project(":toolkit").projectDir = File(rootDir, "android-toolkit")
rootProject.name = "Ember"
plugins {
    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/compose-module.gradle")
android {
    namespace = "com.sayatcode.onboarding_presentation"
}
dependencies {
    implementation(project(Modules.onboardingDomain))
    implementation(project(Modules.core))
}
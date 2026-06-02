// Top-level build file where you can add configuration options common to all sub-projects/modules.

// root build.gradle.kts
buildscript {
    dependencies {
        classpath(Build.ksp)  // если есть buildSrc с объектом Build
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}
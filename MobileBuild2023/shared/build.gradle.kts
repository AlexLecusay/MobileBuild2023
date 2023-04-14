plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.realm.kotlin")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-6"
}
dependencies {
    implementation("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-3")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.1")
    implementation("io.realm.kotlin:library-base:1.7.0")
    implementation("io.realm.kotlin:library-sync:1.7.0")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        all{
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }
        val commonMain by getting {
            dependencies {
                implementation("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-3")
                implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.1")
                implementation("io.realm.kotlin:library-sync:1.7.0")
                implementation("io.realm.kotlin:library-base:1.7.0")
                implementation("io.realm.kotlin:library-sync:1.7.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.roaryminder"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}

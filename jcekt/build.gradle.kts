@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    `maven-publish`
    id("com.jfrog.bintray")
}

kotlin {
    explicitApi()

    targets {
        jvm()
        js()

        // TODO native targets
    }

    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
        }

        val commonMain by getting {
            dependencies {
                api(kotlinx("serialization-runtime", Versions.Kotlin.serialization))
                api(kotlinx("io", Versions.Kotlin.io))
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlinx("io-jvm", Versions.Kotlin.io))
            }
        }

        val jsMain by getting {
            dependencies {
                api(kotlinx("io-js", Versions.Kotlin.io))
            }
        }


        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmTest by getting {
            dependencies {
                dependsOn(commonTest)
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }

        val jsTest by getting {
            dependencies {
                dependsOn(commonTest)
                implementation(kotlin("test-js"))
            }
        }
    }
}

apply(from = "../gradle/publish.gradle")
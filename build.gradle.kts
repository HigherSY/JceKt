import java.lang.System.getProperty

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.stdlib}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin.stdlib}")
    }
}

plugins {
    id("com.jfrog.bintray") version Versions.Publishing.bintray apply false
}

allprojects {
    group = "moe.him188"
    version = Versions.JceKt.version

    repositories {
        mavenCentral()
        jcenter()
    }
}
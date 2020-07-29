object Versions {
    object JceKt {
        const val version = "2.0.0-1.4.0-rc"
    }

    object Kotlin {
        const val stdlib = "1.4.0-rc"
        const val serialization = "1.0-M1-1.4.0-rc"

        const val io = "0.1.16"
    }

    object Publishing {
        const val bintray = "1.8.5"
    }
}

@Suppress("unused")
fun kotlinx(id: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$id:$version"
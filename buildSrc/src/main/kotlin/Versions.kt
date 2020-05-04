object Versions {
    object JceKt {
        const val version = "1.0.0"
    }

    object Kotlin {
        const val stdlib = "1.3.71"
        const val serialization = "0.20.0"

        const val io = "0.1.16"
    }

    object Publishing {
        const val bintray = "1.8.5"
    }
}

@Suppress("unused")
fun kotlinx(id: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$id:$version"
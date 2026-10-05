plugins {
    // Daftarkan plugin Kotlin JVM global
    kotlin("jvm") version "1.9.24" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "application")

    repositories {
        mavenCentral()
    }

    // Cara penulisan dependencies global yang benar di dalam subprojects
    dependencies {
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    }

    // Menggunakan Java Toolchain global (Java 21) agar selaras dengan sistem Anda
    configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
        jvmToolchain(21)
    }
}

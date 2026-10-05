plugins {
    // Memanggil ulang aplikasi agar sub-folder ini punya akses task 'run'
    id("application")
}

application {
    mainClass.set("LatihanKt")
}

// Mengambil input dari terminal (Default ke handson1-latihan jika tidak diisi)
val targetHO = project.findProperty("ho")?.toString() ?: "handson1-latihan"

sourceSets {
    main {
        kotlin {
            // Mengosongkan jalur bawaan dan menembak langsung ke folder target
            setSrcDirs(listOf("$targetHO/src/main/kotlin"))
        }
    }
}

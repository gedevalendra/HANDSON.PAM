import kotlinx.coroutines.*

// Hands-on 3: Structured Concurrency & Cancellation
// Tugas: Implementasikan DownloadManager yang men-download beberapa "file"
// (disimulasikan dengan delay) sebagai child coroutine dari satu Job. Jika
// Job tersebut dibatalkan (cancel), SEMUA child coroutine yang belum
// selesai harus ikut berhenti (ini yang disebut structured concurrency).

class DownloadManager(private val scope: CoroutineScope) {

    fun downloadFile(name: String, durationMs: Long): Job {
        // TODO 1: Gunakan scope.launch untuk membuat child coroutine baru.
        //         Di dalamnya:
        //         - delay(durationMs) untuk simulasi proses download
        //         - println("$name selesai di-download") setelah delay
        //         Kembalikan Job dari launch tersebut.
        val job = scope.launch {
            delay(durationMs)
            println("$name selesai di-download")
        }
        return job
    }
}

fun main() = runBlocking {
    // TODO 2: Buat sebuah Job induk (parent) baru dengan Job()
    // Ini akan bertindak sebagai pengontrol utama (parent) untuk semua
    // coroutine anak (child) yang diluncurkan di bawahnya.
    val parentJob = Job()

    // TODO 3: Buat CoroutineScope baru dari parentJob tersebut
    //         (gunakan CoroutineScope(parentJob))
    // Scope ini menjadi "ruang lingkup" yang terikat pada parentJob.
    val scope = CoroutineScope(parentJob)

    val manager = DownloadManager(scope)

    // Memulai 3 proses download secara bersamaan (concurrent)
    manager.downloadFile("foto.jpg", 1000)
    manager.downloadFile("video.mp4", 3000)
    manager.downloadFile("dokumen.pdf", 1500)

    // Main coroutine menunggu selama 1.2 detik
    // Dalam waktu ini:
    // - foto.jpg (1000ms) akan selesai dan tercetak
    // - dokumen.pdf (1500ms) dan video.mp4 (3000ms) masih berjalan
    delay(1200)

    println("Membatalkan sisa download...")

    // TODO 4: Batalkan parentJob dengan cancel()
    // Membatalkan parentJob secara otomatis akan membatalkan SEMUA
    // coroutine anak (dokumen.pdf dan video.mp4) yang masih aktif.
    parentJob.cancel()

    // Menunggu 2 detik tambahan untuk membuktikan bahwa
    // dokumen.pdf dan video.mp4 benar-benar dibatalkan dan tidak mencetak "selesai".
    delay(2000)
    println("Selesai.")
}

// Output yang diharapkan:
// foto.jpg selesai di-download
// Membatalkan sisa download...
// Selesai.
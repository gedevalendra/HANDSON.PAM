import java.util.concurrent.Callable
import java.util.concurrent.Executors

// Hands-on 2: ExecutorService & Future
// Tugas: Jalankan 4 "task" perhitungan yang lambat (simulasi delay dengan
// Thread.sleep) secara PARALEL menggunakan thread pool, lalu kumpulkan semua
// hasilnya. Jika dijalankan sequential, total waktu ~4 detik. Dengan thread
// pool 4 pekerja, seharusnya total waktu ~1 detik.

fun hitungKuadrat(n: Int): Int {
    Thread.sleep(1000) // Simulasi kerja berat (1 detik)
    return n * n
}

fun main() {
    val angka = listOf(1, 2, 3, 4)
    val startTime = System.currentTimeMillis()

    // TODO 1: Buat ExecutorService dengan Executors.newFixedThreadPool(4)
    // Membuat kolam thread (thread pool) yang berisi 4 pekerja (worker) aktif.
    val executor = Executors.newFixedThreadPool(4)

    // TODO 2: Submit satu Callable per angka ke executor, simpan Future-nya
    // Setiap pemanggilan submit() akan memberikan task ke salah satu thread pekerja
    // dan langsung mengembalikan objek Future sebagai "janji" bahwa hasilnya akan ada nanti.
    val futures = angka.map { n -> executor.submit(Callable { hitungKuadrat(n) }) }

    // TODO 3: Ambil semua hasil dengan future.get(), lalu tampilkan
    // future.get() akan memblokir (menunggu) sampai thread pekerja selesai menghitung tugasnya.
    // Karena 4 tugas berjalan paralel di 4 thread, penantian totalnya hanya sekitar 1 detik.
    val hasil = futures.map { it.get() }
    println("Hasil: $hasil")

    // TODO 4: Jangan lupa shutdown() executor supaya program bisa berhenti (JVM
    // tidak akan exit selama thread pool masih hidup)
    // shutdown() memberitahu executor untuk menolak tugas baru dan mematikan semua thread
    // setelah tugas-tugas yang sedang berjalan selesai.
    executor.shutdown()

    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")

    // Expected Output:
    // Hasil: [1, 4, 9, 16]
    // Waktu: ~1000ms (sedikit lebih dari 1000ms, bukan 4000ms)
}
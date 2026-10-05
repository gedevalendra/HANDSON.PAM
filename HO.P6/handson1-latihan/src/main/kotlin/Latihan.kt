import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

// Hands-on 1: Race Condition
// Tugas: Dua thread meng-increment sebuah shared counter (var c) sebanyak
// 100_000x masing-masing secara BERSAMAAN. Karena c++ bukan operasi atomik
// (baca-ubah-tulis, bisa saling menyela/interleave antar thread), hasil akhirnya
// SERING SALAH (bukan 200_000) — itulah race condition.

class Counter {
    // TODO 1 & 2: Menggunakan AtomicInteger agar thread-safe
    // val digunakan alih-alih var karena referensi objek AtomicInteger tidak berubah,
    // hanya nilai di dalamnya yang berubah.
    private val c = AtomicInteger(0)

    fun increment() {
        // incrementAndGet() adalah operasi atomik tunggal (satu kesatuan instruksi CPU)
        // yang tidak bisa disela oleh thread lain.
        c.incrementAndGet()
    }

    fun value(): Int {
        // get() mengambil nilai integer secara aman
        return c.get()
    }
}

fun main() {
    val counter = Counter()
    val iterasi = 100_000

    val t1 = thread {
        repeat(iterasi) { counter.increment() }
    }
    val t2 = thread {
        repeat(iterasi) { counter.increment() }
    }

    // .join() memaksa main thread untuk menunggu t1 dan t2 selesai bekerja
    // sebelum mengeksekusi baris println di bawahnya.
    t1.join()
    t2.join()

    println("Hasil akhir: ${counter.value()} (seharusnya ${iterasi * 2})")
}
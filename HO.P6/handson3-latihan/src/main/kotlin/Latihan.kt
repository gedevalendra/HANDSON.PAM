import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

// Hands-on 3: Producer-Consumer dengan BlockingQueue
// Tugas: Implementasikan pola producer-consumer menggunakan LinkedBlockingQueue.
// Satu thread producer menaruh 5 pesan ke queue (dengan delay 200ms per pesan),
// satu thread consumer mengambil dan mencetak pesan itu satu per satu.
// Consumer harus berhenti setelah menerima tanda "selesai" dari producer.

const val PESAN_SELESAI = "SELESAI"

fun main() {
    // TODO 1: Buat LinkedBlockingQueue<String> untuk komunikasi antar thread
    // Antrean ini bertindak sebagai buffer yang thread-safe.
    val queue = LinkedBlockingQueue<String>()

    val producer = thread {
        for (i in 1..5) {
            val pesan = "Pesan #$i"

            // TODO 2: Masukkan pesan ke queue dengan queue.put(pesan)
            // put() bersifat blocking: jika antrean sudah penuh (jika ada batas kapasitas),
            // ia akan menunggu sampai ada ruang kosong.
            queue.put(pesan)

            println("[Producer] mengirim: $pesan")
            Thread.sleep(200) // Simulasi waktu pembuatan pesan
        }

        // TODO 3: Kirim PESAN_SELESAI ke queue sebagai tanda producer sudah selesai
        queue.put(PESAN_SELESAI)
        println("[Producer] selesai mengirim semua pesan.")
    }

    val consumer = thread {
        while (true) {
            // TODO 4: Ambil pesan dari queue dengan queue.take() (blocking, menunggu jika queue kosong)
            // take() akan membuat thread Consumer "tertidur" dan tidak memakan CPU
            // sampai ada pesan baru yang dimasukkan oleh Producer.
            val pesan = queue.take()

            // TODO 5: Jika pesan == PESAN_SELESAI, hentikan loop (break)
            if (pesan == PESAN_SELESAI) {
                println("[Consumer] menerima sinyal berhenti.")
                break
            }

            // TODO 6: Jika bukan, cetak pesan
            println("[Consumer] menerima: $pesan")
        }
    }

    // Tunggu kedua thread selesai bekerja sebelum program utama (main thread) berakhir
    producer.join()
    consumer.join()

    println("Selesai!")
}
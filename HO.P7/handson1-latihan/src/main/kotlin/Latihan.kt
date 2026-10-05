import kotlinx.coroutines.*

// Hands-on 1: Suspend Function Dasar
// Tugas: Buat suspend function checkOrderStatus() yang mensimulasikan
// panggilan ke server untuk mengecek status pesanan (delay 2 detik),
// lalu panggil dari dalam coroutine sehingga main thread TIDAK ter-blok
// selama menunggu.

suspend fun checkOrderStatus(orderId: String): String {
    // TODO 1: Simulasikan network delay 2000ms dengan delay()
    delay(2000)

    // TODO 2: Kembalikan String "Order $orderId: SHIPPED"
    return "Order $orderId: SHIPPED"
}

fun main() = runBlocking {
    // TODO 4: Sebelum menunggu hasilnya, cetak dulu "Menunggu status pesanan..."
    //         supaya terlihat bahwa program tetap berjalan (tidak blocking thread).
    println("Menunggu status pesanan...")

    // TODO 3: Panggil checkOrderStatus("A100") dari dalam coroutine ini
    //         (runBlocking sendiri adalah CoroutineScope, jadi bisa langsung
    //         memanggil suspend fun di sini).
    val status = checkOrderStatus("A100")

    // Menampilkan hasil setelah delay selesai
    println(status)
}
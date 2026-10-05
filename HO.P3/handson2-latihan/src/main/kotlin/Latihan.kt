// Hands-on 2: Bounded Type Parameter
// Tugas: Buat fungsi generik findMax yang mencari nilai terbesar dari sebuah
// List<T>, dengan syarat T harus bisa dibandingkan (Comparable<T>).
// Ini mirip alasan quickSort butuh constraint T : Comparable<T> di slide.

// TODO 1 & 2: Tambahkan bounded type parameter <T : Comparable<T>> dan ganti signature
fun <T : Comparable<T>> findMax(items: List<T>): T {
    // TODO 3: Lempar IllegalArgumentException jika items kosong
    if (items.isEmpty()) {
        throw IllegalArgumentException("List tidak boleh kosong")
    }

    // TODO 4: Iterasi list, bandingkan setiap elemen dengan compareTo, simpan yang terbesar
    // Kita inisialisasi elemen pertama sebagai nilai maksimal sementara
    var maxItem = items[0]

    // Iterasi sisa elemen di dalam list
    for (item in items) {
        // Di Kotlin, operator '>' otomatis memanggil fungsi 'compareTo'.
        // if (item > maxItem) ekuivalen dengan if (item.compareTo(maxItem) > 0)
        if (item > maxItem) {
            maxItem = item
        }
    }

    return maxItem
}

fun main() {
    println(findMax(listOf(3, 7, 2, 9, 4)))          // Output: 9

    // Test case ini sekarang bisa dijalankan (silakan hilangkan komentar)
    println(findMax(listOf(1.5, 2.8, 0.3)))        // Output: 2.8
    println(findMax(listOf("apel", "jeruk", "duku"))) // Output: jeruk (berdasarkan urutan alfabet/ASCII)
}
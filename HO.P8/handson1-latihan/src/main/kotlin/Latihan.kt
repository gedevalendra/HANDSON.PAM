// Hands-on 1: Try-Catch-Finally Dasar
// Tugas: Lengkapi fungsi safeDivide agar menangani pembagian dengan nol
// menggunakan try-catch-finally, tanpa membuat program crash.

fun safeDivide(a: Int, b: Int): Int {
    // TODO 1 & 2: Bungkus di dalam try, tangkap ArithmeticException, dan kembalikan 0.
    // Di Kotlin, try-catch bisa digunakan sebagai nilai kembalian (expression).
    return try {
        a / b
    } catch (e: ArithmeticException) {
        println("Error: Tidak bisa membagi dengan nol! (${e.message})")
        0 // Nilai 0 ini akan dikembalikan (return) jika terjadi error
    } finally {
        // TODO 3: Di blok finally, cetak pesan ini.
        // Blok ini PASTI dieksekusi, entah pembagiannya sukses maupun gagal (masuk catch).
        println("safeDivide($a, $b) selesai diproses")
    }
}

fun main() {
    println("Hasil 1: ${safeDivide(10, 2)}")  // sukses -> 5
    println("---")
    println("Hasil 2: ${safeDivide(10, 0)}")  // b == 0 -> harus ditangani, hasil 0
    println("---")
    println("Hasil 3: ${safeDivide(9, 3)}")   // sukses -> 3
}

// Output yang dihasilkan:
// safeDivide(10, 2) selesai diproses
// Hasil 1: 5
// ---
// Error: Tidak bisa membagi dengan nol! (/ by zero)
// safeDivide(10, 0) selesai diproses
// Hasil 2: 0
// ---
// safeDivide(9, 3) selesai diproses
// Hasil 3: 3
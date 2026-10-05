// Hands-on 3: Loops, Ranges & Null Safety
// Tugas: Lengkapi ScoreBoard agar bisa menyaring skor yang valid (bukan null)
// dan berada dalam batas kelulusan, lalu tampilkan bilangan ganjil dengan loop.

class ScoreBoard(private val skorMentah: List<Int?>) {
    // TODO: Buat property `skorValid` bertipe List<Int> berisi skorMentah
    // tanpa elemen null. Gunakan fungsi filterNotNull().
    val skorValid: List<Int> = skorMentah.filterNotNull()

    fun skorKelulusan(batasLulus: Int): List<Int> {
        // TODO: Kembalikan skorValid yang >= batasLulus, diurutkan menurun.
        // Gunakan .filter { ... } dan .sortedDescending()
        return skorValid.filter { it >= batasLulus }.sortedDescending()
    }
}

fun cetakRentangGanjil(sampai: Int) {
    // TODO: Cetak semua bilangan GANJIL dari 1 sampai `sampai` (inklusif),
    // dipisah spasi, menggunakan for-loop dengan range ber-step:
    for (i in 1..sampai step 2) {
        print("$i ")
    }
    println() // Tambahan opsional: mencetak baris baru agar output rapi di console
}

fun main() {
    val papan = ScoreBoard(listOf(85, null, 72, 90, null, 55, 100))
    println("Skor lulus (>= 70): ${papan.skorKelulusan(70)}")

    cetakRentangGanjil(10)
}

// Output yang diharapkan:
// Skor lulus (>= 70): [100, 90, 85, 72]
// 1 3 5 7 9
// Hands-on 2: Control Flow — when sebagai Expression
// Tugas: Lengkapi fungsi gradeOf() yang mengembalikan huruf mutu berdasarkan
// nilai ujian (0-100), menggunakan `when` sebagai EXPRESSION (bukan statement),
// sebagai single-expression function.
//
// Aturan:
//   90-100 -> "A"
//   80-89  -> "B"
//   70-79  -> "C"
//   60-69  -> "D"
//   selain itu -> "E"

// Solusi: Menggunakan single-expression function (ditandai dengan tanda `=`)
fun gradeOf(nilai: Int): String = when (nilai) {
    in 90..100 -> "A"
    in 80..89  -> "B"
    in 70..79  -> "C"
    in 60..69  -> "D"
    else       -> "E"
}

fun main() {
    val nilaiMahasiswa = listOf(95, 82, 71, 60, 45)
    for (nilai in nilaiMahasiswa) {
        println("Nilai $nilai -> Grade${gradeOf(nilai)}")
    }
}
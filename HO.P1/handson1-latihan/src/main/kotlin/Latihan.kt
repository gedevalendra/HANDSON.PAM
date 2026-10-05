fun describeProfile(nama: String, umur: Int?, kota: String = "Tidak diketahui"): String {
    val umurText = umur?.let {"$it tahun"} ?: "umur tidak diketahui"
    return "Nama : $nama, Umur : $umur, Kota : $kota"
}

fun main() {
    println(describeProfile("Andi", 20, "Bandar Lampung"))
    println(describeProfile("Budi", null))
    println(describeProfile(nama = "Citra", umur = 19))
}
// Output yang diharapkan:
// Nama: Andi, Umur: 20 tahun, Kota: Bandar Lampung
// Nama: Budi, Umur: umur tidak diketahui, Kota: Tidak diketahui
// Nama: Citra, Umur: 19 tahun, Kota: Tidak diketahui

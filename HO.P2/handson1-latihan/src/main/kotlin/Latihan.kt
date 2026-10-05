// Hands-on 1: Class & Inheritance
// Tugas: Buat hierarki class kendaraan menggunakan open class, primary constructor,
// dan override fungsi. Vehicle adalah base class, Car dan Motorcycle adalah turunannya.

// TODO 1: Jadikan class ini "open" agar bisa diturunkan (inherited).
// Menambahkan keyword `open` sebelum `class`.
open class Vehicle(val name: String, val maxSpeed: Int) {

    // TODO 2: Jadikan fungsi ini "open" agar bisa di-override oleh subclass.
    // Menambahkan keyword `open` sebelum `fun`.
    open fun describe(): String {
        return "$name dapat melaju hingga$maxSpeed km/h"
    }
}

// TODO 3: Buat class Car sebagai turunan dari Vehicle.
class Car(name: String, val numberOfDoors: Int) : Vehicle(name, 180) {
    override fun describe(): String {
        // Kita bisa memanfaatkan super.describe() untuk memanggil string dari parent,
        // lalu menyambungnya dengan string spesifik Car.
        return "${super.describe()} dan punya$numberOfDoors pintu"
    }
}

// TODO 4: Buat class Motorcycle sebagai turunan dari Vehicle.
class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, 220) {
    override fun describe(): String {
        // Menggunakan conditional expression if/else untuk mengecek status sidecar
        val sidecarText = if (hasSidecar) "dengan sidecar" else "tanpa sidecar"
        return "${super.describe()} ($sidecarText)"
    }
}

fun main() {
    // TODO 5: Buat 1 instance Car dan 1 instance Motorcycle, masukkan ke list ini.
    val vehicles = listOf<Vehicle>(
        Car("Toyota", numberOfDoors = 4),
        Motorcycle("Ninja", hasSidecar = false),
        Motorcycle("Vespa", hasSidecar = true) // Tambahan contoh ekstra
    )

    // Polymorphism: setiap elemen dipanggil lewat interface Vehicle,
    // tapi describe() yang jalan adalah versi milik subclass masing-masing.
    vehicles.forEach { println(it.describe()) }
}
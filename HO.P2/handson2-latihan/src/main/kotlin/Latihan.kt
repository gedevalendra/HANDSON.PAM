// Hands-on 2: Interface & Data Class
// Tugas: Buat interface Payable dengan fungsi calculateSalary(), lalu implementasikan
// lewat data class Employee. Manfaatkan fitur bawaan data class: toString(), equals(),
// dan copy().

interface Payable {
    // TODO 1: Deklarasikan fungsi abstrak calculateSalary(): Double di interface ini.
    // (Interface tidak bisa punya state, tapi bisa punya fungsi abstrak.)
    fun calculateSalary(): Double
}

// TODO 2: Jadikan class ini "data class" agar otomatis mendapat equals(), hashCode(),
// toString(), dan copy(). Class ini harus implement interface Payable.
// Property: name (String), baseSalary (Double), bonus (Double).
data class Employee(val name: String, val baseSalary: Double, val bonus: Double) : Payable {

    // TODO 3: Override calculateSalary() agar mengembalikan baseSalary + bonus.
    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

fun main() {
    val alice = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)

    // TODO 4: Gunakan alice.copy(...) untuk membuat "bob" dengan name = "Bob",
    // baseSalary dan bonus sama seperti alice (tidak perlu ditulis ulang).
    val bob = alice.copy(name = "Bob")

    println("Gaji ${alice.name}: ${alice.calculateSalary()}")
    println("Gaji ${bob.name}: ${bob.calculateSalary()}")

    // TODO 5: Buat "aliceDuplicate" dengan data yang identik dengan alice (name,
    // baseSalary, bonus sama persis), lalu bandingkan dengan == (equals()).
    // Data class membandingkan berdasarkan ISI, bukan referensi objek.
    val aliceDuplicate = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)
    println("alice == aliceDuplicate? ${alice == aliceDuplicate}")

    // toString() bawaan data class akan mencetak semua property secara otomatis.
    println(alice)
}
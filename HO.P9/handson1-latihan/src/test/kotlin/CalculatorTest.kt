import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// Hands-on 1: Unit Test Dasar (pola Arrange-Act-Assert)
class CalculatorTest {

    // Instansiasi langsung mengambil dari main/kotlin/Calculator
    private val calculator = Calculator()

    @Test
    @DisplayName("Penjumlahan dua bilangan positif")
    fun testAdd() {
        // Arrange: siapkan dua bilangan, misalnya a = 2 dan b = 3
        val a = 2
        val b = 3

        // Act: panggil calculator.add(a, b) dan simpan hasilnya
        val hasil = calculator.add(a, b)

        // Assert: verifikasi hasilnya dengan assertEquals(expected, actual)
        assertEquals(5, hasil)
    }

    @Test
    @DisplayName("Pengurangan yang menghasilkan angka negatif")
    fun testSubtractNegativeResult() {
        // Arrange
        val a = 3
        val b = 5

        // Act
        val hasil = calculator.subtract(a, b)

        // Assert
        assertEquals(-2, hasil)
    }

    @Test
    @DisplayName("Pembagian dua bilangan bulat")
    fun testDivide() {
        // Arrange
        val a = 10
        val b = 2

        // Act
        val hasil = calculator.divide(a, b)

        // Assert
        assertEquals(5, hasil)
    }
}
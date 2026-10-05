import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Hands-on 2: Testing Exception
// Tugas: Lengkapi test untuk BankAccount, termasuk kasus withdraw() yang
// melempar InsufficientFundsException saat saldo tidak cukup.
//
// Konsep baru: assertThrows<TipeException> { ... } -- dari org.junit.jupiter.api,
// digunakan untuk memverifikasi bahwa sebuah blok kode MELEMPAR exception tertentu.

class BankAccountTest {

    @Test
    @DisplayName("Deposit menambah saldo dengan benar")
    fun testDeposit() {
        // Arrange: buat BankAccount dengan saldo awal 100.0
        val account = BankAccount(100.0)

        // Act: panggil deposit(50.0)
        account.deposit(50.0)

        // Assert: verifikasi saldo akhir menjadi 150.0
        assertEquals(150.0, account.balance)
    }

    @Test
    @DisplayName("Withdraw mengurangi saldo saat saldo cukup")
    fun testWithdrawSufficientBalance() {
        // Arrange
        val account = BankAccount(100.0)

        // Act
        account.withdraw(40.0)

        // Assert: saldo awal 100.0 dikurangi 40.0 = 60.0
        assertEquals(60.0, account.balance)
    }

    @Test
    @DisplayName("Withdraw melempar InsufficientFundsException saat saldo tidak cukup")
    fun testWithdrawInsufficientBalance() {
        // Arrange: buat BankAccount dengan saldo awal 50.0
        val account = BankAccount(50.0)

        // Act + Assert: pastikan error terlempar dengan tipe InsufficientFundsException
        val exception = assertThrows<InsufficientFundsException> {
            account.withdraw(100.0)
        }

        // Opsional (tapi disarankan): Memastikan pesan error yang keluar juga sesuai
        assertEquals("Saldo tidak cukup: saldo=50.0, diminta=100.0", exception.message)
    }
}
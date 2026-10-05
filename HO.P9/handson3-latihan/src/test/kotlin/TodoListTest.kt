import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// Hands-on 3: Test Lifecycle & Setup dengan @BeforeEach
// Tugas: Lengkapi setUp() supaya setiap test mendapat TodoList yang BARU dan
// KOSONG (tidak saling memengaruhi satu sama lain), lalu lengkapi ketiga test.

class TodoListTest {

    // lateinit mengizinkan kita mendeklarasikan variabel non-null tanpa
    // harus mengisinya langsung di sini.
    private lateinit var todoList: TodoList

    @BeforeEach
    fun setUp() {
        // TODO: inisialisasi todoList dengan TodoList() yang baru.
        // Method ini otomatis dipanggil OLEH JUNIT sesaat SEBELUM setiap @Test dieksekusi.
        // Hasilnya: setiap fungsi test akan selalu mendapatkan objek TodoList yang benar-benar bersih.
        todoList = TodoList()
    }

    @Test
    @DisplayName("TodoList baru harus kosong")
    fun testNewListIsEmpty() {
        // Assert
        assertTrue(todoList.isEmpty())
    }

    @Test
    @DisplayName("Menambah item menaikkan ukuran list")
    fun testAddIncreasesSize() {
        // Act: Tambahkan 1 tugas
        todoList.add("Belajar Kotlin")

        // Assert: Pastikan ukurannya sekarang menjadi 1
        assertEquals(1, todoList.size())
    }

    @Test
    @DisplayName("Menghapus item mengembalikan true dan mengurangi ukuran")
    fun testRemoveExistingItem() {
        // Arrange: Kondisikan TodoList agar memiliki 1 item terlebih dahulu
        todoList.add("Belajar Kotlin")

        // Act: Hapus item tersebut dan simpan hasil boolean-nya
        val removed = todoList.remove("Belajar Kotlin")

        // Assert: Pastikan remove() mengembalikan true (berhasil dihapus),
        // dan ukuran list kembali menjadi 0.
        assertTrue(removed)
        assertEquals(0, todoList.size())
    }
}
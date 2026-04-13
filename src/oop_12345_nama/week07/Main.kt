package oop_12345_nama.week07

fun main() {
    // --- LATIHAN TERBIMBING 1 ---
    println("=== TEST SINGLETON ===")
    println("Status: ${DatabaseManager.connectionStatus}")
    DatabaseManager.connect()

    println("\n=== TEST COMPANION OBJECT ===")
    val client = NetworkClient.createClient()
    client.connect()




    // --- LATIHAN TERBIMBING 2 ---
    println("\n=== TEST REGULAR CLASS ===")
    val reg1 = RegularUser("Alice", 22)
    val reg2 = RegularUser("Alice", 22)
    println(reg1)
    println("Sama? ${reg1 == reg2}")

    println("\n=== TEST DATA CLASS ===")
    val data1 = DataUser("Alice", 22)
    val data2 = DataUser("Alice", 22)
    println(data1)
    println("Sama? ${data1 == data2}")

    val data3 = data1.copy(age = 23)
    println("Hasil Copy: $data3")

    val (userName, userAge) = data1
    println("Destructured: $userName berumur $userAge")






    // --- LATIHAN TERBIMBING 3 ---
    println("\n=== TEST SEALED CLASS ===")
    val response: ApiResponse = Success("Data berhasil ditarik!")
    val uiMessage = when (response) {
        is Success -> "Tampilkan: ${response.data}"
        is Error -> "Munculkan alert: ${response.message}"
        Loading -> "Tampilkan Spinner"
    }
    println(uiMessage)

//    // INI CONTOH SALAH (Compiler Error)

//    val uiMessage = when (response) {
//        is Success -> "Tampilkan: ${response.data}"
//        is Error -> "Munculkan alert: ${response.message}"
//        }
//        // Loading tidak ada -> Error: 'when' expression must be exhaustive

//
//    Singleton (object) -> Memastikan hanya ada satu instansi kelas di seluruh aplikasi. (Satu pintu)

//    Companion Object  -> Pengganti static di kotlin untuk simpan anggota yang menempel pada class.

//    Data Class -> Menghilangkan penulisan kode berulang (boilerplate) untuk kelas yang
//    fungsi utamanya hanya menyimpan data

//    Enum & Sealed Class -> enum class mengelola daftar konstanta sederhana yang sudah pasti,sealed class
//    mengelolah status dinamis yang bisa membawa data berbeda.


    // --- TUGAS MANDIRI ---
    println("\n=== RPG GAME SIMULATION ===")
    GameManager.startGame()
    GameManager.startGame() // Test Singleton

    println("Drop Chance LEGENDARY: ${ItemRarity.LEGENDARY.dropChance}%")
    val starterWeapon = Weapon.forgeStarterSword()
    println("Senjata Awal: ${starterWeapon.item}")

    val upgradedItem = starterWeapon.item.copy(damage = 25)

    processEvent(SafeZone)
    processEvent(MonsterEncounter("Goblin Nakal"))
    processEvent(LootDropped(upgradedItem))
    processEvent(GameOver("Terkena jebakan racun"))
}
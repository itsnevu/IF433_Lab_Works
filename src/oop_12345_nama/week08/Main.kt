package oop_12345_nama.week08 // Sesuaikan dengan NIM dan Nama Anda

fun main() {
    // --- LATIHAN TERBIMBING 1: Nullable Types & Smart Casting ---
    // Menguji bagaimana compiler mengenali perubahan tipe data setelah pengecekan null
    println("=== TEST SMART CASTING ===")
    val service = NotificationService()
    val userWithEmail = UserProfile("Nevu", "nevu@example.com")
    val userNoEmail = UserProfile("Gibran", null)

    service.processUser(userWithEmail)
    service.processUser(userNoEmail)


    // --- LATIHAN TERBIMBING 2: Chained Safe Calls (?.) dan Elvis (?:) ---
    // Menavigasi objek bersarang tanpa blok if-else yang bertumpuk
    println("\n=== TEST SAFE CALLS & ELVIS ===")
    val emptyOrder = Order(null, null)

    // Rantai Safe Calls yang elegan untuk mengambil nama kota
    val destination = emptyOrder.deliveryDetails?.address?.city?.name ?: "Kota Tidak Diketahui"
    println("Tujuan pengiriman: $destination")

    // Penggunaan .let untuk memastikan blok kode hanya dieksekusi jika objek tidak null
    println("\n=== TEST LET BLOCK ===")
    val validOrder = Order(null, 250000)

    val receipt = validOrder.totalPrice?.let { price ->
        val tax = price * 0.11
        "Transaksi Valid. Harga: Rp$price, Pajak: Rp$tax"
    } ?: "Transaksi Invalid: Harga belum di-set!"
    println(receipt)


    // --- LATIHAN TERBIMBING 3: Safe Casting (as?) ---
    // Mencoba konversi tipe data; jika gagal akan mengembalikan null bukan crash
    println("\n=== TEST SAFE CASTING ===")
    val mixedData: List<Any> = listOf(
        "Smartphone",
        1500000,
        UserProfile("Andi", null),
        "Laptop",
        4500000.0
    )

    // Filter koleksi dengan safe casting
    for (item in mixedData) {
        val text = item as? String //ini namanya safe casting
        text?.let {
            println("Ditemukan teks: ${it.uppercase()}")
        }
    }

    // Penerapan Safe Cast dengan Elvis Fallback untuk nilai default
    val someObject: Any = 100
    val safeString = someObject as? String ?: "Unknown String"
    println("Hasil cast fallback: $safeString")


    // --- LATIHAN TERBIMBING 4: The Red Button (!!) - Bahaya & Justifikasinya ---
    println("\n=== TEST THE RED BUTTON (!!) ===")
    val toxicData: String? = null
    try {
        // Memicu NullPointerException secara sengaja (Simulasi kelalaian)
        val length = toxicData!!.length
    } catch (e: NullPointerException) {
        println("CRASH (NPE)! Jangan gunakan !! secara sembarangan.")
    }

    // Alternatif yang lebih aman dengan pesan error logis
    val apiResponse: Map<String, String?> = mapOf("status" to "200", "token" to null)
    try {
        val token = requireNotNull(apiResponse["token"]) {
            "CRITICAL EXCEPTION: Token otentikasi tidak ditemukan dari server!"
        }
    } catch (e: IllegalArgumentException) {
        // Mencetak pesan custom, bukan crash buta
        println(e.message)
    }

    // Justifikasi 1: Java Interoperability (Bekerja dengan Platform Type)
    println("\n=== TEST JAVA INTEROP ===")
    val javaResponse = LegacyJavaAPI.fetchServerStatus()
    // Menggunakan !! karena yakin 100% implementasi Java-nya aman
    val statusLength = javaResponse!!.length
    println("Status dari Java: $javaResponse (Length: $statusLength)")

    // Java itu tidak punya sistem mengenali null seketat kotlin jadi penggunaan !! lebih bijak kalo digunakan dicase ini

    // Justifikasi 2: Unit Testing (Memanggil simulasi pengujian)
    DatabaseMock.runMockUnitTest()
}
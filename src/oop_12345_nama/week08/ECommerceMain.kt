package oop_12345_nama.week08

fun main() {
    // Data JSON kotor dari modul
    val rawApiData: List<Map<String, Any?>> = listOf(
        mapOf("id" to "E01", "name" to "Laptop", "type" to "ELECTRONIC", "warranty" to 24),
        mapOf("id" to "C01", "name" to "T-Shirt", "type" to "CLOTHING", "size" to "XL"),
        mapOf("id" to "E02", "name" to "Mouse", "type" to "ELECTRONIC", "warranty" to "Not An Integer"),
        mapOf("name" to "Ghost Item", "type" to "CLOTHING"),
        mapOf("id" to "X01", "name" to "Unknown", "type" to "FOOD")
    )

    val parser = ApiParser()

    for (raw in rawApiData) {
        try {
            // Membungkus pemanggilan dengan try-catch untuk menangkap data korup
            val product = parser.parseProduct(raw)

            // Jika sukses (tidak null), panggil checkout menggunakan .let
            product?.let {
                println("Berhasil memproses: $it")
                parser.checkout(it)
            }
        } catch (e: IllegalArgumentException) {
            // Menangkap pesan error custom dari requireNotNull
            println("Peringatan Log: Data korup - ${e.message}")
        }
    }
}
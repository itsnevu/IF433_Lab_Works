package oop_12345_nama.week08

class ApiParser {
    fun parseProduct(rawJson: Map<String, Any?>): Product? {
        // Ekstrak data wajib dengan requireNotNull
        val id = requireNotNull(rawJson["id"] as? String) { "API Invalid: Missing ID" }
        val name = requireNotNull(rawJson["name"] as? String) { "API Invalid: Missing Name" }
        val type = rawJson["type"] as? String

        return when (type) {
            "ELECTRONIC" -> {
                // Gunakan as? Int dengan fallback Elvis 12
                val warranty = rawJson["warranty"] as? Int ?: 12
                Electronic(id, name, warranty)
            }
            "CLOTHING" -> {
                // Gunakan as? String dengan fallback Elvis "All Size"
                val size = rawJson["size"] as? String ?: "All Size"
                Clothing(id, name, size)
            }
            else -> null // Tipe tidak dikenal atau null dikembalikan sebagai null
        }
    }

    fun checkout(product: Product) {
        // Ekstrak ID menggunakan pattern matching when
        val id = when (product) {
            is Electronic -> product.id
            is Clothing -> product.id
        }

        // Menggunakan !! karena yakin Java service selalu berhasil
        val transactionId = JavaPaymentService.processPayment(id)!!
        println("Transaction ID: $transactionId")
    }
}
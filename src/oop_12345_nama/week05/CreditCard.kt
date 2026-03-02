package oop_12345_nama.week05

class CreditCard(accountName: String, val limit: Double) : PaymentMethod(accountName) {
    var usedAmount: Double = 0.0

    override fun processPayment(amount: Double) {
        if (usedAmount + amount <= limit) {
            usedAmount += amount
            println("[$accountName] Pembayaran Credit Card senilai $amount sukses. Limit terpakai: $usedAmount")
        } else {
            println("[$accountName] Transaksi ditolak. Melebihi limit kartu kredit.")
        }
    }
}
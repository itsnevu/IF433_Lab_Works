package oop_12345_nama.week05

class EWallet(accountName: String, var balance: Double) : PaymentMethod(accountName) {
    override fun processPayment(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("[$accountName] Pembayaran E-Wallet senilai $amount sukses. Sisa saldo: $balance")
        } else {
            println("[$accountName] Saldo tidak cukup untuk membayar $amount.")
        }
    }

    fun topUp(amount: Double) {
        balance += amount
        println("[$accountName] Berhasil top up sebesar $amount. Saldo sekarang: $balance")
    }
}
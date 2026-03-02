package oop_12345_nama.week05

fun main() {

    val dosen1 = Dosen("Pak Alex", "0123456")
    val admin1 = Admin("Bu Siti")
    //polymorphic collection
    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai) {
        pegawai.bekerja()
        when (pegawai) {
            //smart casting
            is Dosen -> {
                println("=> Terdeteksi sebagai Dosen (NIDN: ${pegawai.nidn})")
                pegawai.mengajar()
            }
            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }
        println("-------------------------")
    }

//    if (pegawai is Dosen) {
//        vsal doen = pegawai as Dosen // Manual Casting
//        dosen.mengajar()
//    }




    println("\n=== TESTING MATHHELPER (OVERLOADING) ===")
    val math = MathHelper()
    println("Luas Persegi (sisi 5): ${math.hitungLuas(5)}")
    println("Luas Persegi Panjang (10x5): ${math.hitungLuas(10,5)}")
    println("Luas Lingkaran (r 7.0): ${math.hitungLuas(7.0)}")
    println("Volume Persegi Panjang: ${math.hitungLuas(1,2,3)}")



    println("\n=== TESTING PAYMENT SYSTEM (SMART CASTING) ===")
    val wallet = EWallet("Vina Wallet", 50000.0)
    val card = CreditCard("Vina Card", 100000.0)

    val listPayment: List<PaymentMethod> = listOf(wallet, card) //polymor

    for (pay in listPayment) {
        println("Mencoba membayar 75000.0 dengan ${pay.accountName}")
        pay.processPayment(75000.0)

        if (pay is EWallet && pay.balance < 75000.0) {
            println("...Mendeteksi saldo kurang pada E-Wallet, mencoba TopUp otomatis...")
            pay.topUp(50000.0)
            pay.processPayment(75000.0)
        }
        println("---")
    }
}
package oop_12345_nama.week06

// Fungsi pendukung dari Latihan 4 (Decoupling)
fun processCheckout(method: PaymentMethod, amount: Double) {
    println("-> Memulai checkout...")
    method.pay(amount)
}

fun main() {
    // TESTING LATIHAN 2: Compound Capabilities
    println("=== TESTING WATCH & SMARTWATCH ===")
    val myWatch = SmartWatch()
    myWatch.showTime()
    myWatch.connectToBluetooth()
    myWatch.chargeBattery()

    // TESTING LATIHAN 3: Diamond Problem Resolution
    println("\n=== TESTING SMARTPHONE (Diamond Problem) ===")
    val myPhone = Smartphone()
    myPhone.turnon()

    // TESTING LATIHAN 4: Interface as Data Type
    println("\n=== TESTING E-COMMERCE CHECKOUT ===")
    val pay1 = Gopay()
    val pay2 = CreditCard()
    val pay3 = crypto()

    processCheckout(pay1, 50000.0)
    processCheckout(pay2, 150000.0)
    processCheckout(method = pay3, amount = 1000.0)



    //  TESTING TUGAS MANDIRI: Smart Home System ---
    println("\n=== TESTING SMART HOME SYSTEM ===")
    val hub = SmartHomeHub()

    // Inisiasi perangkat sesuai skenario
    val lampuTamu = SmartLamp("L01", "Ruang Tamu")
    val googleNest = SmartSpeaker("S01", "Google Nest Dapur")
    val cctvGarasi = SmartCCTV("C01", "Ezviz Garasi")

    // Menambahkan semua perangkat ke Hub
    hub.addDevice(lampuTamu)
    hub.addDevice(googleNest)
    hub.addDevice(cctvGarasi)

    // Menjalankan logika keamanan dan efisiensi
    hub.activateSecurityMode()
    println("---")
    hub.turnOffAllSwitches()
}
package oop_12345_nama.week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    //  BAGIAN 1: STUDENT (GUIDED)
    println("--- APLIKASI PMB UMN ---")
    print("Masukkan Nama: ")
    val name = scanner.nextLine()
    print("Masukkan NIM (5 Karakter): ")
    val nim = scanner.next()
    scanner.nextLine()

    if (nim.length != 5) {
        println("ERROR: NIM harus 5 karakter!")
    } else {
        print("Pilih Jalur (1. Reguler, 2. Umum): ")
        val type = scanner.nextInt()
        scanner.nextLine()

        if (type == 1) {
            print("Masukkan Jurusan: ")
            val majorInput = scanner.nextLine()
            val s1 = Student(name, nim, majorInput)
            println("Status: Selesai. Terdaftar di: ${s1.major}")
        } else if (type == 2) {
            val s2 = Student(name, nim)
            println("Status: Selesai. Terdaftar di: ${s2.major}")
        }
    }

    //BAGIAN 2: LOAN (TUGAS 1)
    println("\n--- TUGAS 1: LIBRARY SYSTEM ---")
    print("Judul Buku: ")
    val title = scanner.nextLine()
    print("Peminjam: ")
    val borrower = scanner.nextLine()
    print("Lama Pinjam: ")
    var duration = scanner.nextInt()
    if (duration < 0) duration = 1

    val loanObj = Loan(title, borrower, duration)
    println("Total Denda: Rp ${loanObj.calculateFine()}")

    //BAGIAN 3: HERO (TUGAS 2)
    println("\n--- TUGAS 2: RPG BATTLE ---")
    print("Nama Hero: ")
    val hName = scanner.next()
    print("Damage: ")
    val hDmg = scanner.nextInt()

    val myHero = Hero(hName, hDmg)
    var enemyHp = 100

    while (myHero.isAlive() && enemyHp > 0) {
        println("\nHP ${myHero.name}: ${myHero.hp} | HP Musuh: $enemyHp")
        print("1. Serang, 2. Kabur: ")
        if (scanner.nextInt() == 1) {
            myHero.attack("Enemy")
            enemyHp -= myHero.baseDamage
            if (enemyHp > 0) {
                val dmgBalas = (10..20).random()
                myHero.takeDamage(dmgBalas)
                println("Musuh membalas sebesar $dmgBalas!")
            }
        } else break
    }
    if (enemyHp <= 0) println("Menang!") else println("Game Over!")
}
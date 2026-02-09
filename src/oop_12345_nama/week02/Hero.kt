package oop_12345_nama.week02

class Hero (
    val name: String,
    val baseDamage: Int,
    var hp: Int = 100
) {
    // Method untuk menampilkan aksi serangan
    fun attack(targetName: String) {
        println("$name menebas $targetName!")
    }

    // Method untuk menerima damage dan mengurangi HP
    fun takeDamage(damage: Int) {
        hp -= damage
        // Validasi: HP tidak boleh negatif, minimal harus 0
        if (hp < 0) hp = 0
    }

    // Method untuk mengecek apakah hero masih hidup
    fun isAlive(): Boolean {
        return hp > 0
    }
}
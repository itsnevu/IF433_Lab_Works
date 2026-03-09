package oop_12345_nama.week06

// Langkah 1: Error Sengaja (Checkpointed)
interface Clickable {
    // ERROR: Property in an interface cannot have a backing field
    // val name: String = "Tombol Rahasia"

    // Langkah 2: Perbaikan menjadi Abstract Property
    val name: String
    fun click()
}

// Langkah 3: Implementasi Kontrak [cite: 26, 28]
class Button(override val name: String) : Clickable {
    override fun click() {
        println("Tombol '$name' berhasil diklik!")
    }
}
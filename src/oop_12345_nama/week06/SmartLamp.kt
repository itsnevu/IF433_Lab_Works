package oop_12345_nama.week06

class SmartLamp(override val id: String, override val name: String) : SmartDevice, Switchable {
    override fun turnon() { println("[$name] Lampu menyala terang.") }
    override fun turnoff() { println("[$name] Lampu dimatikan.") }
}
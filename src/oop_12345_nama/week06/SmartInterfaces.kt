package oop_12345_nama.week06

interface SmartDevice {
    val id: String
    val name: String
}

interface Switchable {
    fun turnon()
    fun turnoff()
}

interface Recordable {
    fun startRecord()
    fun stopRecord() { println("Perekaman dihentikan dan disimpan ke Cloud.") }
}
package oop_12345_nama.week06

class SmartSpeaker(override val id: String, override val name: String) : SmartDevice, Switchable {
    override fun turnon() { println("[$name] Speaker aktif.") }
    override fun turnoff() { println("[$name] Speaker standby.") }
    fun playMusic(song: String) { println("Memutar lagu $song dari Spotify.") }
}
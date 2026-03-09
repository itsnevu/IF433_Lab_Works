package oop_12345_nama.week06

class SmartHomeHub {
    val devices = mutableListOf<SmartDevice>()

    fun addDevice(device: SmartDevice) { devices.add(device) }

    fun turnOffAllSwitches() {
        for (device in devices) {
            if (device is Switchable) { device.turnoff() }
        }
    }

    fun activateSecurityMode() {
        for (device in devices) {
            if (device is Recordable) { device.startRecord() }
            if (device is SmartSpeaker) { device.playMusic("Sirine Peringatan") }
        }
    }
}

fun main() {
    val hub = SmartHomeHub()
    hub.addDevice(SmartLamp("L01", "Ruang Tamu"))
    hub.addDevice(SmartSpeaker("S01", "Google Nest Dapur"))
    hub.addDevice(SmartCCTV("C01", "Ezviz Garasi"))

    hub.activateSecurityMode()
    hub.turnOffAllSwitches()
}
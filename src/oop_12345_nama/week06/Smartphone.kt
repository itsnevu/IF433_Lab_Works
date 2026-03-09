package oop_12345_nama.week06

class Smartphone : Camera, Phone {
    // Resolusi Konflik Menggunakan super<T>
    override fun turnon() {
        super<Camera>.turnon()
        super<Phone>.turnon()
        println("Sistem operasi Smartphone berhasil booting.")
    }
}
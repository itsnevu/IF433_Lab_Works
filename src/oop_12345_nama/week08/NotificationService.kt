package oop_12345_nama.week08

class NotificationService {
    fun sendEmail(emailAddress: String) {
        println("Mengirim email ke: $emailAddress")
    }

    fun processUser(user: UserProfile) {
        if (user.email != null) {
            // Karena sudah dicek tidak null, kita bisa langsung pakai
            sendEmail(emailAddress = user.email) // ini smart casting
        } else {
            println("User ${user.name} tidak memiliki email.")
        }
    }
}
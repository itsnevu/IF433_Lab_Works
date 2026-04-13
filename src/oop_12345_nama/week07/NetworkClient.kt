package oop_12345_nama.week07

class NetworkClient private constructor(val url: String) {
    companion object { //Factory Pattern
        const val BASE_URL = "https://api.umn.ac.id"

        //contoh panggil lansung -> val client = NetworkClient("https://api.umn.ac.id")
        //contoh panggil kalo pake private constructor val client = NetworkClient.createClient() (encapsulation)

        fun createClient(): NetworkClient { //methodnya
            println("Membangun NetworkClient dengan BASE_URL: $BASE_URL")
            return NetworkClient(BASE_URL) //hasil outputnya
        }
    }

    fun connect() {
        println("Connecting to $url...")
    }
}
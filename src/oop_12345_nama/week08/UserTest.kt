package oop_12345_nama.week08

object DatabaseMock {
    fun findUser(id: Int): UserProfile? {
        // Simulasi database: hanya ID 1 yang ditemukan [cite: 170]
        return if (id == 1) UserProfile("TestUser", "test@test.com") else null
    }

    fun runMockUnitTest() {
        println("\n=== RUNNING UNIT TEST ===")
        val testUser = DatabaseMock.findUser(1)
        // Penggunaan !! lazim di Testing untuk memaksa crash jika data null [cite: 176]
        val initial = testUser!!.name.substring(0, 1)

        check(initial == "T") { "Test Failed! Initial is wrong." }
        println("Test Passed: Initial is T")
    }
}
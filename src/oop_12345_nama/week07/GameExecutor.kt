package oop_12345_nama.week07

fun processEvent(event: BattleState) {
    // 'when' di sini wajib handle semua case dari sealed class (exhaustive)
    when (event) {
        is MonsterEncounter -> {
            println("Awas! Kamu bertemu dengan ${event.monsterName}!")
        }
        is LootDropped -> {
            // Kita cetak nama item dan tingkat kelangkaannya
            println("Hore! Kamu mendapatkan loot: ${event.item.name} (Rarity: ${event.item.rarity})")
        }
        is GameOver -> {
            println("Permainan Berakhir: ${event.reason}")
        }
        SafeZone -> {
            println("Kamu berada di zona aman. Silakan beristirahat.")
        }
    }
}
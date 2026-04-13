package oop_12345_nama.week07

enum class ItemRarity(val dropChance: Int) {
    COMMON(70), UNCOMMON(30), RARE(10), EPIC(5), LEGENDARY(1)
}

data class GameItem(val name: String, val damage: Int, val rarity: ItemRarity)
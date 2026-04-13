package oop_12345_nama.week07

sealed class BattleState

// Pakai data class karena butuh bawa data (payload)
data class MonsterEncounter(val monsterName: String) : BattleState()
data class LootDropped(val item: GameItem) : BattleState()
data class GameOver(val reason: String) : BattleState()

// Pakai object karena cuma penanda (tidak ada data tambahan)
object SafeZone : BattleState()
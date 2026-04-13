package oop_12345_nama.week07

// Class biasa untuk pembuktian kegagalan equality
class RegularUser(val name: String, val age: Int) //(identity equality), menampilkan alamat memori, tidak ada fitur modifikasi data

// Data class untuk structural equality
data class DataUser(val name: String, val age: Int) //(structural equality), readable format
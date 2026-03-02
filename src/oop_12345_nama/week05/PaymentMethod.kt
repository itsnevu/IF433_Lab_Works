package oop_12345_nama.week05

abstract class PaymentMethod(val accountName: String) {
    abstract fun processPayment(amount: Double)
}
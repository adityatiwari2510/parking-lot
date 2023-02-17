class ExitGate {
    private var receiptNumber = 1L

    private fun generateReceiptNumber(): String {
        val currentReceiptNumber = receiptNumber++
        return "R-$currentReceiptNumber"
    }

    fun issueReceipt(vehicle: Vehicle, exitTime: Long, fare: Int): Receipt {
        return Receipt(generateReceiptNumber(), vehicle.getEntryTime(),exitTime, fare)
    }

}

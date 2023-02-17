class Receipt(
    private val receiptNumber: String,
    private val entryTime: Long,
    private val exitTime: Long,
    private val fare: Int
) {
    fun generateReceipt(): String {
        val formattedEntryTime = DateTimeFormatter(entryTime).formatDate("dd-MMM-yyyy HH:mm:ss")
        val formattedExitTime = DateTimeFormatter(exitTime).formatDate("dd-MMM-yyyy HH:mm:ss")
        return  "Parking Receipt:\n"+
                " Receipt Number: $receiptNumber\n" +
                " Entry Date-time: $formattedEntryTime\n" +
                " Exit Date-time: $formattedExitTime\n" +
                " Fees: $fare"
    }
}

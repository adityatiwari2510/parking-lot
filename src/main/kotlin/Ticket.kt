import kotlin.math.E

class Ticket(
    private val tickerNumber: Int,
    private val parkingSpotNumber: Int,
    private val entryTime: Long
) {
    fun generateTicket(): String {
        val formattedEntryTime = DateTimeFormatter(entryTime).formatDate("dd-MMM-yyyy HH:mm:ss")
        return "Parking Ticket:\n" +
                " Ticket Number: $tickerNumber\n" +
                " Spot Number: $parkingSpotNumber\n" +
                " Entry Date-time: $formattedEntryTime"
    }

    fun getParkingSpotNumber(): Int {
        return parkingSpotNumber
    }

    fun getEntryTime(): Long{
        return entryTime
    }
}

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParkingLotTest {
    @Test
    fun `park function should generate a ticket if parking spot is available`() {
        val vehicle = Vehicle()
        val parkingSpots = ParkingSpotRepository()
        val parkingLot = ParkingLot(parkingSpots)
        val entryTime = System.currentTimeMillis()

        val response = parkingLot.park(vehicle, entryTime)

        val expectedTicket = "Parking Ticket:\n" +
                " Ticket Number: 1\n" +
                " Spot Number: 1\n" +
                " Entry Date-time: " + DateTimeFormatter(entryTime).formatDate("dd-MMM-yyyy HH:mm:ss")
        assertEquals(expectedTicket, response)
    }

    @Test
    fun `park function should throw ParkingSpotNotAvailableException if parking spot is not available`() {
        val vehicle = Vehicle()
        val parkingSpots = ParkingSpotRepository()
        for (i in 1..TOTAL_CAR_PARKING_SPOTS) {
            parkingSpots.getAvailableParkingSpot().occupyParkingSpot()
        }
        val parkingLot = ParkingLot(parkingSpots)
        val entryTime = System.currentTimeMillis()

        assertThrows<ParkingSpotNotAvailableException> {
            parkingLot.park(vehicle, entryTime)
        }
    }
}
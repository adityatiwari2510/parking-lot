import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.text.SimpleDateFormat

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

    @Test
    fun `unPark function should generate a receipt for the parked vehicle`() {
        val vehicle = Vehicle()
        val parkingSpots = ParkingSpotRepository()
        val parkingLot = ParkingLot(parkingSpots)
        val entryTime = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("14-02-2022 01:00:01").time
        val exitTime = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("14-02-2022 02:00:01").time
        parkingLot.park(vehicle, entryTime)

        val response = parkingLot.unPark(vehicle, exitTime)

        val expectedResponse = "Parking Receipt:\n"+
                " Receipt Number: R-1\n" +
                " Entry Date-time: " + DateTimeFormatter(entryTime).formatDate("dd-MMM-yyyy HH:mm:ss")+"\n"+
                " Exit Date-time: " + DateTimeFormatter(exitTime).formatDate("dd-MMM-yyyy HH:mm:ss")+"\n"+
                " Fees: 10"
        assertEquals(expectedResponse, response)
    }
}
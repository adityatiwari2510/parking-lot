import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EntryGateTest {
    @Test
    fun `issueTicket should return the Ticket if parkingSpot is not occupied`() {
        val parkingSpot = ParkingSpot(1)
        val entryTime = System.currentTimeMillis()
        val expectedTicket = Ticket(1, parkingSpot.spotNumber, entryTime)

        val actualTicket = EntryGate().issueTicket(parkingSpot, entryTime)

        assertEquals(expectedTicket.generateTicket(), actualTicket.generateTicket())
    }

    @Test
    fun `issueTicket should Throw ParkingSpotNotAvailableException if parkingSpot is occupied`() {
        val parkingSpot = ParkingSpot(1)
        parkingSpot.occupyParkingSpot()
        val entryTime = System.currentTimeMillis()

        assertThrows<ParkingSpotNotAvailableException> {
            EntryGate().issueTicket(parkingSpot, entryTime)
        }
    }


}
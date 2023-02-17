import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketTest{

    @Test
    fun `getParkingSpotNumber should return the parkingSpotNumber assigned to ticket`(){
        val ticket = Ticket(1,1,System.currentTimeMillis())
        val expectedParkingSpotNumber = 1

        val response = ticket.getParkingSpotNumber()

        assertEquals(expectedParkingSpotNumber,response)
    }
}
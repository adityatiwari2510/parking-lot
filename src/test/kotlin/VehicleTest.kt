import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VehicleTest{

    @Test
    fun `getParkingSpot should return the parkingSpot assigned to vehicle`(){
        val parkingSpot = ParkingSpot(1)
        val vehicle = Vehicle()
        vehicle.assignParkingSpot(parkingSpot)

        val response = vehicle.getParkingSpot()

        assertEquals(parkingSpot.spotNumber, response.spotNumber)
    }

    @Test
    fun `getEntryTime should return the entryTime of vehicle using ticket`(){
        val vehicle = Vehicle()
        val entryTime = System.currentTimeMillis()
        vehicle.ticket = Ticket(1,1,entryTime)

        val response = vehicle.getEntryTime()

        assertEquals(entryTime,vehicle.getEntryTime())
    }
}
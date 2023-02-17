import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ParkingSpotTest{
    @Test
    fun `occupyParkingSpot should mark isOccupied to true`(){
        val parkingSpot = ParkingSpot(1)

        parkingSpot.occupyParkingSpot()

        assertTrue(parkingSpot.isOccupied)
    }

    @Test
    fun `releaseParkingSpot should mark isOccupied to false`(){
        val parkingSpot = ParkingSpot(1)
        parkingSpot.occupyParkingSpot()

        parkingSpot.releaseParkingSpot()

        assertFalse(parkingSpot.isOccupied)
    }
}
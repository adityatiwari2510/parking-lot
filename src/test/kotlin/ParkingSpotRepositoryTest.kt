import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParkingSpotRepositoryTest{
    @Test
    fun `getAvailableParkingSpot should return ParkingSpot if available`(){
        val parkingSpots = ParkingSpotRepository()

        val response = parkingSpots.getAvailableParkingSpot()

        assertFalse(response.isOccupied)
    }

    @Test
    fun `getAvailableParkingSpot should throw ParkingSpotNotAvailableException if parking spot is not available`(){
        val parkingSpots = ParkingSpotRepository()
        for(i in 1..TOTAL_CAR_PARKING_SPOTS){
            val parkingSpot = parkingSpots.getAvailableParkingSpot()
            parkingSpot.occupyParkingSpot()
        }

        assertThrows<ParkingSpotNotAvailableException>{ parkingSpots.getAvailableParkingSpot() }
    }

}
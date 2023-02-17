const val TOTAL_CAR_PARKING_SPOTS = 100
class ParkingSpotRepository {
    private val carParkingSpots = mutableListOf<ParkingSpot>()

    init {
        for(i in 1..TOTAL_CAR_PARKING_SPOTS){
            carParkingSpots.add(ParkingSpot(i))
        }
    }

    private fun checkIfParkingSpotIsAvailable(): Boolean {
        for (parkingSpot in carParkingSpots) {
            if (!parkingSpot.isOccupied) {
                return true
            }
        }
        return false
    }

    fun getAvailableParkingSpot(): ParkingSpot {
        if(checkIfParkingSpotIsAvailable()){
            for(parkingSpot in carParkingSpots) {
                if (!parkingSpot.isOccupied) {
                    return parkingSpot
                }
            }
        }
        throw ParkingSpotNotAvailableException()
    }
}
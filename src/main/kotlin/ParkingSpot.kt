class ParkingSpot(val spotNumber: Int) {
    var isOccupied: Boolean = false
    fun occupyParkingSpot() {
        isOccupied = true
    }

    fun releaseParkingSpot() {
        isOccupied = false
    }
}
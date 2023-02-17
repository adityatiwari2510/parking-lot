class Vehicle {
    lateinit var ticket: Ticket
    private lateinit var parkingSpot: ParkingSpot

    fun assignParkingSpot(parkingSpot: ParkingSpot){
        this.parkingSpot = parkingSpot
    }

    fun getParkingSpot(): ParkingSpot {
        return parkingSpot
    }

    fun getEntryTime(): Long{
        return ticket.getEntryTime()
    }

}
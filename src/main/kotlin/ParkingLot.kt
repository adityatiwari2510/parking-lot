class ParkingLot(private val parkingSpots: ParkingSpotRepository) {
    private val entryGate: EntryGate = EntryGate();
    private val exitGate: ExitGate = ExitGate();


    fun park(vehicle: Vehicle, entryTime: Long): String {
        val parkingSpot = parkingSpots.getAvailableParkingSpot()

        vehicle.ticket = entryGate.issueTicket(parkingSpot, entryTime)

        parkingSpot.occupyParkingSpot()

        return printTicket(vehicle.ticket)
    }

    private fun printTicket(ticket: Ticket): String {
        return ticket.generateTicket()
    }
}
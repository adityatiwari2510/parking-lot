class EntryGate {
    private var ticketNumber = 1

    private fun generateTicketNumber(): Int {
        return ticketNumber++
    }
    fun issueTicket(parkingSpot: ParkingSpot, entryTime: Long): Ticket {
        if(!parkingSpot.isOccupied) {
            return Ticket(generateTicketNumber(), parkingSpot.spotNumber, entryTime)
        }
        throw ParkingSpotNotAvailableException()
    }

}

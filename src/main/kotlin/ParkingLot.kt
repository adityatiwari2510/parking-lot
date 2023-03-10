class ParkingLot(private val parkingSpots: ParkingSpotRepository) {
    private val entryGate: EntryGate = EntryGate()
    private val exitGate: ExitGate = ExitGate()

    private fun getAvailableParkingSpot(): ParkingSpot {
        return parkingSpots.getAvailableParkingSpot()
    }

    private fun occupyParkingSpot(parkingSpot: ParkingSpot) {
        parkingSpot.occupyParkingSpot()
    }

    fun park(vehicle: Vehicle, entryTime: Long): String {
        val parkingSpot = getAvailableParkingSpot()

        vehicle.assignParkingSpot(parkingSpot)
        vehicle.ticket = entryGate.issueTicket(parkingSpot, entryTime)

        occupyParkingSpot(parkingSpot)

        return printTicket(vehicle.ticket)
    }

    private fun printTicket(ticket: Ticket): String {
        return ticket.generateTicket()
    }

    fun unPark(vehicle: Vehicle, exitTime: Long): String {
        val fare = FareCalculator().calculateFare(vehicle.getEntryTime(), exitTime)

        val receipt = exitGate.issueReceipt(vehicle, exitTime, fare)

        val parkingSpot = vehicle.getParkingSpot()
        parkingSpot.releaseParkingSpot()

        return printReceipt(receipt)
    }

    private fun printReceipt(receipt: Receipt): String {
        return receipt.generateReceipt()
    }
}
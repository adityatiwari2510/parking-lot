class ParkingLot(private val parkingSpots: ParkingSpotRepository) {
    private val entryGate: EntryGate = EntryGate()
    private val exitGate: ExitGate = ExitGate()


    fun park(vehicle: Vehicle, entryTime: Long): String {
        val parkingSpot = parkingSpots.getAvailableParkingSpot()

        vehicle.assignParkingSpot(parkingSpot)
        vehicle.ticket = entryGate.issueTicket(parkingSpot, entryTime)

        parkingSpot.occupyParkingSpot()

        return printTicket(vehicle.ticket)
    }

    private fun printTicket(ticket: Ticket): String {
        return ticket.generateTicket()
    }

    fun unPark(vehicle: Vehicle, exitTime: Long): String {
        val fare = FareCalculator().calculateFare(vehicle.getEntryTime(),exitTime)

        val receipt = exitGate.issueReceipt(vehicle, exitTime, fare)

        val parkingSpot = vehicle.getParkingSpot()
        parkingSpot.releaseParkingSpot()

        return printReceipt(receipt)
    }

    private fun printReceipt(receipt: Receipt): String {
        return receipt.generateReceipt()
    }
}
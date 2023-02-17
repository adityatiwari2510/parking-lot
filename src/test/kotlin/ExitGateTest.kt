import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExitGateTest{
    @Test
    fun `issueReceipt should return the receipt`(){
        val entryTime = System.currentTimeMillis()
        val exitTime = System.currentTimeMillis()
        val expectedReceipt = Receipt("R-1",entryTime,exitTime,20)
        val vehicle = Vehicle()
        vehicle.ticket = Ticket(1,1,entryTime)

        val actualReceipt = ExitGate().issueReceipt(vehicle,exitTime,20)

        assertEquals(expectedReceipt.generateReceipt(),actualReceipt.generateReceipt())
    }
}
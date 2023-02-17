import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReceiptTest{
    @Test
    fun `generateReceipt should return receipt in formatted way`(){
        val entryTime = System.currentTimeMillis()
        val exitTime = System.currentTimeMillis()
        val receipt = Receipt("R-1",entryTime,exitTime,20)

        val response = receipt.generateReceipt()

        val expectedResponse = "Parking Receipt:\n"+
                " Receipt Number: R-1\n" +
                " Entry Date-time: " + DateTimeFormatter(entryTime).formatDate("dd-MMM-yyyy HH:mm:ss")+"\n"+
                " Exit Date-time: " + DateTimeFormatter(exitTime).formatDate("dd-MMM-yyyy HH:mm:ss")+"\n"+
                " Fees: 20"
        assertEquals(expectedResponse, response)
    }
}
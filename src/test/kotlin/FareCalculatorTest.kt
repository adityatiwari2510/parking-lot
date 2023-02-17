import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.Date

class FareCalculatorTest{

    @Test
    fun `calculateFare should return fare based on difference between entryTime and exitTime multiplied by FARE_PER_HOUR`(){
        val entryTime = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("14-02-2022 01:00:01").time
        val exitTime = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("14-02-2022 02:00:01").time
        val expectedResponse = 10

        val response = FareCalculator().calculateFare(entryTime,exitTime)

        assertEquals(expectedResponse,response)
    }
}
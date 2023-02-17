const val FARE_PER_HOUR = 10
class FareCalculator {
    private fun calculateHourDifference(entryTime: Long, exitTime: Long): Int {
        return ((exitTime-entryTime)/1000/3600).toInt()
    }
    fun calculateFare(entryTime: Long, exitTime: Long): Int {
        return calculateHourDifference(entryTime, exitTime) * FARE_PER_HOUR

    }
}
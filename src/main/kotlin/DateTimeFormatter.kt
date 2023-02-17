import java.text.SimpleDateFormat
import java.util.*

class DateTimeFormatter(private val time: Long) {

    fun formatDate(dateFormatPattern: String): String {
        return SimpleDateFormat(dateFormatPattern).format(Date(time))
    }
}
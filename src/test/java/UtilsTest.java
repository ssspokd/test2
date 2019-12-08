import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.sun.javafx.binding.StringFormatter;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {


    @Test
    void convertDateToCalendar() {
        Date date = new Date(2019,12,11,01,02);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        String str = String.format("%s.%s.%s %s:%s",
                calendar.get(Calendar.DATE),
                calendar.get(Calendar.MONTH) +1,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));

        System.out.println(str);
    }
}
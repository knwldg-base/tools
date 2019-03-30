import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<DayOfWeek, String> DAY_OF_WEEK_MAP;
    static {
        Map<DayOfWeek, String> dayOfWeekMap = new HashMap<DayOfWeek, String>() {
            {
                put(DayOfWeek.SUNDAY, "日");
                put(DayOfWeek.MONDAY, "月");
                put(DayOfWeek.TUESDAY, "火");
                put(DayOfWeek.WEDNESDAY, "水");
                put(DayOfWeek.THURSDAY, "木");
                put(DayOfWeek.FRIDAY, "金");
                put(DayOfWeek.SATURDAY, "土");
            }
        };
        DAY_OF_WEEK_MAP = Collections.unmodifiableMap(dayOfWeekMap);
    }

    public static void main(String[] args) {
        LocalDate frmDate = LocalDate.parse(args[0], DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate toDate = LocalDate.parse(args[1], DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 日数
        int count = (int) ChronoUnit.DAYS.between(frmDate, toDate);

        for (int i = 0; i <= count; i++) {
            LocalDate date = frmDate.plusDays(i);
            System.out.print("（" + date.getYear() + "年" + date.getMonth().getValue() + "月" + date.getDayOfMonth() + "日）");
            System.out.println("(" + DAY_OF_WEEK_MAP.get(date.getDayOfWeek()) + ")");
        }
    }
}

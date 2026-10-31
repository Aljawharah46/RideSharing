public class DateTime implements IDateTime {

    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;

    //constructor
    public DateTime(int year, int month, int day, int hour, int minute) {

        if (month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("wrong date");
        }

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("wrong time");
        }

        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    //converts a string into DateTime object
    public static DateTime parse(String text) {
        try {
            String[] parts = text.trim().split("\\s+");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid date/time");
            }

            String[] date = parts[0].split("/");
            String[] time = parts[1].split(":");

            if (date.length != 3 || time.length != 2) {
                throw new IllegalArgumentException("Invalid date/time");
            }

            int month = Integer.parseInt(date[0]);
            int day = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            return new DateTime(year, month, day, hour, minute);

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid date/time");
        }
    }

    //getters
    @Override
    public int getYear() {
        return year;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public int getMinute() {
        return minute;
    }

    
    //returns the date and time in the required format
    @Override
    public String format() {
        return twoDigits(month) + "/" + twoDigits(day) + "/" + year + " "
                + twoDigits(hour) + ":" + twoDigits(minute);
    }

    //if the number is less then 10 it adds a zero on the left
    private String twoDigits(int x) {
        if (x < 10) {
            return "0" + x;
        }
        return "" + x;
    }

    //compares two dates and times
    @Override
    public int compareTo(IDateTime other) {
        if (year != other.getYear()) {
            return year - other.getYear();
        }
        if (month != other.getMonth()) {
            return month - other.getMonth();
        }
        if (day != other.getDay()) {
            return day - other.getDay();
        }
        if (hour != other.getHour()) {
            return hour - other.getHour();
        }
        return minute - other.getMinute();
    }

    //returns the formatted date and time
    @Override
    public String toString() {
        return format();
    }
}
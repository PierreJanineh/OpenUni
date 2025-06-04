package Maman12;

public class Time1 {
    public final static int MAX_H = 23;
    public final static int MAX_M_S = 59;
    private static final int MIN_IN_H = 60;
    private static final int SEC_IN_M = 60;
    private final static int MIN_VALUE = 0;
    private final static int DEFAULT_VALUE = MIN_VALUE;

    private int _hour, _minute, _second;

    /**
     * Constructs a Time1 object . Constructs a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
     * @param h hour
     * @param m minute
     * @param s second
     */
    public Time1(int h, int m, int s) {
        _hour = validateHour(h);
        _minute = validateMinuteOrSecond(m);
        _second = validateMinuteOrSecond(s);
    }

    /**
     * Copy constructor for Time1. Constructs a time with the same variables as another time.
     * @param other The time object from which to construct the new time.
     */
    public Time1(Time1 other) {
        _hour = other._hour;
        _minute = other._minute;
        _second = other._second;
    }

    /**
     * Returns the hour of the time.
     * @return The hour of the time.
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Returns the minute of the time.
     * @return The minute of the time.
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Returns the second of the time.
     * @return The second of the time.
     */
    public int getSecond() {
        return _second;
    }

    /**
     * Changes the hour of the time. If illegal number is received hour will remain unchanged.
     * @param num The new hour.
     */
    public void setHour(int num) {
        if (isValid(num, MAX_H))
            _hour = validateHour(num);
    }

    /**
     * Changes the minute of the time. If illegal number is received minute will remain unchanged.
     * @param num The new minute.
     */
    public void setMinute(int num) {
        if (isValid(num, MAX_M_S))
            _minute = validateMinuteOrSecond(num);
    }

    /**
     * Changes the second of the time. If illegal number is received second will remain unchanged.
     * @param num The new second.
     */
    public void setSecond(int num) {
        if (isValid(num, MAX_M_S))
            _second = validateMinuteOrSecond(num);
    }

    /**
     * Calculate seconds since midnight.
     * @return Seconds passed since midnight.
     */
    public long secFromMidnight() {
        int minutes = _hour * MIN_IN_H;
        int seconds = minutes + _minute;
        return (long) (seconds) * SEC_IN_M + _second;
    }

    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time.
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time1 other) {
        return other._hour == _hour &&
                other._minute == _minute &&
                other._second == _second;
    }

    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this time is before.
     * @return True if this time is before other time.
     */
    public boolean before(Time1 other) {
        return _hour < other._hour ||
                (_hour == other._hour && _minute < other._minute) ||
                (_hour == other._hour && _minute == other._minute && _second < other._second);
    }

    /**
     * Checks if this time is after a received time.
     * @param other The time to check if this time is after.
     * @return True if this time is after other time.
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference (in seconds) between two times.
     * @param other The time to check the difference with. Assumption: this time is after other time.
     * @return int difference in seconds
     */
    public int difference(Time1 other) {
        return (int) (secFromMidnight() - other.secFromMidnight());
    }

    /**
     * Returns a string representation of this time (hh:mm:ss).
     * @return String representation of this time (hh:mm:ss).
     */
    public String toString() {
        return normalizeValue(_hour) +
                ":" + normalizeValue(_minute) +
                ":" + normalizeValue(_second);
    }

    /**
     * Insures the string of the passed number is two-digits (eg: "00")
     * @param value The value to be normalized.
     * @return The normalized value (adding 0 in the beginning if value is less than 10).
     */
    private String normalizeValue(int value) {
        return value < 10 ?
                "0" + value :
                "" + value;
    }

    /**
     * Validates the value of minutes, or seconds
     * @param value The value of minutes, or seconds
     * @return The value if valid. Otherwise, {@value #DEFAULT_VALUE} (aka. {@code DEFAULT_VALUE})
     */
    private int validateMinuteOrSecond(int value) {
        return validate(value, MAX_M_S);
    }

    /**
     * Validates the value of hours
     * @param h The value of hours
     * @return The value if valid. Otherwise, {@value #DEFAULT_VALUE} (aka. {@code DEFAULT_VALUE})
     */
    private int validateHour(int h) {
        return validate(h, MAX_H);
    }

    /**
     * Validates the value of hours, minutes, or seconds
     * @param value The value of hours, minutes, or seconds
     * @return The value if valid. Otherwise, {@value #DEFAULT_VALUE} (aka. {@code DEFAULT_VALUE})
     */
    private int validate(int value, int max) {
        return isValid(value, max) ? value : DEFAULT_VALUE;
    }

    /**
     * Checks if value (hour, minute, or second) is valid.
     * @param value The value to check.
     * @param max The max value allowed.
     * @return True if {@code value} is valid.
     */
    private boolean isValid(int value, int max) {
        return value >= MIN_VALUE && value <= max;
    }
}

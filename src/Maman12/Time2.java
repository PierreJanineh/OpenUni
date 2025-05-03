package Maman12;

public class Time2 {
    private static final int MIN_IN_H = 60;
    private static final int SEC_IN_M = 60;
    private static final int SEC_IN_H = MIN_IN_H * SEC_IN_M;
    private final static int MAX_H = 23;
    private final static int MAX_M_S = 59;
    private final static int MIN_VALUE = 0;
    private final static int DEFAULT_VALUE = MIN_VALUE;

    private int _secFromMid;

    /**
     * Constructs a Time2 object. Construct a new time instance with the specified hour, minute and second. hour should be between 0-23, otherwise it should be set to 0. minute and second should be between 0-59, otherwise they should be set to 0.
     * @param h hour.
     * @param m minute.
     * @param s second.
     */
    public Time2(int h, int m, int s) {
        int hour = validateHour(h);
        int minute = validateMinuteOrSecond(m);
        int second = validateMinuteOrSecond(s);
        _secFromMid = ((hour * MIN_IN_H) + minute) * SEC_IN_M + second;
    }

    /**
     * Copy constructor for Time2. Constructs a time with the same variables as another time.
     * @param other The time object from which to construct the new time.
     */
    public Time2(Time2 other) {
        _secFromMid = other._secFromMid;
    }

    /**
     * Returns the hour of the time.
     * @return int the hour of the time.
     */
    public int getHour() {
        return _secFromMid / SEC_IN_H;
    }

    /**
     * Returns the minute of the time.
     * @return int the minute of the time.
     */
    public int getMinute() {
        return _secFromMid % SEC_IN_H / SEC_IN_M;
    }

    /**
     * Returns the second of the time.
     * @return int the second of the time.
     */
    public int getSecond() {
        return _secFromMid % SEC_IN_M;
    }

    /**
     * Changes the hour of the time. If illegal number is received hour will remain unchanged.
     * @param num The new hour.
     */
    public void setHour(int num) {
        setTime(num, null, null);
    }

    /**
     * Changes the minute of the time. If illegal number is received minute will remain unchanged.
     * @param num The new minute
     */
    public void setMinute(int num) {
        setTime(null, num, null);
    }

    /**
     * Changes the second of the time. If illegal number is received second will remain unchanged.
     * @param num The new second.
     */
    public void setSecond(int num) {
        setTime(null, null, num);
    }

    /**
     * Changes the value of _secFromMid by calculating h, m, and s values. This also validates all values before changing, if illegal value will remain unchanged.
     * @param h The new hour. Pass null if not changing.
     * @param m The new minute. Pass null if not changing.
     * @param s The new second. Pass null if not changing.
     */
    private void setTime(Integer h, Integer m, Integer s) {
        int hour = getHour();
        int minute = getMinute();
        int second = getSecond();

        if (h != null) hour = isValid(h, MAX_H) ? h : getHour();
        if (m != null) minute = isValid(m, MAX_M_S) ? m : getMinute();
        if (s != null) second = isValid(s, MAX_M_S) ? s : getSecond();

        _secFromMid = (hour * SEC_IN_H) + (minute * SEC_IN_M) + second;
    }

    /**
     * Calculate seconds since midnight.
     * @return int seconds passed since midnight.
     */
    public int secFromMidnight() {
        return _secFromMid;
    }

    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time.
     * @return boolean true if the received time is equal to this time, otherwise return false.
     */
    public boolean equals(Time2 other) {
        return other.secFromMidnight() == _secFromMid;
    }

    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this time is before.
     * @return boolean true if this time is before other time, otherwise return false.
     */
    public boolean before(Time2 other) {
        return other.secFromMidnight() > _secFromMid;
    }

    /**
     * Checks if this time is after a received time.
     * @param other The time to check if this time is after.
     * @return boolean true if this time is after other time, otherwise return false.
     */
    public boolean after(Time2 other) {
        return other.secFromMidnight() < _secFromMid;
    }

    /**
     * Calculates the difference (in seconds) between two times.
     * @param other The time to check the difference with. Assumption: this time is after other time.
     * @return int difference in seconds.
     */
    public int difference(Time2 other) {
        return _secFromMid - other.secFromMidnight();
    }

    /**
     * Returns a string representation of this time(hh:mm:ss).
     * @return String representation of this time(hh:mm:ss).
     */
    public String toString() {
        return normalizeValue(getHour()) +
                ":" + normalizeValue(getMinute()) +
                ":" + normalizeValue(getSecond());
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

package Maman12;

public class BusArrival {

    private static final int MAX_PASSENGERS_COUNT = 70;
    private static final int MIN_LINE_NUM = 1;
    private static final int MAX_LINE_NUM = 99;

    private final static int MIN_VALUE = 0;

    private int _lineNumber;
    private Time1 _arrivalTime;
    private int _noOfPassengers;

    /**
     * Constructs a BusArrival object. with line number, number of passengers, and time(hour, minute and second) of arrival if lineNum is illegal it will be set to 1. if other parameters are illegal they will be set to 0.
     * @param lineNum The bus line number (should be between {@value #MIN_LINE_NUM}-{@value #MAX_LINE_NUM}).
     * @param pass The number of passengers (should be between {@value #MIN_VALUE}-{@value #MAX_PASSENGERS_COUNT}).
     * @param h The hour of bus arrival (should be between {@value #MIN_VALUE}-{@value Time1#MAX_H}).
     * @param m The minute of bus arrival (should be between {@value #MIN_VALUE}-{@value Time1#MAX_M_S}).
     * @param s The second of bus arrival (should be between {@value #MIN_VALUE}-{@value Time1#MAX_M_S}).
     */
    public BusArrival(int lineNum, int pass, int h, int m, int s) {
        _lineNumber = validateLineNum(lineNum);
        _arrivalTime = new Time1(h, m, s);
        _noOfPassengers = validatePassNum(pass);
    }

    /**
     * Constructs BusArrival object. with line number, number of passengers, and time of arrival if lineNum is illegal it will be set to 1. if pass is illegal it will be set to 0.
     * @param lineNum The bus line number (should be between {@value #MIN_LINE_NUM}-{@value #MAX_LINE_NUM}).
     * @param pass The number of passengers (should be between {@value #MIN_VALUE}-{@value #MAX_PASSENGERS_COUNT}).
     * @param t The time of bus arrival.
     */
    public BusArrival(int lineNum, int pass, Time1 t) {
        _lineNumber = validateLineNum(lineNum);
        _arrivalTime = new Time1(t);
        _noOfPassengers = validatePassNum(pass);
    }

    /**
     * Copy constructor for a BusArrival. Constructs a BusArrival with the same attributes as another BusArrival.
     * @param other The BusArrival object from which to construct the new BusArrival.
     */
    public BusArrival(BusArrival other) {
        _lineNumber = other._lineNumber;
        _arrivalTime = new Time1(other._arrivalTime);
        _noOfPassengers = other._noOfPassengers;
    }

    /**
     * Returns the bus arrival time.
     * @return the bus arrival time.
     */
    public Time1 getArrivalTime() {
        return new Time1(_arrivalTime);
    }

    /**
     * Returns the bus line number.
     * @return the bus line number.
     */
    public int getLineNum() {
        return _lineNumber;
    }

    /**
     * Returns the number of passengers.
     * @return the number of passengers.
     */
    public int getNoOfPass() {
        return _noOfPassengers;
    }

    /**
     * Changes the BusArrival's time.
     * @param t The BusArrival's new time.
     */
    public void setArrivalTime(Time1 t) {
        _arrivalTime = new Time1(t);
    }

    /**
     * Changes the BusArrival's line number. if the parameter is illegal the line number will remain unchanged.
     * @param num The BusArrival's new line number.
     */
    public void setLineNum(int num) {
        if (isValid(num, MIN_LINE_NUM, MAX_LINE_NUM))
            _lineNumber = num;
    }

    /**
     * Changes the BusArrival's number of passengers. if the parameter is illegal the number of passengers will remain unchanged.
     * @param num The BusArrival's new number of passengers.
     */
    public void setNoOfPass(int num) {
        if (isValid(num, MIN_VALUE, MAX_PASSENGERS_COUNT))
            _noOfPassengers = num;
    }

    /**
     * Checks if the received BusArrival is equal to this BusArrival.
     * @param other The BusArrival to be compared with this BusArrival.
     * @return true if the received BusArrival is equal to this BusArrival
     */
    public boolean equals(BusArrival other) {
        return other._lineNumber == _lineNumber &&
                other._arrivalTime.equals(_arrivalTime) &&
                other._noOfPassengers == _noOfPassengers;
    }

    /**
     * Returns a string representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
     * @return String representation of this BusArrival (for example: "Bus no. 27 arrived at 09:24:10 with 13 passengers").
     */
    @Override
    public String toString() {
        return "Bus no. " + _lineNumber +
                " arrived at " + _arrivalTime.toString() +
                " with " + _noOfPassengers + " passengers";
    }

    /**
     * Checks if this bus's number of passengers is larger than other bus's number of passengers.
     * @param other The BusArrival to be compared with this BusArrival.
     * @return true if this bus's number of passengers is larger than other bus's number of passengers. false otherwise.
     */
    public boolean fuller(BusArrival other) {
        return _noOfPassengers > other._noOfPassengers;
    }

    /**
     * Checks if this bus's arrival time is before other bus's arrival time.
     * @param other The BusArrival to be compared with this BusArrival.
     * @return true if this bus's arrival time is before other bus's arrival time. false otherwise.
     */
    public boolean before(BusArrival other) {
        return _arrivalTime.before(other._arrivalTime);
    }

    /**
     * Checks if this bus's number of passengers is equal to the maximum number of passengers allowed.
     * @return true if this bus's number of passengers is equal to the maximum number of passengers allowed. false otherwise.
     */
    public boolean isFull() {
        return _noOfPassengers == MAX_PASSENGERS_COUNT;
    }

    /**
     * Calculates the difference (in minutes) between this bus arrival time and other.
     * @param other The time to check the difference with.
     * @return int difference in minutes
     */
    public int elapsedTime(BusArrival other) {
        return Math.abs(_arrivalTime.difference(other._arrivalTime)) / 60;
    }

    /**
     * Validates the value of Line Number.
     * @param value The line number.
     * @return The value if valid. Otherwise, {@value #MIN_LINE_NUM} (aka. {@code MIN_LINE_NUM})
     */
    private int validateLineNum(int value) {
        return validate(value, MIN_LINE_NUM, MAX_LINE_NUM);
    }

    /**
     * Validates the value of Number of Passengers.
     * @param value The number of passengers.
     * @return The value if valid. Otherwise, {@value #MIN_VALUE} (aka. {@code MIN_VALUE})
     */
    private int validatePassNum(int value) {
        return validate(value, MIN_VALUE, MAX_PASSENGERS_COUNT);
    }

    /**
     * Validates the value of number.
     * @param value The value of number.
     * @return The value if valid. Otherwise, {@code min}
     */
    private int validate(int value, int min, int max) {
        return isValid(value, min, max) ? value : min;
    }

    /**
     * Checks if value of number is valid.
     * @param value The value to check.
     * @param min The min value allowed.
     * @param max The max value allowed.
     * @return True if {@code value} is valid.
     */
    private boolean isValid(int value, int min, int max) {
        return value <= max && value >= min;
    }
}

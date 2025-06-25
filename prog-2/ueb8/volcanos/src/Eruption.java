public class Eruption {

    private final int volcanoNumber;
    private final String volcanoName;
    private final int eruptionNumber;
    private final int startYear;
    private final int startMonth;
    private final int startDay;
    private final String evidenceMethod;
    private final int endYear;
    private final int endMonth;
    private final int endDay;
    private final double latitude;
    private final double longitude;

    public Eruption(int volcanoNumber, String volcanoName, int eruptionNumber,
                   int startYear, int startMonth, int startDay,
                   String evidenceMethod, int endYear, int endMonth, int endDay,
                   double latitude, double longitude) {
        this.volcanoNumber = volcanoNumber;
        this.volcanoName = volcanoName;
        this.eruptionNumber = eruptionNumber;
        this.startYear = startYear;
        this.startMonth = startMonth == 0 ? 1 : startMonth;
        this.startDay = startDay == 0 ? 1 : startDay;
        this.evidenceMethod = evidenceMethod.isEmpty() ? "Unknown" : evidenceMethod;
        this.endYear = endYear == 0 ? startYear : endYear;
        this.endMonth = endMonth == 0 ? 12 : endMonth;
        this.endDay = endDay == 0 ? 31 : endDay;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getVolcanoNumber() {
        return volcanoNumber;
    }

    public String getVolcanoName() {
        return volcanoName;
    }

    public int getEruptionNumber() {
        return eruptionNumber;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public String getEvidenceMethod() {
        return evidenceMethod;
    }

    public int getEndYear() {
        return endYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int duration() {
        return (this.endYear - this.startYear) * 365 + (this.endMonth - this.startMonth) * 30 + (this.endDay - this.startDay);
    }

    public int timeDifference(Eruption other) {
        return (this.startYear - other.startYear) * 365 + (this.startMonth - other.startMonth) * 30 + (this.startDay - other.startDay);
    }

    @Override
    public String toString() {
        return "Eruption{" +
                "volcanoNumber=" + volcanoNumber +
                ", volcanoName='" + volcanoName + '\'' +
                ", eruptionNumber=" + eruptionNumber +
                ", startYear=" + startYear +
                ", startMonth=" + startMonth +
                ", startDay=" + startDay +
                ", evidenceMethod='" + evidenceMethod + '\'' +
                ", endYear=" + endYear +
                ", endMonth=" + endMonth +
                ", endDay=" + endDay +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

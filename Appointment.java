package oopproject22621626;

public class Appointment {
    private String date;
    private String startTime;
    private String endTime;
    private String name;
    private String note;

    public Appointment(String date, String startTime, String endTime, String name, String note) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.note = note;
    }
    public String getDate() {
        return date;
    }

    public boolean matches(String date, String startTime) {
        return this.date.equals(date) && this.startTime.equals(startTime);
    }

    public boolean matches(String date, String startTime, String endTime) {
        return this.date.equals(date) && this.startTime.equals(startTime) && this.endTime.equals(endTime);
    }

    public void change(String option, String newValue) {
        switch (option.toLowerCase()) {
            case "date":
                this.date = newValue;
                break;
            case "starttime":
                this.startTime = newValue;
                break;
            case "endtime":
                this.endTime = newValue;
                break;
            case "name":
                this.name = newValue;
                break;
            case "note":
                this.note = newValue;
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    public boolean contains(String searchString) {
        return date.contains(searchString) || startTime.contains(searchString) || endTime.contains(searchString)
                || name.contains(searchString) || note.contains(searchString);
    }

    @Override
    public String toString() {
        return String.format("Appointment[date=%s, startTime=%s, endTime=%s, name=%s, note=%s]",
                date, startTime, endTime, name, note);
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
    public boolean isOverlapping(Appointment other) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime thisStart = LocalDateTime.parse(this.date + "T" + this.startTime);
        LocalDateTime thisEnd = LocalDateTime.parse(this.date + "T" + this.endTime);
        LocalDateTime otherStart = LocalDateTime.parse(other.date + "T" + other.startTime);
        LocalDateTime otherEnd = LocalDateTime.parse(other.date + "T" + other.endTime);

        return (thisStart.isBefore(otherEnd) && otherStart.isBefore(thisEnd));
    }
}

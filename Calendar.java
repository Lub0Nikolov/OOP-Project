import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calendar {

    private boolean isOpen;
    private String filePath;
    private List<Appointment> appointments;

    public Calendar() {
        this.isOpen = false;
        this.appointments = new ArrayList<>();
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open(String filePath) throws IOException {
        if (isOpen) {
            throw new IllegalStateException("A file is already open. Close it first.");
        }
        this.filePath = filePath;
        this.isOpen = true;
        System.out.println("File " + filePath + " opened.");
    }

    public void close() {
        if (!isOpen) {
            throw new IllegalStateException("No file is open.");
        }
        this.filePath = null;
        this.isOpen = false;
        System.out.println("File closed.");
    }

    public void save() throws IOException {
        if (!isOpen) {
            throw new IllegalStateException("No file is open to save.");
        }
        System.out.println("Appointments saved to " + filePath);
    }

    public void saveAs(String newFilePath) throws IOException {
        this.filePath = newFilePath;
        save();
        System.out.println("Appointments saved as " + newFilePath);
    }

    public boolean book(Appointment appointment) {
        if (isConflicting(appointment)) {
            System.out.println("Scheduling conflict detected. Appointment not booked.");
            return false;
        }
        appointments.add(appointment);
        System.out.println("Appointment booked: " + appointment);
        return true;
    }

    private boolean isConflicting(Appointment newAppointment) {
        for (Appointment appointment : appointments) {
            if (appointment.isOverlapping(newAppointment)) {
                return true;
            }
        }
        return false;
    }

    public void unbook(Appointment appointment) {
        if (appointments.remove(appointment)) {
            System.out.println("Appointment unbooked: " + appointment);
        } else {
            System.out.println("Appointment not found: " + appointment);
        }
    }

    public List<Appointment> agenda(String date) {
        return appointments.stream()
                .filter(appt -> appt.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Appointment> find(String searchString) {
        return appointments.stream()
                .filter(appt -> appt.getDate().contains(searchString) ||
                        appt.getStartTime().contains(searchString) ||
                        appt.getEndTime().contains(searchString) ||
                        appt.getName().contains(searchString) ||
                        appt.getNote().contains(searchString))
                .collect(Collectors.toList());
    }

    public void markHoliday(String date) {
        Appointment holiday = new Appointment(date, "00:00", "23:59", "Holiday", "Holiday");
        appointments.add(holiday);
        System.out.println("Holiday marked: " + date);
    }
    public List<String> getBusyDays(String from, String to) {
        return appointments.stream()
                .map(Appointment::getDate)
                .filter(date -> date.compareTo(from) >= 0 && date.compareTo(to) <= 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments);
    }
}
package oopproject22621626;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

        private List<Appointment> appointments;
        private boolean isOpen;
        private String filePath;

        public Calendar() {
            this.appointments = new ArrayList<>();
            this.isOpen = false;
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void open(String filePath) throws IOException {
            this.filePath = filePath;
            this.appointments = loadFromFile(filePath);
            this.isOpen = true;
        }

        public void close() {
            this.isOpen = false;
            this.appointments.clear();
            this.filePath = null;
        }

        public void save() throws IOException {
            if (filePath == null) {
                throw new IOException("No file open to save.");
            }
            saveToFile(filePath);
        }

        public void saveAs(String newFilePath) throws IOException {
            saveToFile(newFilePath);
        }

        public void book(String date, String startTime, String endTime, String name, String note) {
            appointments.add(new Appointment(date, startTime, endTime, name, note));
        }

        public void unbook(String date, String startTime, String endTime) {
            appointments.removeIf(appointment -> appointment.matches(date, startTime, endTime));
        }

        public List<Appointment> agenda(String date) {
            List<Appointment> agenda = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.getDate().equals(date)) {
                    agenda.add(appointment);
                }
            }
            return agenda;
        }

        public void change(String date, String startTime, String option, String newValue) {
            for (Appointment appointment : appointments) {
                if (appointment.matches(date, startTime)) {
                    appointment.change(option, newValue);
                    break;
                }
            }
        }

        public List<Appointment> find(String searchString) {
            List<Appointment> results = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.contains(searchString)) {
                    results.add(appointment);
                }
            }
            return results;
        }

        public void holiday(String date) {

        }

        public List<String> busydays(String from, String to) {

            return new ArrayList<>();
        }

        public String findslot(String fromDate, int hours) {

            return null;
        }

        public String findslotwith(String fromDate, int hours, String calendarFilePath) {

            return null;
        }

        public void merge(String calendarFilePath) {

        }

        private List<Appointment> loadFromFile(String filePath) throws IOException {

            return new ArrayList<>();
        }

        private void saveToFile(String filePath) throws IOException {

        }

    public void findSlotWith(String arg, int i, String arg1) {
    }

    public void findSlot(String arg, int i) {
    }

    public void listBusyDays(String arg, String arg1) {
    }

    public void listAppointments(String arguments) {
    }

    public void changeAppointment(String arg, String arg1, String arg2, String arg3) {
    }

    public void searchAppointments(String arguments) {
    }

    public void markHoliday(String arguments) {
    }
}

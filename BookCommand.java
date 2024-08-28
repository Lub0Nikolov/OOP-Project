import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookCommand implements Command {
    private Calendar calendar;

    public BookCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        String[] args = arguments.split(" ", 4);
        if (args.length < 4) {
            System.out.println("Invalid arguments. Usage: book <date> <starttime> <endtime> <name> <note>");
            return;
        }

        String dateStr = args[0];
        String startTime = args[1];
        String endTime = args[2];
        String remaining = args[3];

        if (!isValidDate(dateStr, "yyyy-MM-dd")) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        if (!isValidTime(startTime, "HH:mm") || !isValidTime(endTime, "HH:mm")) {
            System.out.println("Invalid time format. Please use HH:mm.");
            return;
        }

        int firstSpaceIndex = remaining.indexOf(' ');
        if (firstSpaceIndex == -1) {
            System.out.println("Invalid arguments. Please provide both name and note.");
            return;
        }
        String name = remaining.substring(0, firstSpaceIndex).trim();
        String note = remaining.substring(firstSpaceIndex + 1).trim();

        Appointment appointment = new Appointment(dateStr, startTime, endTime, name, note);

        boolean success = calendar.book(appointment);
        if (success) {
            System.out.println("Successfully booked the meeting.");
        } else {
            System.out.println("Failed to book the meeting. There may be a scheduling conflict.");
        }
    }

    private boolean isValidDate(String dateStr, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidTime(String timeStr, String format) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(format);
        timeFormat.setLenient(false);
        try {
            timeFormat.parse(timeStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
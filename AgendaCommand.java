import java.util.List;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaCommand implements Command {
    private Calendar calendar;

    public AgendaCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Please specify a date.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date date;
        try {
            date = dateFormat.parse(arguments);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        List<Appointment> agenda = calendar.agenda(arguments);
        if (agenda == null || agenda.isEmpty()) {
            System.out.println("No appointments found for " + arguments);
        } else {
            System.out.println("Agenda for " + arguments + ":");
            for (Appointment appointment : agenda) {
                System.out.println(appointment);
            }
        }
    }
}

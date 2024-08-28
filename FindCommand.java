import java.util.List;

public class FindCommand implements Command {
    private Calendar calendar;

    public FindCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Please specify a string to search for.");
            return;
        }
        List<Appointment> results = calendar.find(arguments);
        if (results.isEmpty()) {
            System.out.println("No appointments found containing '" + arguments + "'");
        } else {
            System.out.println("Found appointments:");
            for (Appointment appointment : results) {
                System.out.println(appointment);
            }
        }
    }
}
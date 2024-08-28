import java.util.List;

public class BusyDaysCommand implements Command {
    private Calendar calendar;

    public BusyDaysCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        String[] args = arguments.split(" ", 2);
        if (args.length < 2) {
            System.out.println("Invalid arguments. Usage: busydays <from> <to>");
            return;
        }
        List<String> busyDays = calendar.getBusyDays(args[0], args[1]);
        if (busyDays.isEmpty()) {
            System.out.println("No busy days found between " + args[0] + " and " + args[1]);
        } else {
            System.out.println("Busy days between " + args[0] + " and " + args[1] + ":");
            for (String day : busyDays) {
                System.out.println(day);
            }
        }
    }
}
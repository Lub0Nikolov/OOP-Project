public class UnbookCommand implements Command {
    private Calendar calendar;

    public UnbookCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        String[] args = arguments.split(" ", 3);
        if (args.length < 3) {
            System.out.println("Invalid arguments. Usage: unbook <date> <starttime> <endtime>");
            return;
        }

        String date = args[0];
        String startTime = args[1];
        String endTime = args[2];

        Appointment appointment = new Appointment(date, startTime, endTime, "", "");

        calendar.unbook(appointment);
        System.out.println("Successfully canceled the meeting.");
    }
}
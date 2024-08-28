public class HolidayCommand implements Command {
    private Calendar calendar;

    public HolidayCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Please specify a date.");
            return;
        }
        calendar.markHoliday(arguments);
        System.out.println("Successfully marked " + arguments + " as a holiday.");
    }
}
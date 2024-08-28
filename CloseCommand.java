public class CloseCommand implements Command {
    private Calendar calendar;

    public CloseCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) {
        calendar.close();
        System.out.println("Successfully closed the file.");
    }
}

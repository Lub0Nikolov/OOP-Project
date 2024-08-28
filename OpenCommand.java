import java.io.IOException;

public class OpenCommand implements Command {
    private Calendar calendar;

    public OpenCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) throws IOException {
        if (calendar.isOpen()) {
            System.out.println("A file is already open. Close it first.");
            return;
        }
        if (arguments.isEmpty()) {
            System.out.println("Please specify a file path.");
            return;
        }
        calendar.open(arguments);
        System.out.println("Successfully opened " + arguments);
    }
}

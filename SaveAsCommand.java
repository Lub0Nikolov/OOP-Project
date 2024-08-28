import java.io.IOException;

public class SaveAsCommand implements Command {
    private Calendar calendar;

    public SaveAsCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) throws IOException {
        if (arguments.isEmpty()) {
            System.out.println("Please specify a file path.");
            return;
        }
        calendar.saveAs(arguments);
        System.out.println("Successfully saved as " + arguments);
    }
}
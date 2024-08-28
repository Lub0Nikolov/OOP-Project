import java.io.IOException;

public class SaveCommand implements Command {
    private Calendar calendar;

    public SaveCommand(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(String arguments) throws IOException {
        calendar.save();
        System.out.println("Successfully saved the file.");
    }
}
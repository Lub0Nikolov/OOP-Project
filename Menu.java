import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Command> commands = new HashMap<>();

    public Menu(Calendar calendar) {
        commands.put("open", new OpenCommand(calendar));
        commands.put("close", new CloseCommand(calendar));
        commands.put("save", new SaveCommand(calendar));
        commands.put("saveas", new SaveAsCommand(calendar));
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("book", new BookCommand(calendar));
        commands.put("unbook", new UnbookCommand(calendar));
        commands.put("agenda", new AgendaCommand(calendar));
        commands.put("find", new FindCommand(calendar));
        commands.put("holiday", new HolidayCommand(calendar));
        commands.put("busydays", new BusyDaysCommand(calendar));
    }

    public void executeCommand(String commandName, String arguments) {
        Command command = commands.get(commandName.toLowerCase());
        if (command != null) {
            try {
                command.execute(arguments);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Unknown command. Type 'help' for a list of commands.");
        }
    }
}
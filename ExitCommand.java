public class ExitCommand implements Command {
    @Override
    public void execute(String arguments) {
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
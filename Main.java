import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        Menu menu = new Menu(calendar);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String commandName = parts[0];
            String arguments = parts.length > 1 ? parts[1] : "";
            menu.executeCommand(commandName, arguments);
        }
    }
}

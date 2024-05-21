package oopproject22621626;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalCalendarCLI {
    private static final Map<String, Command> commands = new HashMap<>();
    private static final Calendar calendar = new Calendar();

    public static void main(String[] args) {
        initializeCommands();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ", 2);
            String commandName = inputParts[0].toLowerCase();
            String arguments = inputParts.length > 1 ? inputParts[1] : "";

            Command command = commands.get(commandName);
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

    private static void initializeCommands() {
        commands.put("open", arguments -> {
            if (calendar.isOpen()) {
                System.out.println("A file is already open. Close it first.");
                return;
            }
            if (arguments.isEmpty()) {
                System.out.println("Please specify a file path.");
                return;
            }
            try {
                calendar.open(arguments);
                System.out.println("Successfully opened " + arguments);
            } catch (IOException e) {
                System.out.println("Failed to open file: " + e.getMessage());
            }
        });

        commands.put("close", arguments -> {
            calendar.close();
            System.out.println("Successfully closed the file.");
        });

        commands.put("save", arguments -> {
            try {
                calendar.save();
                System.out.println("Successfully saved the file.");
            } catch (IOException e) {
                System.out.println("Failed to save file: " + e.getMessage());
            }
        });

        commands.put("saveas", arguments -> {
            if (arguments.isEmpty()) {
                System.out.println("Please specify a file path.");
                return;
            }
            try {
                calendar.saveAs(arguments);
                System.out.println("Successfully saved as " + arguments);
            } catch (IOException e) {
                System.out.println("Failed to save file: " + e.getMessage());
            }
        });

        commands.put("help", arguments -> System.out.println(
                "The following commands are supported:\n" +
                        "open <file>    - opens <file>\n" +
                        "close          - closes currently opened file\n" +
                        "save           - saves the currently open file\n" +
                        "saveas <file>  - saves the currently open file in <file>\n" +
                        "help           - prints this information\n" +
                        "exit           - exits the program\n" +
                        "book <date> <starttime> <endtime> <name> <note> - books a meeting\n" +
                        "unbook <date> <starttime> <endtime> - cancels a meeting\n" +
                        "agenda <date>  - lists all appointments for <date>\n" +
                        "change <date> <starttime> <option> <newvalue> - changes an appointment\n" +
                        "find <string>  - searches for appointments\n" +
                        "holiday <date> - marks <date> as a holiday\n" +
                        "busydays <from> <to> - lists busy days between <from> and <to>\n" +
                        "findslot <fromdate> <hours> - finds a slot for a meeting\n" +
                        "findslotwith <fromdate> <hours> <calendar> - finds a slot synced with another calendar\n" +
                        "merge <calendar> - merges another calendar"
        ));

        commands.put("exit", arguments -> {
            System.out.println("Exiting the program...");
            System.exit(0);
        });


        commands.put("book", arguments -> {
            String[] args = arguments.split(" ", 5);
            if (args.length < 5) {
                System.out.println("Invalid arguments. Usage: book <date> <starttime> <endtime> <name> <note>");
                return;
            }
            calendar.book(args[0], args[1], args[2], args[3], args[4]);
            System.out.println("Successfully booked the meeting.");
        });

        commands.put("unbook", arguments -> {
            String[] args = arguments.split(" ", 3);
            if (args.length < 3) {
                System.out.println("Invalid arguments. Usage: unbook <date> <starttime> <endtime>");
                return;
            }
            calendar.unbook(args[0], args[1], args[2]);
            System.out.println("Successfully canceled the meeting.");
        });

        commands.put("agenda", arguments -> {
            if (arguments.isEmpty()) {
                System.out.println("Please specify a date.");
                return;
            }
            calendar.listAppointments(arguments);
        });

        commands.put("change", arguments -> {
            String[] args = arguments.split(" ", 4);
            if (args.length < 4) {
                System.out.println("Invalid arguments. Usage: change <date> <starttime> <option> <newvalue>");
                return;
            }
            calendar.changeAppointment(args[0], args[1], args[2], args[3]);
        });

        commands.put("find", arguments -> {
            if (arguments.isEmpty()) {
                System.out.println("Please specify a string to search for.");
                return;
            }
            calendar.searchAppointments(arguments);
        });

        commands.put("holiday", arguments -> {
            if (arguments.isEmpty()) {
                System.out.println("Please specify a date.");
                return;
            }
            calendar.markHoliday(arguments);
            System.out.println("Successfully marked " + arguments + " as a holiday.");
        });

        commands.put("busydays", arguments -> {
            String[] args = arguments.split(" ", 2);
            if (args.length < 2) {
                System.out.println("Invalid arguments. Usage: busydays <from> <to>");
                return;
            }
            calendar.listBusyDays(args[0], args[1]);
        });

        commands.put("findslot", arguments -> {
            String[] args = arguments.split(" ", 2);
            if (args.length < 2) {
                System.out.println("Invalid arguments. Usage: findslot <fromdate> <hours>");
                return;
            }
            calendar.findSlot(args[0], Integer.parseInt(args[1]));
        });

        commands.put("findslotwith", arguments -> {
            String[] args = arguments.split(" ", 3);
            if (args.length < 3) {
                System.out.println("Invalid arguments. Usage: findslotwith <fromdate> <hours> <calendar>");
                return;
            }
            calendar.findSlotWith(args[0], Integer.parseInt(args[1]), args[2]);
        });

        commands.put("merge", arguments -> {
            if (arguments.isEmpty()) {
                System.out.println("Please specify a calendar to merge.");
                return;
            }
            calendar.merge(arguments);
            System.out.println("Successfully merged with calendar " + arguments);
        });

    }

    @FunctionalInterface
    private interface Command {
        void execute(String arguments) throws Exception;
    }
}


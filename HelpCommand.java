public class HelpCommand implements Command {
    @Override
    public void execute(String arguments) {
        System.out.println(
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
                        "find <string>  - searches for appointments\n" +
                        "holiday <date> - marks <date> as a holiday\n" +
                        "busydays <from> <to> - lists busy days between <from> and <to>\n"
        );
    }
}
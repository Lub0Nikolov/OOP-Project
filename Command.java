@FunctionalInterface
public interface Command {
    void execute(String arguments) throws Exception;
}
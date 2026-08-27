public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    private String commandType = "";

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        commandType = commandTypeOf(input);
        return "Duke heard: " + input;
    }

    /**
     * Returns the kind of command the last message asked for, so that the GUI can
     * style the reply differently for adding, marking and deleting tasks.
     */
    public String getCommandType() {
        return commandType;
    }

    private static String commandTypeOf(String input) {
        String keyword = input.trim().split(" ", 2)[0].toLowerCase();
        return switch (keyword) {
        case "todo", "deadline", "event" -> "AddCommand";
        case "mark", "unmark" -> "ChangeMarkCommand";
        case "delete" -> "DeleteCommand";
        default -> "UnknownCommand";
        };
    }
}

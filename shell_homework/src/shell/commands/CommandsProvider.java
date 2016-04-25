package shell.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsProvider {

	private Map<String, Command> commands;

	private CommandsProvider() {
		commands = new HashMap<>();
	}

	public void addCommand(String name, Command command) {
		commands.put(name, command);
	}

	public void executeCommand(String name) {
		if (commands.containsKey(name)) {
			commands.get(name).execute();
		}

	}

	public static CommandsProvider init() {
		CommandsProvider commandsProvider = new CommandsProvider();

		commandsProvider.addCommand("dir", new Dir());
		commandsProvider.addCommand("tree", new Tree());

		return commandsProvider;
	}

}

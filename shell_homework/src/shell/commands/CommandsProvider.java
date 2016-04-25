package shell.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsProvider {

	private Map<String, Command> commands;
	private Prompt prompt;

	private CommandsProvider() {
		commands = new HashMap<>();
	}

	public void addCommand(String name, Command command) {
		commands.put(name, command);
	}

	public void executeCommand(String name) {
		if (commands.containsKey(name)) {
			commands.get(name).execute();
		} else {
			System.out.println(name + " : unknown command");
			commands.get("prompt").execute();
		}

	}

	public static CommandsProvider init() {
		CommandsProvider commandsProvider = new CommandsProvider();
		commandsProvider.prompt = new Prompt("");

		commandsProvider.addCommand("prompt", commandsProvider.getPrompt());
		commandsProvider.addCommand("dir", new Dir());
		commandsProvider.addCommand("tree", new Tree());
		commandsProvider.addCommand("prompt reset", new PromptReset(commandsProvider.prompt));
		commandsProvider.addCommand("prompt asd", new PromptParam(commandsProvider.prompt, "trololo"));

		return commandsProvider;
	}

	public Prompt getPrompt() {
		return prompt;
	}

}

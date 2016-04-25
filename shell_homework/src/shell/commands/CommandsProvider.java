package shell.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsProvider {

	private Map<CommandLine, Command> commands;
	private Prompt prompt;

	private CommandsProvider() {
		commands = new HashMap<>();
	}

	public void addCommand(CommandLine commandLine, Command command) {
		commands.put(commandLine, command);
	}

	public void executeCommand(CommandLine commandLine) {
		if (commands.containsKey(commandLine)) {
			commands.get(commandLine).execute();
		} 
//		else if (commandLine.getCommandName().equals("prompt")) {
//			addCommand(new CommandLine("prompt"), new PromptParam(getPrompt(), commandLine.getCommandParameter()));
		//		}
	else {
			System.out.println(commandLine.getCommandName() + " : unknown command");
		}
		

	}

	public static CommandsProvider init() {
		CommandsProvider commandsProvider = new CommandsProvider();

		commandsProvider.prompt = new Prompt();

		commandsProvider.addCommand(new CommandLine("prompt"), commandsProvider.getPrompt());

		commandsProvider.addCommand(new CommandLine("prompt", "reset"), new PromptReset(commandsProvider.getPrompt()));

		commandsProvider.addCommand(new CommandLine("dir"), new Dir());

		commandsProvider.addCommand(new CommandLine("tree"), new Tree());

		commandsProvider.addCommand(new CommandLine("exit"), new Exit());

		return commandsProvider;
	}

	public Prompt getPrompt() {
		return prompt;
	}

}

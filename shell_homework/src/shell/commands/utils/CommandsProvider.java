package shell.commands.utils;

import java.util.HashMap;
import java.util.Map;

import shell.commands.Dir;
import shell.commands.Exit;
import shell.commands.ParentDir;
import shell.commands.Prompt;
import shell.commands.PromptCwd;
import shell.commands.PromptReset;
import shell.commands.Tree;
import shell.commands.interfaces.Command;

public class CommandsProvider {

	private Map<CommandLine, Command> commands;
	private Prompt prompt;
	CommandCreator commandCreator;

	private CommandsProvider() {
		commands = new HashMap<>();
		prompt = new Prompt("$");
		commandCreator = new CommandCreator(prompt);
	}

	public void addCommand(CommandLine commandLine, Command command) {
		commands.put(commandLine, command);
	}

	public void executeCommand(CommandLine commandLine) {
		if (commands.containsKey(commandLine)) {
			commands.get(commandLine).execute();
		} else {
			try {
				commandCreator.createCommand(commandLine);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static CommandsProvider init() {
		CommandsProvider commandsProvider = new CommandsProvider();

		commandsProvider.addCommand(new CommandLine("prompt", "$cwd"), new PromptCwd(commandsProvider.getPrompt()));
		commandsProvider.addCommand(new CommandLine("prompt", "reset"), new PromptReset(commandsProvider.getPrompt()));
		commandsProvider.addCommand(new CommandLine("dir"), new Dir(commandsProvider.getPrompt()));
		commandsProvider.addCommand(new CommandLine("tree"), new Tree(commandsProvider.getPrompt()));
		commandsProvider.addCommand(new CommandLine("exit"), new Exit());
		commandsProvider.addCommand(new CommandLine("cd", ".."), new ParentDir(commandsProvider.getPrompt()));

		return commandsProvider;
	}

	public Prompt getPrompt() {
		return prompt;
	}

}

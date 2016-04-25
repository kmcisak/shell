package shell.commands.utils;

import shell.commands.Prompt;

public class CommandCreator {

	Prompt prompt;

	public CommandCreator(Prompt prompt) {
		this.prompt = prompt;
	}

	public void createCommand(CommandLine commandLine) throws Exception {
		if (commandLine.getCommandName().equals("prompt")) {
			prompt.setParameter(commandLine.getCommandParameter());
		} else {
			throw new Exception(commandLine.getCommandName() + " : unknown command");
		}
	}

}

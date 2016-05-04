package shell.commands.utils;

import shell.commands.Cd;
import shell.commands.Prompt;
import shell.commands.interfaces.Command;
import shell.exceptions.CommandNotSupportedException;

public class CommandCreator {

	Prompt prompt;
	CommandLine commandLine;

	public CommandCreator(Prompt prompt, CommandLine commandLine) {
		this.commandLine = commandLine;
		this.prompt = prompt;
	}

	public Command createCommand() throws Exception {
		if (commandLine.getCommandName().equals("prompt")) {
			prompt.setParameter(commandLine.getCommandParameter());
			return prompt;
		} else if (commandLine.getCommandName().equals("cd")) {
			Cd cd = new Cd(prompt, commandLine);

			return cd.returnCd();

		} else {
			throw new CommandNotSupportedException(commandLine.getCommandName() + " : unknown command");
		}
	}

}

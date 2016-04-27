package shell.commands;

import shell.commands.interfaces.Command;
import shell.commands.utils.CommandLine;

public class Cd implements Command {

	Prompt prompt;
	CommandLine commandLine;

	public Cd(Prompt prompt, CommandLine commandLine) {
		this.prompt = prompt;
		this.commandLine = commandLine;
	}

	@Override
	public void execute() {

	}

	public Command returnCd() throws Exception {
		Command command;
		if (commandLine.getCommandParameter().length() != 0) {
			if (commandLine.getCommandParameter().equals("..")) {
				command = new ParentDir(prompt);
				return command;
			} else {
				command = new ChildDir(prompt, commandLine.getCommandParameter());
				return command;
			}
		}
		throw new Exception("cd must have argument");
	}

}

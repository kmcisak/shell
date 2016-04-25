package shell.commands;

import shell.commands.interfaces.Command;

public class PromptCwd implements Command {
	
	public PromptCwd() {
	}

	@Override
	public void execute() {
		System.out.println("cwd execute...");
	}
}

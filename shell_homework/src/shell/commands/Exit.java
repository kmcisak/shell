package shell.commands;

import shell.commands.interfaces.Command;

public class Exit implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}
}

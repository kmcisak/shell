package shell.commands;

import shell.commands.interfaces.Command;

public class Prompt implements Command {

	String parameter;

	public Prompt(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public void execute() {
		printPrompt();
	}

	private void printPrompt() {
		System.out.print("[MyShell] " + parameter + ">");
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}

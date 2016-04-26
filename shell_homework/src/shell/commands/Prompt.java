package shell.commands;

import shell.commands.interfaces.Command;

public class Prompt implements Command {

	String parameter;
	Cwd cwd;

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
	
	public void setCwd(Cwd cwd) {
		this.cwd = cwd;
		this.parameter = cwd.toString();
	}
}

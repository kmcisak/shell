package shell.commands;

public class Prompt implements Command {

	String parameter;

	public Prompt(String parameter) {
		if (parameter.equals("reset")) {
			this.parameter = "$>";
		} else {
			this.parameter = parameter + ">";
		}
	}

	@Override
	public void execute() {
		System.out.print("[MyShell] " + parameter);

	}

	public void setParameter(String parameter) {
		this.parameter = parameter + ">";
	}

	public void reset() {
		this.parameter = " $>";
	}

}

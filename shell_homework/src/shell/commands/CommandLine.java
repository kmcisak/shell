package shell.commands;

import java.util.Objects;

public class CommandLine {

	private String commandName;
	private String commandParameter;

	public CommandLine() {
	}

	public CommandLine(String commandName, String commadParameter) {
		this.commandName = commandName;
		this.commandParameter = commadParameter;
	}

	public CommandLine(String commandName) {
		this.commandName = commandName;
		this.commandParameter = "";
	}

	public void prepareCommandLine(String[] commandLine) {
		if (commandLine.length > 1) {
			setCommandName(commandLine[0]);
			setCommandParameter(commandLine[1]);
		} else {
			setCommandName(commandLine[0]);
			setCommandParameter("");
		}

	}

	public void prepareComandLine(String commandName) {
		this.commandName = commandName;
		this.commandParameter = "";

	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandParameter() {
		return commandParameter;
	}

	public void setCommandParameter(String commandParameter) {
		this.commandParameter = commandParameter;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(this.getClass().equals(obj.getClass())))
			return false;
		CommandLine otherCommandLine = (CommandLine) obj;
		return (null == getCommandName() ? null == otherCommandLine.getCommandName()
				: getCommandName().equals(otherCommandLine.getCommandName()))
				&& (null == getCommandParameter() ? null == otherCommandLine.getCommandParameter()
						: getCommandParameter().equals(otherCommandLine.getCommandParameter()));
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.commandName);
	}

}

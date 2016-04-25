package shell.commands;

import shell.commands.interfaces.Command;

public class PromptReset implements Command {

	Prompt prompt;

	public PromptReset(Prompt prompt) {
		this.prompt = prompt;
	}

	@Override
	public void execute() {
		reset();
	}
	
	private void reset(){
		prompt.parameter = "$";
	}
}
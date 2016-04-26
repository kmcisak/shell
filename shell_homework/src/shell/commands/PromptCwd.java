package shell.commands;

import shell.commands.interfaces.Command;

public class PromptCwd implements Command {
	
	Prompt prompt;
	
	public PromptCwd(Prompt prompt) {
		this.prompt = prompt;
	}

	@Override
	public void execute() {
		setCwd(prompt);
	}
	
	private void setCwd(Prompt prompt) {
		Cwd cwd = new Cwd();
		cwd.updateCwd();
		prompt.setCwd(cwd);
	}
	
}

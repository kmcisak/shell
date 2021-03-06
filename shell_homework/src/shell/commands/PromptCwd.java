package shell.commands;

import java.io.File;

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
		File file = new File(".");
		Cwd cwd = new Cwd(file);
		cwd.updateCwdName();
		prompt.setCwd(cwd);
	}

}

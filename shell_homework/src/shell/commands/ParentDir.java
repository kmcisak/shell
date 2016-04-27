package shell.commands;

import java.io.File;

import shell.commands.interfaces.Command;

public class ParentDir implements Command {

	Prompt prompt;

	public ParentDir(Prompt prompt) {
		this.prompt = prompt;
	}

	@Override
	public void execute() {
		Cwd cwd = new Cwd(new File(".."));
		cwd.updateCwdName();
		prompt.setCwd(cwd);
		System.setProperty("user.dir", prompt.getCurrentCwd().cwd);
	}

}

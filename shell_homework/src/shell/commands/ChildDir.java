package shell.commands;

import java.io.File;

import shell.commands.interfaces.Command;

public class ChildDir implements Command {

	Prompt prompt;
	String dirName;

	public ChildDir(Prompt prompt, String dirName) {
		this.prompt = prompt;
		this.dirName = dirName;
	}

	@Override
	public void execute() {
		File dir = new File(dirName).getAbsoluteFile();

		if (!dir.exists()) {
			System.out.println("No such directory");
		} else if (!dir.isDirectory()) {
			System.out.println(dirName + " is not a directory");
		} else {
			Cwd cwd = new Cwd(dir);
			prompt.setCwd(cwd);
			System.setProperty("user.dir", dir.getAbsolutePath());
		}
	}
}

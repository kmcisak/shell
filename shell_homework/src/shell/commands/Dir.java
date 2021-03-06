package shell.commands;

import java.io.File;

import shell.commands.interfaces.Command;

public class Dir implements Command {

	Prompt prompt;

	public Dir(Prompt prompt) {
		this.prompt = prompt;
	}

	@Override
	public void execute() {
		File dir = new File(prompt.getCurrentCwd().toString());
		printDir(dir);
	}

	private void printDir(File directory) {
		File[] filesList = directory.listFiles();
		for (File file : filesList) {
			if (file.isDirectory()) {
				System.out.println("DIR\t" + file.getName());
			}
			if (file.isFile()) {
				System.out.println("FILE\t" + file.getName());

			}
		}
	}

}

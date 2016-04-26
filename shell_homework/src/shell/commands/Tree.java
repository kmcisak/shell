package shell.commands;

import java.io.File;

import shell.commands.interfaces.Command;

public class Tree implements Command {

	@Override
	public void execute() {
		File file = new File(".");
		printDirectoryStructure(file, 1);

	}

	private void printDirectoryStructure(File dir, int depth) {

		File files[] = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					for (int i = 0; i < depth; i++) System.out.print("-");
					System.out.println(file.getName());
					printDirectoryStructure(file, ++depth);
				}
				--depth;
			}
		}
	}
}

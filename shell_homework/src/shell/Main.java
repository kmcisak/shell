package shell;

import java.util.Scanner;

import shell.commands.utils.CommandLine;
import shell.commands.utils.CommandsProvider;

public class Main {

	public static void main(String[] args) {

		CommandsProvider commandsProvider = CommandsProvider.init();
		CommandLine commandLine = new CommandLine();
		String[] nextLine;
		Scanner in = new Scanner(System.in);

		while (true) {
			commandsProvider.getPrompt().execute();
			nextLine = in.nextLine().split(" ");
			commandLine.prepareCommandLine(nextLine);
			commandsProvider.executeCommand(commandLine);
		}
	}
}
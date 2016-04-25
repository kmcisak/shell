package shell;

import java.util.Scanner;

import shell.commands.CommandLine;
import shell.commands.CommandsProvider;

public class Main {

	public static void main(String[] args) {

		CommandsProvider commandsProvider = CommandsProvider.init();
		CommandLine commandLine = new CommandLine();
		CommandLine prompt = new CommandLine("prompt");

		String[] nextLine;

		Scanner in = new Scanner(System.in);

		commandsProvider.executeCommand(prompt);

		while (true) {

			nextLine = in.nextLine().split(" ");

			commandLine.prepareCommandLine(nextLine);

			commandsProvider.executeCommand(commandLine);
			commandsProvider.executeCommand(prompt);

		}

	}

}
package shell;

import java.util.Scanner;

import shell.commands.CommandsProvider;

public class Main {

	public static void main(String[] args) {

		CommandsProvider commandsProvider = CommandsProvider.init();

		Scanner in = new Scanner(System.in);
		commandsProvider.executeCommand("prompt");

		while (true) {

			commandsProvider.executeCommand(in.nextLine());

		}

	}

}
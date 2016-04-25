package shell;

import java.util.Scanner;

import shell.commands.CommandsProvider;

public class Main {

	public static void main(String[] args) {

		CommandsProvider commandsProvider = CommandsProvider.init();

		Scanner in = new Scanner(System.in);

		while (true) {
			tmpPrompt();
			commandsProvider.executeCommand(in.nextLine());

		}

	}

	public static void tmpPrompt() {
		System.out.print("[MyShell] $>");
	}

}

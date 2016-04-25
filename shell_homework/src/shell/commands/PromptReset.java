package shell.commands;

public class PromptReset implements Command {

	Prompt prompt;

	public PromptReset(Prompt prompt) {
		this.prompt = prompt;
	}

	@Override
	public void execute() {
		prompt.reset();
		prompt.execute();
	}
	
	

}

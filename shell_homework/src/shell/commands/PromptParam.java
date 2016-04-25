package shell.commands;

public class PromptParam implements Command {
	
	String parameter;
	Prompt prompt;
	
	public PromptParam(Prompt prompt, String parameter) {
		this.prompt = prompt;
		this.parameter = parameter;

	}

	@Override
	public void execute() {
		prompt.setParameter(parameter);
		prompt.execute();
		
	}

}

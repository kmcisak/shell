package shell.commands;

import java.io.File;
import java.io.IOException;

public class Cwd {

	String cwd;
	File file;

	public Cwd() {
		file = new File(".");
	}

	public void updateCwd() {
		try {
			this.cwd = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return cwd;
	}

}

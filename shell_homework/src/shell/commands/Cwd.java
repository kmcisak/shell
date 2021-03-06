package shell.commands;

import java.io.File;
import java.io.IOException;

public class Cwd {

	String cwd;
	File file;

	public Cwd(File file) {
		this.file = file;
		updateCwdName();
	}

	public void updateCwdName() {
		try {
			this.cwd = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return cwd;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

}

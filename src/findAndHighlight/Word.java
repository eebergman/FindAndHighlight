package findAndHighlight;

public class Word {
	String red = null;

	public Word(String red) {
		this.red = red;
	}

	public String getRed() {
		return red;
	}
	
	@Override
	public String toString() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	

}

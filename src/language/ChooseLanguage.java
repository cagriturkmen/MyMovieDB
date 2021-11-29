package language;

public class ChooseLanguage {
	
	private static ChooseLanguage instance;
	private GlobalString language;
	
	private ChooseLanguage() {
		
		this.language = new GlobalString("tr");
	}
	
	public static ChooseLanguage getInstance() {
		if (instance == null) {
			instance = new ChooseLanguage();
		}
		return instance;
	}
	
	public void chanceLanguage() {
		if (language.getlanguage().equals("tr")) {
			this.language = new GlobalString("en");
		} else {
			this.language = new GlobalString("tr");
		}
	}
	
	public GlobalString getLanguage() {
		return language;
	}
	
}

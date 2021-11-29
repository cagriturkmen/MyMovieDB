package language;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

// src\com\bilgeadam\recepergan\language\String_tr.properties
public class GlobalString {// src\language\String_en.properties
	private static final String BUNDLE_NAME = "language.String";
	private String language;
	private ResourceBundle resourceBundle;
	
	public GlobalString(String language, String country) {
		Locale locale = new Locale(language.toLowerCase(), country.toUpperCase());
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		this.language = language;
	}
	
	public GlobalString(String language) {
		Locale locale = new Locale(language.toLowerCase());
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		this.language = language;
	}
	
	public GlobalString() {
		this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		this.language = "tr";
	}
	
	public String getString(String key) {
		try {
			return this.resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public String getlanguage() {
		return language;
	}
	
}
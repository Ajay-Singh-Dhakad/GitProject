package Utility;

public class createURL {
	// create a repository in my github;
public final static String baseURI="https://api.github.com";

public static String getbaseuri() {
	return baseURI;
}
// my baseuri can contain resource also
public static String getbaseuri(String resource) {
	return baseURI+resource;
}
}

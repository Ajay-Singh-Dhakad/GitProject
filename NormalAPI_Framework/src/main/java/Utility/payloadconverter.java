package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadconverter {
	public static String generatepayload(String filename) throws IOException {
		String filepath="/Users/dzine/eclipse-workspace/NormalAPI_Framework/src/main/java/Resources/"+filename;
		//String filepath=System.getProperty("user.dir")+"/src/main/java/Resources/"+filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
}

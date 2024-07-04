package tp1.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitialConfiguration {

	public static final InitialConfiguration NONE = new InitialConfiguration();

	private List<String> descriptions;

	private InitialConfiguration() {
	}

	private InitialConfiguration(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public List<String> getShipDescription() {
		return Collections.unmodifiableList(descriptions);
	}

	public static InitialConfiguration readFromFile(String filename) throws FileNotFoundException, IOException {
		String fullPath = Paths.get(System.getProperty("user.dir"), filename + ".txt").toString();

		BufferedReader reader = new BufferedReader(new FileReader(fullPath));
		String line;
		List<String> descriptions = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			descriptions.add(line);
		}
		reader.close();

		return new InitialConfiguration(descriptions);
	}
}

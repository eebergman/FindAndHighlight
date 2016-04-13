package findAndHighlight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UtilsFAH extends FindAndHighlight {

	public static String getPath1() {
		Path p1 = Paths.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\300words.txt");
		String pathLoc1 = p1.toString();
		return pathLoc1;
	}

	public static String getPath2() {
		Path p2 = Paths.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\ourLinks.txt");
		String pathLoc2 = p2.toString();
		return pathLoc2;
	}

	public static String getPath3(int x) {
		Path p3 = Paths
				.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\htmlFile" + x + ".html");
		String pathLoc3 = p3.toString();
		return pathLoc3;
	}

	public static ArrayList<String> makeArrayListOfWords() throws FileNotFoundException {

		Scanner sc = new Scanner(new File(getPath1()));

		ArrayList<String> theWords = new ArrayList<String>();
		while (sc.hasNextLine()) {
			theWords.add(sc.nextLine());
		}
		sc.close();
		return theWords;
	}

	public static ArrayList<String> makeArrayListOfUrls() throws FileNotFoundException {

		Scanner sc = new Scanner(new File(getPath2()));

		ArrayList<String> theUrls = new ArrayList<String>();
		while (sc.hasNextLine()) {
			theUrls.add(sc.nextLine());
		}
		sc.close();
		return theUrls;
	}

	public static String fetch(String urlEx) {

		try {
			Document doc = Jsoup.connect(urlEx).get();
			String wasADocument = doc.toString();
			return wasADocument;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}

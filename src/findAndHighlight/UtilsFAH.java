package findAndHighlight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
				.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\htmlFile" + x + ".txt");
		String pathLoc3 = p3.toString();
		return pathLoc3;
	}

	public static Reader getPath4(int x) {
		Path p4 = Paths
				.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\htmlFile" + x + ".txt");
		Reader pathLoc4 = (Reader) p4;
		return pathLoc4;
	}

	public static String getPath5(int x) {
		Path p5 = Paths
				.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\htmlFile" + x + ".html");
		String pathLoc5 = p5.toString();
		return pathLoc5;
	}

	public static String getPath6() {
		Path p6 = Paths
				.get("\\Users\\Erin\\workspace_grandcircus\\FindAndHighlight\\src\\Files\\listOfWhatAndWhere.txt");
		String pathLoc6 = p6.toString();
		return pathLoc6;
	}

	public static ArrayList<String> makeArrayListOfWords() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(getPath1()));

		ArrayList<String> theWords = new ArrayList<String>();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				theWords.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			Document doc = Jsoup.connect(urlEx).followRedirects(false).get();
			String wasADocument = doc.toString();
			return wasADocument;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
}

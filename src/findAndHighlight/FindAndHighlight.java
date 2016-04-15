package findAndHighlight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FindAndHighlight {

	public static void main(String[] args) throws IOException {

		ArrayList<String> words300 = UtilsFAH.makeArrayListOfWords();
		ArrayList<String> urls = UtilsFAH.makeArrayListOfUrls();
		HashMap<String, Text> heresSomeHash = new HashMap<String, Text>(300);
		String text2 = null;

		for (int i = 0; i < urls.size(); i++) {
			String hereIsAUrl = urls.get(i);

			BufferedWriter writingThingsNStuff = new BufferedWriter(new FileWriter(UtilsFAH.getPath3(i)));
			writingThingsNStuff.write(UtilsFAH.fetch(hereIsAUrl));
			writingThingsNStuff.close();
		}

		for (int j = 0; j < urls.size(); j++) {
			File fileName = new File(UtilsFAH.getPath3(j));
			Document doc = Jsoup.parse(fileName, null);
			String makingABigString = doc.toString();
			FileReader aFileReaderHere = new FileReader(fileName);

			String getOneWord = null;

			BufferedReader br = new BufferedReader(aFileReaderHere);

			FileWriter theFinalFile = new FileWriter(UtilsFAH.getPath5(j));
			BufferedWriter nbr = new BufferedWriter(new FileWriter(UtilsFAH.getPath6(), true));

			while ((makingABigString = br.readLine()) != null) {

				for (int k = 0; k < words300.size(); k++) {

					boolean doThisOnce = false;

					getOneWord = words300.get(k);
					String makingAMark = ("<mark>" + getOneWord + "</mark>");
					CharSequence a = (" " + getOneWord + " ");
					CharSequence b = (" " + getOneWord + ".");
					CharSequence c = (" " + getOneWord + ",");

					if (makingABigString.contains(getOneWord)) {
						if (makingABigString.contains(a)) {
							makingABigString = makingABigString.replaceAll(getOneWord, makingAMark);
						} else if (makingABigString.contains(b)) {
							makingABigString = makingABigString.replaceAll(getOneWord, makingAMark);
						} else if (makingABigString.contains(c)) {
							makingABigString = makingABigString.replaceAll(getOneWord, makingAMark);
						}
					}

					if (makingABigString.contains(getOneWord)) {

						while (doThisOnce == false) {
							doThisOnce = true;
							File fileName2 = new File(UtilsFAH.getPath3(j));
							@SuppressWarnings("unused")
							Document doc2;
							
							try {
								doc2 = Jsoup.parse(fileName2, null);
								text2 = doc.title();

							} catch (IOException e) {
								e.printStackTrace();
							}

							Text b2 = new Text(text2);
							// String d2 = b2.getBlue();
							heresSomeHash.put(getOneWord, b2);
						}

					}

					if (heresSomeHash.get(getOneWord) != null){
					System.out.println("We found the word " + getOneWord + " on the wikipedia page "
							+ heresSomeHash.get(getOneWord));
					} else {
						System.out.println("Sorry " + getOneWord + " was not found in " + text2);
					}
					
//					nbr.append("We found the word " + getOneWord + " on the wikipedia page "
//							+ heresSomeHash.get(getOneWord));
					nbr.newLine();

				}

				theFinalFile.append(makingABigString);

			}
			br.close();
			theFinalFile.close();
			nbr.close();
		}
	}
}
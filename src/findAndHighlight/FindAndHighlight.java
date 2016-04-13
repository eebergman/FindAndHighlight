package findAndHighlight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FindAndHighlight {

	public static void main(String[] args) throws IOException {

		ArrayList<String> words300 = UtilsFAH.makeArrayListOfWords();
		ArrayList<String> urls = UtilsFAH.makeArrayListOfUrls();

		// System.out.println(words300);
		// System.out.println(urls);

		for (int i = 0; i < urls.size(); i++) {
			String hereIsAUrl = urls.get(i);

			BufferedWriter writingThingsNStuff = new BufferedWriter(new FileWriter(UtilsFAH.getPath3(i)));
			writingThingsNStuff.write(UtilsFAH.fetch(hereIsAUrl));
		}

		//another for loop iterating over words300 arraylist
			//each time pull one word into a charseq
			//
		// search through url files for words matching arraylist words300
		//mark each one of those files a highlighted color

	}

}

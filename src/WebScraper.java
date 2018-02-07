import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {

        String onlineText = urlToString("http://erdani.com/tdpl/hamlet.txt");

        String[] words = onlineText.split(" ");
        int numberOfWords = words.length;

        System.out.println("Number of words: " + numberOfWords);

        int numberOfOneWord = 0;
        String upperCase = onlineText.toUpperCase();
        String[] upperCaseWords = upperCase.split(" ");

        for (int i = 0; i < upperCaseWords.length; i++) {
            if (upperCaseWords[i].compareTo("PRINCE") == 0) {
                numberOfOneWord++;
            }
        }

        System.out.println("Number of the word PRINCE: " + numberOfOneWord);
    }
}

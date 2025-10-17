package Translation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TranslatorApp {

	    private static Map<String, Word> dictionary = new HashMap<>();

	    public static void main(String[] args) {
	        loadDictionary("HSK_Words.csv");
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.print("Enter an English sentence (or 'stop translating' to quit): ");
	            String sentence = scanner.nextLine();
	            if (sentence.equalsIgnoreCase("stop translating")) {
	                break;
	            }
	            String translation = translateSentence(sentence);
	            System.out.println(translation);
	        }
	        scanner.close();
	    }

	    private static void loadDictionary(String filename) {
	        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 4) {
	                    String wordType = parts[0].trim();
	                    String chinese = parts[1].trim();
	                    String pinyin = parts[2].trim();
	                    String eng = parts[3].trim();
	                    if (eng.startsWith("to") && !(eng.equals("to"))){
	                    	eng = eng.substring(3);
	                    }
	                    String english = eng;
	                    dictionary.put(english.toLowerCase(), new Word(wordType, chinese, pinyin, english));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static String translateSentence(String sentence) {
	        StringBuilder translatedSentence = new StringBuilder();
	        String[] words = sentence.split(" ");
	        for (String word : words) {
	            String baseWord = getBaseWord(word);
	            Word entry = dictionary.get(baseWord.toLowerCase());
	            if (entry != null) {
	                translatedSentence.append(entry.chinese);
	            } else if((word.equals("am"))||word.equals("is")||word.equals("are")){
	            	translatedSentence.append("");
	            } else if(word.equals("She")||word.equals("she")) {
	            	translatedSentence.append("她");
	            } else if(word.equals("Her")||word.equals("her")) {
	            	translatedSentence.append("她的");
	            } else if(word.equals("He")||word.equals("him")) {
	            	translatedSentence.append("他");
	            } else if(word.equals("His")||word.equals("his")) {
	            	translatedSentence.append("他的");
	            } else {
	                translatedSentence.append(word);
	            }
	        }
	        return translatedSentence.toString().trim();
	    }
	    private static String getBaseWord(String word) {
	        if (word.endsWith("s")) {
	            return word.substring(0, word.length() - 1);
	        }
	        if (word.endsWith("ed")) {
	            return word.substring(0, word.length() - 2);
	        }
	        if (word.endsWith("ing")) {
	            return word.substring(0, word.length() - 3);
	        }
	        return word;
	    }

	    private static class Word {
	        String wordType;
	        String chinese;
	        String pinyin;
	        String english;

	        Word(String wordType, String chinese, String pinyin, String english) {
	            this.wordType = wordType;
	            this.chinese = chinese;
	            this.pinyin = pinyin;
	            this.english = english;
	        }
	    }
	
}

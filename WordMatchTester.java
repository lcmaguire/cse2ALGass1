import java.io.*;
import java.util.*;

/*
	Liam Maguire 18344533 CSE2ALG
*/

public class WordMatchTester{

	public static void main(String [] args) throws Exception{
		//input files
		String file1 = "sample1-pp.txt";
		String file2 = "sample2-zoo.txt";
		//outfile
		String outFile = "sample4-results.txt";
		
		ArrayList<Item> words = new ArrayList<>();
		//loads words from the two files
		Helper.loadData(file1, words);
		Helper.loadData(file2, words);

		//used to print to file
		PrintWriter printWriter = new PrintWriter(new File(outFile));

		//sorts the list of words
		Helper.quickSort(words, 0, words.size()-1);
		
		//chech all patterns that start with ma and length == 3
		String pattern = "ma?";
		//array list for all matching patterns
		ArrayList<Item> match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test all where length >=4 and 2nd - 4th char == ear
		pattern = "?ear*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test word with no special characters
		pattern = "can";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test all words that start with mr 
		pattern = "mr*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test all words that start with i
		pattern = "i*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		// test all words that length ==3 and middle char == o
		pattern = "?o?";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		// test all words that contain y
		pattern = "*y*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test all that contain m and length >= 3
		pattern = "*m??*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test all that contain o as second last letter
		pattern = "*o?";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);
		
		//test all words that start with k and contain w
		pattern = "k*w*";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//test to return 0 matches
		pattern = "this*will?return0";
		match = Helper.filter(pattern, words);
		writeData(printWriter, match, pattern);

		//closes printwriter
		printWriter.close();
	}

	

	//display to screen and write to file
	public static void writeData(PrintWriter printWriter, ArrayList<Item> words, String pattern) throws IOException{

		System.out.println(pattern);
		printWriter.println(pattern);
		//display all pattern matches and write to file
		for(int i = 0; i < words.size(); i++){
			printWriter.println(words.get(i).info());
			System.out.println(words.get(i).info());
		}
		//no matches display and write to file no pattern match
		if(words.size() == 0){
			System.out.println("No words in the lexicon match the pattern");
			printWriter.println("No words in the lexicon match the pattern");
		}

		System.out.println();
		printWriter.println();

	}
}
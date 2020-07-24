import java.io.*;
import java.util.*;

/*
	Liam Maguire 18344533 CSE2ALG
*/

public class LexiconTester{

	public static void main(String [] args) throws Exception{
		//input files
		//String file1 = "sample1-pp.txt";
		String file1 = "t4-bb.txt";
		//String file2 = "sample2-zoo.txt";
		String file2 = "t5-wp.txt";
		//outfile
		String outfile = "sample3-wordlist.txt";
		
		//array list of all words
		ArrayList<Item> words = new ArrayList<>();
		//loads data from text files
		Helper.loadData(file1, words);
		Helper.loadData(file2, words);
		
		Helper.quickSort(words, 0, words.size()-1);
		
		writeData(outfile, words);
	}
	
	
	//writes to textfile and displays to screen
	public static void writeData(String fileName, List<Item> people) throws IOException{
		
    	PrintWriter outFile = new PrintWriter(new File(fileName));
		
		
		
		
		//displays all to screen and prints to file
    	for (Item p: people){
			Helper.insertionSort(p.getNeighbours());
        	outFile.println(p);
			System.out.println(p);
		}
		//closes printwriter
		outFile.close();
   }
	
}

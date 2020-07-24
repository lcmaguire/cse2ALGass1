import java.util.*;
import java.io.*;
import java.util.regex.*;  

/*
	Liam Maguire 18344533 CSE2ALG
*/

public class Helper{

	//reads data in from text file, filters words and adds to arraylist if unique
	public static void loadData(String file, ArrayList<Item> words) throws IOException {
		
		Scanner infile = new Scanner(new File(file));
		while(infile.hasNext()){
		  String line = infile.nextLine();
		  line = line.trim();
		  //splits line into strings seperated by spaces
		  String [] temp = line.split(" ");
		  
		  for(int i = 0; i < temp.length; i++){
			  //convert to lowercase
			  temp[i] = temp[i].toLowerCase();
			  //removes all non alphabetic characters
			  temp[i] = temp[i].replaceAll("[^a-z]","");
			  //removes any whitespace
			  temp[i] = temp[i].trim();

			  //if not empty will check if exists
			  if(!temp[i].equals("")){
				  
				Item t = new Item(temp[i]);
				existCheck(words, t);
			  }
		  }
		  
		}

		infile.close();
	}

	//checks if variable already exists in a list and adds it if it isn't
	public static <E extends Comparable<E>> void existCheck(List <E> list, E temp){
		boolean unique = true;
		for(int i = 0; i < list.size(); i++){
			
			if(list.get(i).compareTo(temp) == 0){
				unique = false;
				break;
			}
		}
		//word is unique add to list
		if(unique){
			list.add(temp);
		}
	}

	//swaps variables locations in a list
	private static<E extends Comparable<E>>void swap(List<E> list, int i, int j)
	{
		E temp = list.get(i);
		list.set(i, list.get(j));
	 	list.set(j, temp);
	}

	//quick sort method as used in the labs
	public static <E extends Comparable<E>> void quickSort(List <E> list, int left, int right){
		if(left < right){
			int pivotIndex = partition(list, left, right);
			quickSort(list,left, pivotIndex-1);
			quickSort(list,pivotIndex+1, right);
		}
	}
	
	public static <E extends Comparable<E>> int partition(List <E> list, int left, int right){
		
		int mid = (left+right)/2;
		E pivot = list.get(mid);
		swap(list, mid, right);
		
		while(left < right){
			
			while(left < right && list.get(left).compareTo(pivot) <= 0){
				left++;
			}
			
			if(left < right){
				swap(list, left, right);
				right--;
			}
			
			while( right > left && list.get(right).compareTo(pivot) >= 0){
				right--;
			}
			
			if(right > left){
				swap(list, left, right);
				left++;
			}
		}
		
		return left;		
		
	}
	
	
	//converts pattern to lowercase and to regex pattern before checking if matches
	public static boolean patternCheck(String pattern, String word){
		
		pattern = pattern.toLowerCase();
		pattern = pattern.trim();
		//replaces wildcard characters with regex equivalent 
		pattern = pattern.replace("*","\\w*");
		pattern = pattern.replace("?","\\w");
		
		return Pattern.matches(pattern,word);
		
	}
	

	//checks array list for words that match the pattern
	public static ArrayList<Item> filter(String pattern, ArrayList<Item> words){	
		
		ArrayList<Item> out = new ArrayList<>();
		
		for(int i = 0; i < words.size(); i++){
			//if the word matches the pattern add to list
			if(patternCheck(pattern, words.get(i).getWord())){
				out.add(words.get(i));
			}
		}
		
		return out;
	}

	//insertion sort as used in labs used for sorting neighbour ArrayLists
	public static <E extends Comparable<E>> void insertionSort(List<E> list){
		for(int i =1; i < list.size();i++){
			insertElement(list,i);
		}
	}
	
	private static <E extends Comparable<E>> void insertElement(List<E> list, int next){
		E v = list.get(next);
		int i = next;
		while(true) {
			if(i == 0) {
				list.set(0,v);
				break;
			}
			else if(list.get(i-1).compareTo(v) <= 0) {
				list.set(i,v);
				break;
			}
			else { 
				E val = list.get(i-1);
				list.set(i,val);
				i--;
			}
		}
	}
	
	//bubble sort as used in labs unused in this class
	public static<E extends Comparable<E>> void bubbleSort(List<E> list){
		
			int left = 0;
			int right = list.size()-1;
			
			for(int i = right; i >= left + 1; i--){
				for(int j = left; j <= i-1; j++){
					
					if(list.get(j).compareTo(list.get(j+1)) >0){
						swap(list, j, j+1);
					}
				}
			}
	}
	
}
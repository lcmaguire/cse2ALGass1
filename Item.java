import java.util.*;

/*
	Liam Maguire 18344533 CSE2ALG
*/

public class Item implements Comparable<Item>
{
	private String word;
	private int count;
	private ArrayList<String> neighbours;
	
	public Item(String word){
		this.word = word;
		count = 1;
		neighbours = new ArrayList<>();
	}
	
	public String getWord(){
		return word;
	}
	
	public int getCount(){
		return count;
	}
	
	public ArrayList<String> getNeighbours(){
		return neighbours;
	}
	
	//used for WordMatchTester to display word + count but not neighbours
	public String info(){
		return word + " " + count;
	}
	
	public String toString(){
		return word + " " + count + " " + neighbours.toString();
	}
	
	public void addNeighbour(String n){
		neighbours.add(n);
	}
	
	//use for sorting as well as determining if neighbours
	public int compareTo(Item item){
		int wordDiff = this.word.compareToIgnoreCase(item.word);
		
		//checks if equal and increments count else checks if neighbour 
		if (wordDiff != 0)
		{
			//check if item lengths are equal
			
			if(item.word.length() == this.word.length()){
				int equalChars = 0;
				int len = item.word.length();
				
				//check each char to see if equal
				
				for(int j = 0; j < len; j++){
				
					if(item.word.charAt(j) == this.word.charAt(j)){
						equalChars++;
					}
				}
				
				//if off by one add to neighbours of both objects
				if(equalChars == (len-1)){
					//checks if already exists in neighbours list then adds if not
					Helper.existCheck(this.neighbours, item.word);
					Helper.existCheck(item.neighbours, this.word);
					//sorts the neighbours
					//Helper.insertionSort(this.neighbours);
					//Helper.insertionSort(item.neighbours);					
				}
				
			}
		  
			return wordDiff;
		}
		else
		{
			//wordDiff == 0, words are equal increase count
			count++;
			return wordDiff;
        }
	}
	
	
}
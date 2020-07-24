import java.util.regex.*;  

public class RegexTest{
	
	public static void main(String [] args){
		String pattern = "*o?";
		
		pattern = "\\w*o\\w";
		String word = "position";
		String x = "fail";
		
		System.out.println(Pattern.matches(pattern, word));
		System.out.println(Pattern.matches(pattern, x));
		
	}

}
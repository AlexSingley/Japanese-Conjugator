/**
 * Alex Singley
 * Rough version of a Japanese verb conjugation application.
 * Once finished with the verb portion, I plan on adding more conjugation options since what I have listed
 * now is nowhere near all of the possible conjugations. I also plan on adding in adjective conjugations.
 */


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Conjugator {
	
	private static boolean uVerb = false;
	private static boolean ruVerb = false;
	private static boolean irregVerb = false;

	public static void main(String[] args) {
		String word;
		
		ArrayList<Character> verbType = new ArrayList<Character>(26);
		verbType.add('い');
        verbType.add('き');
        verbType.add('ぎ');
        verbType.add('し');
        verbType.add('じ');
        verbType.add('ち');
        verbType.add('ぢ');
        verbType.add('に');
        verbType.add('ひ');
        verbType.add('ぴ');
        verbType.add('び');
        verbType.add('み');
        verbType.add('り');
        verbType.add('え');
        verbType.add('け');
        verbType.add('げ');
        verbType.add('せ');
        verbType.add('ぜ');
        verbType.add('て');
        verbType.add('で');
        verbType.add('ね');
        verbType.add('へ');
        verbType.add('ぺ');
        verbType.add('べ');
        verbType.add('め');
        verbType.add('れ');
		
		
		Scanner wordInput = new Scanner(System.in);
        
        while(true)	{
        	System.out.println("Please enter the verb/adjective that you wish to view the conjugations of in present plain form.");
        	word = wordInput.next();
        	if(word.equals("くる") || word.equals("する") || word.equals("来る"))	{
        		irregVerb = true;
        	}
        	else if(word.endsWith("る") == false)	{
        		uVerb = true;
        	}
        	else	{
                for(int i=0; i<=verbType.size()-1; i++)	{
                	if(word.charAt(word.length()-2) == verbType.get(i))	{
                		ruVerb = true;
                		uVerb = false;
                		break;
                	}
                	else	{
                		uVerb = true;
                	}
                }
        	}
        	if(irregVerb == false && uVerb == false && ruVerb == false)	{
        		System.out.println("Invalid input. Please try again.");
        	}
        	else	{
        		break;
        	}
        } 
        conjWanted(word);
	}
	
	private static ArrayList<String> conjugate(String a) {
		ArrayList<String> conjTable = new ArrayList<String>();
		
		if(a.equals("する"))	{
			conjTable.add(a);
			conjTable.add("します");
			conjTable.add("した");
			conjTable.add("しました");
			conjTable.add("して");
			conjTable.add("できる");
			conjTable.add("できます");
			conjTable.add("される");
			conjTable.add("されます");
			conjTable.add("させる");
			conjTable.add("させます");
			conjTable.add("させられる");
			conjTable.add("させられます");
			conjTable.add("しろ");
			conjTable.add(a + "な");
		}
		
		if(a.equals("くる") || a.equals("来る"))	{
			conjTable.add(a);
			conjTable.add("きます");
			conjTable.add("きた");
			conjTable.add("きました");
			conjTable.add("きて");
			conjTable.add("こられる");
			conjTable.add("こられます");
			conjTable.add("こられる");
			conjTable.add("こられます");
			conjTable.add("こさせる");
			conjTable.add("こさせます");
			conjTable.add("こさせられる");
			conjTable.add("こさせられます");
			conjTable.add("こい");
			conjTable.add(a + "な");
		}
		
		if(ruVerb == true)	{
			conjTable.add(a);
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "ます");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "た");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "ました");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "て");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "られる");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "られます");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "られる");
			conjTable.add(a);
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "させる");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "させます");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "させられる");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "させられます");
			conjTable.add(a.substring(0, a.lastIndexOf("る")) + "ろ");
			conjTable.add(a + "な");
		}
		
		// 2 and 4
		String groupOne = "いきしちにびみりぎ";
		// 6, 7, 14
		String groupTwo = "えけせてねべめれげ";
		// 8, 9, 10, 11, 12, 13
		String groupThree = "わかさたなばまらが";
		// 3
		String groupFour = "ったいたしたったんだんだんだったいだ";
		// 5
		String groupFive = "っていてしてってんでんでんでっていで";
		
		List<String> setOne = new ArrayList<String>();
		for(int i = 0; i < groupOne.length(); i++) {
			setOne.add(groupOne.substring(i, i + 1));
		}
		
		List<String> setTwo = new ArrayList<String>();
		for(int i = 0; i < groupTwo.length(); i++) {
			setTwo.add(groupTwo.substring(i, i + 1));
		}
		
		List<String> setThree = new ArrayList<String>();
		for(int i = 0; i < groupThree.length(); i++) {
			setThree.add(groupThree.substring(i, i + 1));
		}
		
		List<String> setFour = new ArrayList<String>();
		for(int i = 0; i < groupFour.length() - 2; i+=2) {
			setFour.add(groupFour.substring(i, i + 2));
		}
		
		List<String> setFive = new ArrayList<String>();
		for(int i = 0; i < groupFive.length() - 2; i+=2) {
			setFive.add(groupFive.substring(i, i + 2));
		}
		
		Hashtable<String, Integer> determineTable = new Hashtable<String, Integer>();
		determineTable.put("う", 0);
		determineTable.put("く", 1);
		determineTable.put("す", 2);
		determineTable.put("つ", 3);
		determineTable.put("ぬ", 4);
		determineTable.put("ぶ", 5);
		determineTable.put("む", 6);
		determineTable.put("る", 7);
		determineTable.put("ぐ", 8);
		
		Integer determiner = determineTable.get(a.substring(a.length()-1));
		
		
		if(uVerb == true)	{
				conjTable.add(a);
				conjTable.add(a.substring(0, a.length() - 1) + setOne.get(determiner) + "ます");
				if(a.equals("いく"))	{
					conjTable.add("いって");
				}
				else if(a.equals("行く"))	{
					conjTable.add("行って");
				}
				else	{
					conjTable.add(a.substring(0, a.length() - 1) + setFour.get(determiner));
				}
				conjTable.add(a.substring(0, a.length() - 1) + setOne.get(determiner) + "ました");
				conjTable.add(a.substring(0, a.length() - 1) + setFive.get(determiner));
				conjTable.add(a.substring(0, a.length() - 1) + setTwo.get(determiner) + "る");
				conjTable.add(a.substring(0, a.length() - 1) + setTwo.get(determiner) + "ます");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "れる");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "れます");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "せる");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "せます");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "せられる");
				conjTable.add(a.substring(0, a.length() - 1) + setThree.get(determiner) + "せられます");
				conjTable.add(a.substring(0, a.length() - 1) + setTwo.get(determiner));
				conjTable.add(a + "な");
		}
		return conjTable;
	}
	
	private static void conjWanted(String a)	{
		boolean loopDone = false;
		Scanner conjInput = new Scanner(System.in);
		
		ArrayList<String> conjTable = new ArrayList<String>();
		
		conjTable = conjugate(a);
		
		System.out.println("Please enter the number of the conjugation form that you want to see.");
		System.out.println(" 1. Non-Past Plain               2. Non-Past Polite      3. Past Plain");
		System.out.println(" 4. Past Polite                  5. Te-Form              6. Potential Plain");
		System.out.println(" 7. Potential Polite             8. Passive Plain        9. Passive Polite");
		System.out.println("10. Causative Plain             11. Causative Polite    12. Causative Passive Plain");
		System.out.println("13. Causative Passive Polite    14. Imperative		15. Negative Imperative");
    
		int conjChoice = Integer.parseInt(conjInput.next());
		while(loopDone == false) {
			switch	(conjChoice)	{
				case 1:	System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 2: 
					System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 3: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 4: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 5: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 6: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 7: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 8: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 9: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 10: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 11: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 12: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 13: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 14: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				case 15: System.out.println(conjTable.get(conjChoice - 1));
					loopDone = true;
					break;
				default: System.out.println("Invalid input. Please enter a number from the given list.");
					System.out.println("Please enter the number of the conjugation form that you want to see.");
					System.out.println(" 1. Non-Past Plain               2. Non-Past Polite      3. Past Plain");
					System.out.println(" 4. Past Polite                  5. Te-Form              6. Potential Plain");
					System.out.println(" 7. Potential Polite             8. Passive Plain        9. Passive Polite");
					System.out.println("10. Causative Plain             11. Causative Polite    12. Causative Passive Plain");
					System.out.println("13. Causative Passive Polite    14. Imperative		15. Negative Imperative");
    	        
					conjChoice = Integer.parseInt(conjInput.next());
					continue;
			}
		}
	}
}
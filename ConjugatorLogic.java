package conjugator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.jfoenix.controls.JFXListView;

public class ConjugatorLogic extends ConjugationViewerController{
	
	protected static String inputCheck(String input, String badInputMsg)	{
				
        // Testing for Japanese verb input
        while(true)	{
        	if(input.isEmpty())   {
        		badInputMsg = "Input Error! No entry found.";
        	}
        	else if(isJapanese(input) == false)	{
	    		badInputMsg = "Input error! Please make sure that your input contains Japanese text only.";
	    	}
	    	else if(isVerb(input) == false)	{
	    		badInputMsg = "Input error! Japanese verbs can only end in the characters 「う、く、す、つ、ぬ、ぶ、む、る、ぐ」 so please adjust your input and try again.";
	    	}
	    	else	{
	    		badInputMsg = "";
	    	}
        	return badInputMsg;
		}
	}
	
	protected static String verbTypeCheck(String input)	{
		
		String verbType = "";
		
		// Characters that affect the verb's classification
				ArrayList<Character> verbClass = new ArrayList<Character>(26);
				verbClass.add('い');
		        verbClass.add('き');
		        verbClass.add('ぎ');
		        verbClass.add('し');
		        verbClass.add('じ');
		        verbClass.add('ち');
		        verbClass.add('ぢ');
		        verbClass.add('に');
		        verbClass.add('ひ');
		        verbClass.add('ぴ');
		        verbClass.add('び');
		        verbClass.add('み');
		        verbClass.add('り');
		        verbClass.add('え');
		        verbClass.add('け');
		        verbClass.add('げ');
		        verbClass.add('せ');
		        verbClass.add('ぜ');
		        verbClass.add('て');
		        verbClass.add('で');
		        verbClass.add('ね');
		        verbClass.add('へ');
		        verbClass.add('ぺ');
		        verbClass.add('べ');
		        verbClass.add('め');
		        verbClass.add('れ');
		        
		        
				// Determining verb type
		        while(true)	{
		        	if(input.equals("くる") || input.equals("する") || input.equals("来る"))	{
		        		verbType = "irregVerb";
		        	}
		        	else if(input.endsWith("る") == false)	{
		        		verbType = "uVerb";
		        	}
		        	else	{
		                for(int i=0; i<=verbClass.size()-1; i++)	{
		                	if(input.charAt(input.length()-2) == verbClass.get(i))	{
		                		verbType = "ruVerb";
		                		break;
		                	}
		                	else	{
		                		verbType = "uVerb";
		                	}
		                }
		        	}
		        	if(verbType != "irregVerb" && verbType != "uVerb" && verbType != "ruVerb")	{
		        		System.out.println("Invalid input. Please try again.");
		        	}
		        	else	{
		        		break;
		        	}
		        } 
		        return verbType;
	}
	
	// Setting conjugations 
	private static ArrayList<String> conjugate(String a, String conjInput, String verbType) {
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
		
		if(verbType == "ruVerb")	{
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
		for(int i = 0; i < groupFour.length(); i+=2) {
			setFour.add(groupFour.substring(i, i + 2));
		}
		
		List<String> setFive = new ArrayList<String>();
		for(int i = 0; i < groupFive.length(); i+=2) {
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
		
		
		if(verbType == "uVerb")	{
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
	
	// Outputting user's desired conjugation
	static String conjWanted(String input, JFXListView<String> conjugationList, String verbType)	{
		Boolean loopDone = false;
		String conjWord = "";
		
		String conjInput = conjugationList.getSelectionModel().getSelectedItem();
		int conjChoice = conjugationList.getSelectionModel().getSelectedIndex();
				
		ArrayList<String> conjTable = new ArrayList<String>();
		
		conjTable = conjugate(input, conjInput, verbType);
		
		while(loopDone == false) {
			switch	(conjChoice)	{
				case 0:
					conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 1: 
					conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 2: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 3: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 4: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 5: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 6: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 7: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 8: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 9: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 10: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 11: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 12: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 13: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				case 14: conjWord = conjTable.get(conjChoice);
					loopDone = true;
					break;
				default: return conjWord;
			}
		}
		return conjWord;
	}
	
	// Making sure the input is Japanese text
	public static boolean isJapanese(CharSequence word) {
        boolean isJapanese = true;
        for (char a : word.toString().toCharArray()) {
            if (Character.UnicodeBlock.of(a) != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                    && Character.UnicodeBlock.of(a) != Character.UnicodeBlock.HIRAGANA
                    && Character.UnicodeBlock.of(a) != Character.UnicodeBlock.KATAKANA
                    && Character.UnicodeBlock.of(a) != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                    && Character.UnicodeBlock.of(a) != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                    && Character.UnicodeBlock.of(a) != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
                isJapanese = false;
                if(isJapanese == false) {
                	return isJapanese;
                }
            }
        }
        return isJapanese;
	}
	
	// Making sure that the input is a verb
	public static boolean isVerb(String word) {
        char[] verbEndings = new char[] {'う', 'く', 'す', 'つ', 'ぬ', 'ぶ', 'む', 'る', 'ぐ'};
        
        for(int i = 0; i <= verbEndings.length; i++)	{
        	if(word.charAt(word.length() - 1) == (verbEndings[i]))	{
        		return true;
        	}
        	else if(verbEndings.length == i + 1)	{
        		return false;
        	}
        }
        return false;
	}
}

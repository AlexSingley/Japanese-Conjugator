package conjugator;

import java.util.ArrayList;
import com.jfoenix.controls.JFXListView;

public class AdjConjugatorLogic extends ConjugationViewerController{
	
	protected static String inputCheck(String input, String badInputMsg)	{
		
        // Testing for Japanese verb input
        while(true)	{
        	if(input.isEmpty())   {
        		badInputMsg = "Input Error! No entry found.";
        	}
        	else if(isJapanese(input) == false)	{
	    		badInputMsg = "Input error! Please make sure that your input contains Japanese text only.";
	    	}
	    	else	{
	    		badInputMsg = "";
	    	}
        	return badInputMsg;
		}
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
	public static String adjTypeCheck(String word) {        
        String adjType = "";
        char[] adjESounds = new char[] {'え','け','せ','て','ね','へ','め','れ'}; 
        
        if(String.valueOf(adjESounds).contains((word.substring((word.length() - 2), word.length() - 1 ))) && (word.substring(word.length() - 1).equals("い")))	{
        	adjType = "naAdj";
        }
        else if(word.substring(word.length() - 1).equals("い"))	{
        	adjType = "iAdj";
        }
        else if(word.equals("よい") || word.equals("良い") || word.equals("いい"))	{
        	adjType = "いい";
        }
        else	{
        	adjType = "naAdj";
        }
        return adjType;
	}	
	
	// Setting conjugations 
	private static ArrayList<String> conjugate(String a, String conjInput, String adjType) {
		ArrayList<String> conjTable = new ArrayList<String>();
		
		if(adjType.equals("naAdj"))	{
			conjTable.add(a);
			conjTable.add(a + "じゃない");
			conjTable.add(a + "です");
			conjTable.add(a + "じゃないです");
			conjTable.add(a + "だった");
			conjTable.add(a + "じゃなかった");
			conjTable.add(a + "でした");
			conjTable.add(a + "じゃなかったです");
			conjTable.add(a + "で");
			conjTable.add(a + "そう");
			conjTable.add(a + "すぎる");
			conjTable.add(a + "になる");
			conjTable.add(a + "さ");
			conjTable.add(a + "なら" + " / " + a + "であれば");
			conjTable.add(a + "じゃなければ" + " / " + a + "でなければ");
		}
		else if(adjType.equals("iAdj"))	{
			if(a.equals("小さい") || a.equals("ちいさい") || a.equals("大きい") || a.equals("おおきい"))	{
				conjTable.add(a + " / " + (a.substring(0, a.lastIndexOf("い")) + "な"));
			}
			else	{
				conjTable.add(a);
			}
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くない");
			conjTable.add((a) + "です");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くないです");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "かった");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くなかった");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "かったです");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くなかったです");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くて");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "そう");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "すぎる");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くなる");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "さ");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "ければ");
			conjTable.add(a.substring(0, a.lastIndexOf("い")) + "くなければ");
		}
		else if(adjType.equals("いい"))	{
			char firstChar = a.charAt(0);
			if(firstChar == 'い')	{
				firstChar = 'よ';
			}
			
			conjTable.add(a);
			conjTable.add((firstChar) + "くない");
			conjTable.add((a) + "です");
			conjTable.add((firstChar) + "くないです");
			conjTable.add((firstChar) + "かった");
			conjTable.add((firstChar) + "くなかった");
			conjTable.add((firstChar) + "かったです");
			conjTable.add((firstChar) + "くなかったです");
			conjTable.add((firstChar) + "くて");
			conjTable.add((firstChar) + "さそう");
			conjTable.add((firstChar) + "すぎる");
			conjTable.add((firstChar) + "くなる");
			conjTable.add((firstChar) + "さ");
			conjTable.add((firstChar) + "ければ");
			conjTable.add((firstChar) + "くなければ");
		}
			
		return conjTable;
	}
	
	// Outputting user's desired conjugation
	static String conjWanted(String input, JFXListView<String> conjugationList, String adjType)	{
		Boolean loopDone = false;
		String conjWord = "";
		
		String conjInput = conjugationList.getSelectionModel().getSelectedItem();
		int conjChoice = conjugationList.getSelectionModel().getSelectedIndex();
				
		ArrayList<String> conjTable = new ArrayList<String>();
		
		conjTable = conjugate(input, conjInput, adjType);
		
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
	
}


/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am aweakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
	String newStr1 = preProcess(str1);
	String newStr2 = preProcess(str2);

	if (newStr1.length() != newStr2.length()) {
        return false;
    }
else{
	for (int i =0; i<newStr1.length();i++){
		char currentChar = newStr1.charAt(i);
        int indexNewStr2 = newStr2.indexOf(currentChar);

        if (indexNewStr2 == -1) {
            return false;
        }
        newStr2 = newStr2.substring(0, indexNewStr2) + newStr2.substring(indexNewStr2 + 1);
    }

    return true;
}
	}	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		for (int i =0; i<str.length();i++){
			if (str.charAt(i)>= 97 && str.charAt(i)<=122){
				newStr +=str.charAt(i);
			}
			else if (str.charAt(i)>=65 && str.charAt(i) <=90){
				newStr += (char) (str.charAt(i)+32);
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr= "";
		for (int i =0; i<str.length();i++){
			char chosenChar = str.charAt((int) (Math.random() * str.length()));
			newStr += chosenChar;
			str = str.substring(0,i)+ str.substring(i+1);
		}
		return newStr;
	}
}
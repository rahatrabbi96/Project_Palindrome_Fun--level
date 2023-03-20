import java.util.Scanner;

public class Palindrome {


    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.testPalindrome();
    }
    public void testPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String str="";
        while (!str.equals("q")) {
            System.out.println("Please enter a string to be reversed or (q) to quit: ");
            str = scanner.nextLine();
            // Don't bother to test for palindrome if user requests quit
            if (str.equals("q"))
                break;
            String reversed = reverseString(str);
            if (isPalindrome(str)) {
                System.out.println("'" + str + "'" + " is a palindrome.");
            }
            else if (isPalindromeWords(str)) {
                System.out.println("'" + str + "'" + " is a palindrome sentence.");
            }
            else {
                System.out.println("'" + str + "'" + " is not a palindrome.");
            }
        }
        System.out.println("Goodbye...");
    }
    public String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public boolean isPalindrome(String testString) {
        testString = testString.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (reverseString(testString).equals(testString))
            return true;
        else
            return false;
    }

    //  recursively reverse words in a phrase or sentence
    public String reverseWords(String str) {
        int idx = str.indexOf(" ");
        //Base condition - when str has only one word
        if(idx == -1)
            return str;
        //return after concatenating in reverse order
        // idx + 1 is after the space
        return reverseWords(str.substring(idx+1)) +" "+ str.substring(0, idx);
    }

    public boolean isPalindromeWords(String testString) {
        // remove punctuation but not spaces
        testString = testString.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        //  A word palindrome must contain at least one space and be equal in both directions
        if (testString.contains(" ") && reverseWords(testString).equals(testString))
            return true;
        else
            return false;
    }
}

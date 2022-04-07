import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("ad"));
        assertFalse(palindrome.isPalindrome("adagf"));
        assertFalse(palindrome.isPalindrome("ddad"));


        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("Flake", cc));
        assertTrue(palindrome.isPalindrome("fbCe", cc));
        assertTrue(palindrome.isPalindrome("&%", cc));
        assertFalse(palindrome.isPalindrome("ddsfad", cc));
        assertFalse(palindrome.isPalindrome("ddsfad", cc));
    }
}

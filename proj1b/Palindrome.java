public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> newList = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            newList.addLast(word.charAt(i));
        }
        return newList;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> newList = new ArrayDeque<>();
        newList = wordToDeque(word);
        while (newList.size() >= 2) {
            if (!newList.removeFirst().equals(newList.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> newList = new ArrayDeque<>();
        newList = wordToDeque(word);
        // actually if we didn't add cc into parameters, we can define it as follows:
        // CharacterComparator cc = new OffByOne();
        while (newList.size() >= 2) {
            if (!cc.equalChars(newList.removeFirst(), newList.removeLast())) {
                return false;
            }
        }
        return true;
    }


}

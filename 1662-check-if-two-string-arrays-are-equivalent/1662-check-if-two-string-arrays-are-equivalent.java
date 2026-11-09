class Solution {

    public boolean arrayStringsAreEqual(
            String[] word1, String[] word2) {

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (String word : word1) {
            first.append(word);
        }

        for (String word : word2) {
            second.append(word);
        }

        return first.toString().equals(second.toString());
    }
}
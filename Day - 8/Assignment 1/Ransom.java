class Solution {

    public static boolean canMake(String[] magazine, String[] ransom) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < magazine.length; i++) {
            st.put(magazine[i], i+1);
        }
        for (int i = 0; i < ransom.length; i++) {
            int val = st.get(ransom[i]);
            if (val != 0) {
                st.put(ransom[i], val - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        String[] magazine = {"it", "was", "best", "of", "times"};
        String[] ransom = {"it", "was", "best", "of", "times", "it"};
        System.out.println(canMake(magazine, ransom) ? "Yes" : "No");
        String[] magazine1 = {"give", "me", "one", "grand", "today", "night"};
        String[] ransom1 = {"give", "one", "grand", "today"};
        System.out.println(canMake(magazine1, ransom1) ? "Yes" : "No");
    }

}
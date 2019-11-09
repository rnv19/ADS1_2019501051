class Solution {

    public static boolean ransomFind(String[] magazine, String[] ransom) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; i < magazine.length; i++) {
            if (st.contains(magazine[i])) {
                int value = st.get(magazine[i]);
                st.put(magazine[i], value + 1);
            }else st.put(magazine[i], 1);
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
        String[] ransom = {"it", "was", "best", "of", "times"};
        System.out.println(ransomFind(magazine, ransom) ? "Yes" : "No");
        String[] magazine1 = {"hello", "how", "are", "you", "doing", "today"};
        String[] ransom1 = {"how", "are", "you", "are", "are"};
        System.out.println(ransomFind(magazine1, ransom1) ? "Yes" : "No");
    }

}
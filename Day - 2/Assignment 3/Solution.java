import java.util.Stack;
class Solution{
	public static String isMatching(String str){
		// fill you code Here
		if(str.charAt(0) == ')' || str.charAt(0) == ']' || str.charAt(0) == '}'){
			return "NO";
		}
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '('){
				s.push(str.charAt(i));
			}else if(str.charAt(i) == '}'){
				if(s.pop() == '{'){
					continue;
				}else return "NO";
			}else if(str.charAt(i) == ')'){
				if(s.pop() == '('){
					continue;
				}else return "NO";
			}else if(str.charAt(i) == ']'){
				if(s.pop() == '['){
					continue;
				}else return "NO";
			}else break;

		}if(s.size() == 0){
			return "YES";
		}return "NO";
	}

	// public static void main(String args[]){
	// 	// Solution sol = new Solution();
	// 	String str = "[()][{}[{}[{}]]][]{}[]{}[]{{}({}(){({{}{}[([[]][[]])()]})({}{{}})})}";
	// 	System.out.println(isMatching(str));
	// }
}
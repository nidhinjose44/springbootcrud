package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
	
	public static void main(String args[]) {
		
		String str = null;
		String str1="abc";

		System.out.println(str1.equals("abc") || str.equals(null));
		
		final Integer ifinal=0;
 List<String>	listTest = Arrays.asList("a","b","c");
 listTest= new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		String input ="{[ab])bnn]]}}";
		int i=0;
		for(Character ch:input.toCharArray()) {
			i++;
			if(ch=='{'||ch=='['||ch=='(') {
				stack.push(ch);
				continue;
			}
			if(stack.empty()) {
				continue;
			}
			
			if(ch=='}'||ch==']'||ch==')') {
				Character top=stack.pop();
				switch(ch) {
				case '}':
					if(top!='}') {
						System.out.print("unbalanced at "+i);
					}
						break;
				case ']':
					if(top!='[') {
						System.out.print("unbalanced"+i);
					}
					break;
				case ')':
					if(top!='(') {
						System.out.print("unbalanced"+i);
					}
					break;
				default:
					break;
				}
			}
		}
	}

}

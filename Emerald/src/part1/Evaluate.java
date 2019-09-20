package part1;

public class Evaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(1+((2+3)*(3+4)))";
		Stack<Character> ops = new Stack<Character>();
		Stack<Double> vals = new Stack<Double>();
		char[] fomula = s.toCharArray();
		
		for(int i = 0; i<fomula.length; i++) {
			if 		(fomula[i] == '(');
			else if (fomula[i] == '(') ops.push(fomula[i]);
			else if (fomula[i] == '+') ops.push(fomula[i]);
			else if (fomula[i] == '_') ops.push(fomula[i]);
			else if (fomula[i] == '*') ops.push(fomula[i]);
			else if (fomula[i] == '/') ops.push(fomula[i]);
			else if (fomula[i] == ')') {
				Character op = ops.pop();
				Double val = vals.pop();
				if (op == '+') val = val + vals.pop();
				if (op == '-') val = val - vals.pop();
				if (op == '*') val = val * vals.pop();
				if (op == '/') val = val / vals.pop();
				vals.push(val);
			}
			else vals.push(Double.parseDouble(String.valueOf(fomula[i])));
		}
		
		System.out.print(vals.pop());
	}

}

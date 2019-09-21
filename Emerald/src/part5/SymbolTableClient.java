package part5;

public class SymbolTableClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minlen = Integer.parseInt(args[0]);
		ST<String, Integer> st = new ST<String, Integer>();
		while(!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if(word.length() <minlen) continue;
			if(!st.contain(word)) st.put(word, 1);
			else 				  st.put(word, st.get(word)+1);
		}
	}

}

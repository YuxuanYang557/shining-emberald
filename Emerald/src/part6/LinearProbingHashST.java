package part6;

public class LinearProbingHashST<Key, Value> {
	
	private int m = 1000;
	Key[] keys = (Key[]) new Object[m];
	Value[] values = (Value[]) new Object[m];
	
	private int hash(Key key) {
		return ((key.hashCode() & 0x7fffffff) % m);
	}
	
	public Value get(Key key) {
		int h = hash(key);
		for(int i=h; keys[i] != null; i = (i+1)%m) {
			if(key.equals(keys[i])) return values[i];
		}
		return null;
	}
	
	public void put(Key key, Value value) {
		int i =0;
		int h = hash(key);
		for(i = h; keys[i] != null; i = (i+1)%m) {
			if(key.equals(keys[i])) values[i] = value;;
		}
		keys[i] = key; 
		values[i] = value;
	}
}

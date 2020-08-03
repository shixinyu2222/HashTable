
public class OpenHashTable implements HashTable{

	private class Entry{
		private Object key;
		private LLQueue<Object> values;
	}
	private Entry[] table;
	
	//probing process
	private int probe(Object key) {
		int i = key.hashCode();
		int numChecked = 1;
		while(table[i] != null && !key.equals(table[i].key)) {
			if(numChecked == table.length) {
				return -1; // stop probing
			}
			i = (int)(i + Math.sqrt(numChecked)) % table.length;
			numChecked++;
		}
		return i;
	}
	
	//searching for a value by key
	public LLQueue<Object> search(Object key){
		if(key==null) {
			throw new IllegalArgumentException();
		}
		int i = probe(key);
		if(i == -1 || table[i] == null) {
			return null;
		} else {
			return table[i].values;
		}
	}
	
	//removing a value
	public LLQueue<Object> remove(Object key){
		if(key==null) {
			throw new IllegalArgumentException();
		}
		int i = probe(key);
		if(i == -1 || table[i] == null) {
			return null;
		}
		LLQueue<Object> removeValues = table[i].values;
		table[i].key = null;
		table[i].values = null;
		return removeValues;
	}

}

package archivador;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * Clase DuplicateMap.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class DuplicateMap<K, V> {

	/** The m. */
	private HashMap<K, ArrayList<V>> m = new HashMap<>();

	/**
	 * Put.
	 *
	 * @param k the k
	 * @param v the v
	 */
	public void put(K k, V v) {
		if (m.containsKey(k)) {
			m.get(k).add(v);
		} else {
			ArrayList<V> arr = new ArrayList<>();
			arr.add(v);
			m.put(k, arr);
		}
	}

	/**
	 * Gets the.
	 *
	 * @param k the k
	 * @return the array list
	 */
	public ArrayList<V> get(K k) {
		return m.get(k);
	}

	/**
	 * Removes the.
	 *
	 * @param k the k
	 */
	public void remove(K k) {
		m.remove(k);
	}

	/**
	 * Gets the.
	 *
	 * @param k the k
	 * @param index the index
	 * @return the v
	 */
	public V get(K k, int index) {
		return m.get(k).size() - 1 < index ? null : m.get(k).get(index);
	}
}

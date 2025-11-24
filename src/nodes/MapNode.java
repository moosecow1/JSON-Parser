package nodes;

import java.util.HashMap;
import java.util.Set;

public class MapNode extends Node {
	private HashMap<String, Object> map = new HashMap<>();

	public Set<String> getKeys() {
		return map.keySet();
	}

	public Object getValue(String key) {
		return map.get(key);
	}

	public void addValue(String key, Object value) {
		if (map.get(key) != null)
			return;

		map.put(key, value);
	}

	public void removeValue(String key) {
		if (map.get(key) == null)
			return;

		map.remove(key);
	}
}

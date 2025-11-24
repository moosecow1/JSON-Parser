package nodes;

import java.util.ArrayList;

public class TableNode extends Node {
	private ArrayList<Object> values = new ArrayList<>();

	public TableNode() {
		
	}

	public ArrayList<Object> getValues() {
		return this.values;
	}

	public Object getValue(int index) {
		if (index >= this.values.size())
			return null;

		return this.values.get(index);
	}

	public void addValue(Object value) {
		this.values.add(value);
	}
}

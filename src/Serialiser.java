import java.util.ArrayList;

import nodes.MapNode;
import nodes.Node;
import nodes.TableNode;

public class Serialiser {
	private static String generateString(Object root) {
		String buffer = "";

		if (root instanceof MapNode) {
			var mapNode = (MapNode)root;
			var mapKeys = new ArrayList<>(mapNode.getKeys());

			buffer += '{';

			for (int i = 0; i < mapKeys.size(); i++) {
				String key = mapKeys.get(i);
				String valueString = generateString(mapNode.getValue(key));

				buffer += String.format("\"%s\":%s", key, valueString);

				if (i < mapKeys.size()-1)
					buffer += ',';
			}

			buffer += '}';
		}
		else if (root instanceof TableNode) {
			var tableNode = (TableNode)root;
			var tableValues = tableNode.getValues();

			buffer += '[';

			for (int i = 0; i < tableValues.size(); i++) {
				buffer += generateString(tableValues.get(i));

				if (i < tableValues.size()-1)
					buffer += ',';
			}
			
			buffer += ']';
		}
		else if (root instanceof String) {
			buffer += String.format("\"%s\"", root.toString());
		}
		else if (root instanceof Boolean || root instanceof Integer || root instanceof Float) {
			buffer += root.toString();
		}
		else {
			System.err.println(String.format("Unknown: %s", root.toString()));
		}

		return buffer;
	}

	public static String serialise(Node tree) {
		return generateString(tree);
	}

	public static Node deserialise(String input) {
		return null;
	}
}

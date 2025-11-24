import nodes.MapNode;
import nodes.TableNode;

// TEMPORARY

public class TempTest {
	public static void tempTest() {
		MapNode root = new MapNode();
		TableNode tableNode = new TableNode();

		tableNode.addValue(5);
		tableNode.addValue("testValue");

		root.addValue("tempTable", tableNode);
		root.addValue("mapTestValue", true);

		String result = Serialiser.serialise(root);

		System.out.println(String.format("Result: %s", result));
	}
}

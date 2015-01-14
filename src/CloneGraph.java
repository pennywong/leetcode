import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode clone = map.get(node.label);

        if (clone == null) {
            clone = new UndirectedGraphNode(node.label);
            map.put(node.label, clone);

            for (UndirectedGraphNode neighbor : node.neighbors) {
                clone.neighbors.add(clone(neighbor, map));
            }
        }
        return clone;
    }
}

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> flag = new HashSet<UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            LinkedList<UndirectedGraphNode> queue2 = new LinkedList<UndirectedGraphNode>();
            while (!queue.isEmpty()) {
                UndirectedGraphNode top = queue.pop();
                flag.add(top);
                map.put(top, new UndirectedGraphNode(top.label));
                for (UndirectedGraphNode x : top.neighbors) {
                    if (!flag.contains(x))
                        queue2.add(x);
                }
            }
            queue = queue2;
        }
        
        for (UndirectedGraphNode x : map.keySet()) {
            UndirectedGraphNode cur = map.get(x);
            for (UndirectedGraphNode y : x.neighbors) {
                cur.neighbors.add(map.get(y));
            }
        }
        
        return map.get(node);
    }
}
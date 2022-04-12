import java.util.*;

public class Assignment07 {
    //133
    // similar to copy LinkedList with random pointers
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node head = new Node(node.val);
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        queue.add(node);
        map.put(node, head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.neighbors) {
                if (!map.containsKey(next)) {
                    Node copy = new Node(next.val);
                    map.put(next, copy);
                    queue.add(next);
                }
            }
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node cur = entry.getKey();
            Node copy = entry.getValue();
            for (Node next : cur.neighbors) {
                copy.neighbors.add(map.get(next));
            }
        }
        return head;
    }

    // 2065
    private int bestValue = 0;
    private int curValue = 0;
    private int curTime = 0;

    private Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
    private int visitCnt[];

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // visitCnt - keep the times each node is visited
        visitCnt = new int[values.length];

        // put nodes and edges and time in the hashmap
        for (int[] edge: edges) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new HashMap<>());
            }
            adj.get(edge[0]).put(edge[1], edge[2]);
            if (!adj.containsKey(edge[1])) {
                adj.put(edge[1], new HashMap<>());
            }
            adj.get(edge[1]).put(edge[0], edge[2]);
        }
        // backtracking
        backtracking(0, values, maxTime);

        return bestValue;
    }

    private void backtracking(int node, int[] values, int maxTime) {
        // curValue+ only if  the node hasn't been visited
        if (visitCnt[node] == 0) {
            curValue += values[node];
        }

        ++visitCnt[node];

        // if come back to Node0, update the max
        if (node == 0) {
            bestValue = Math.max(bestValue, curValue);
        }
        // corner case (the node is isolated)
        if (adj.get(node) != null) {
            // other nodes
            for (Map.Entry<Integer, Integer> entry : adj.get(node).entrySet()) {
                // cut branches
                if (curTime + entry.getValue() <= maxTime) {
                    curTime += entry.getValue();
                    backtracking(entry.getKey(), values, maxTime);
                    curTime -= entry.getValue();
                }
            }
        }

        --visitCnt[node];

        if (visitCnt[node] == 0) {
            curValue -= values[node];
        }
    }


    // 847
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1<<n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i,1<<i,0});
            seen[i][1<<i] = true;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1<<n) - 1) {
                ans = dist;
                break;
            }

            for (int v : graph[u]) {

                int maskV = mask | (1<<v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v,maskV,dist+1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}




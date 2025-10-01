import java.util.*;

class Solution {
    
    static Node[] lc;
    static Node[] rc;
    static List<Node> nodes = new ArrayList<>();    
    static List<Integer> pre = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;

        int[][] answer = new int[2][size];

        lc = new Node[size + 1];
        rc = new Node[size + 1];
        
        for(int i = 0; i < size; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
       
        Collections.sort(nodes, (o1, o2) -> (o2.y - o1.y));
    
        Node root = nodes.get(0);
        
        for(int i = 1; i < nodes.size(); i++) {
            make_tree(root, nodes.get(i));
        }
        
        preOrder(root, 0);
        postOrder(root, 0);
        
        for(int i = 0; i < size; i++) {
            answer[0][i] = pre.get(i); 
        }

        for(int i = 0; i < size; i++) {
            answer[1][i] = post.get(i); 
        }
        
        return answer;
    }
    
    static void preOrder(Node cur, int idx) {
        pre.add(cur.idx);
        
        if(lc[cur.idx] != null) {
            preOrder(lc[cur.idx], idx + 1);
        }
        
        if(rc[cur.idx] != null) {
            preOrder(rc[cur.idx], idx + 1);
        }
    }
    
    static void postOrder(Node cur, int idx) {
        if(lc[cur.idx] != null) {
            postOrder(lc[cur.idx], idx + 1);
        }
        
        if(rc[cur.idx] != null) {
            postOrder(rc[cur.idx], idx + 1);
        }
        
        post.add(cur.idx);
    }
    
    static void make_tree(Node parent, Node child) {
        if(parent.x > child.x) {
            if(lc[parent.idx] == null) lc[parent.idx] = child;
            else make_tree(lc[parent.idx], child);
        }        
        else {
            if(rc[parent.idx] == null) rc[parent.idx] = child;
            else make_tree(rc[parent.idx], child);
        }
    }
    
    static class Node {
        int x;
        int y;
        int idx;
        
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
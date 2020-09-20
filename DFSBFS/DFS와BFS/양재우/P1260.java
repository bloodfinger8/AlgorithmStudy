package HOMEWORK;

import java.util.*;

public class P1260 {
    /*

5 5 3
5 4
5 2
1 2
3 4
3 1
     */
    public static void main(String[] args) {
        Graph l = new Graph(5);
        l.addEdge(5, 4);
        l.addEdge(5, 2);
        l.addEdge(1, 2);
        l.addEdge(3, 4);
        l.addEdge(3, 1);

        l.dfs(2);
//        l.bfs(0);
     }
}

class Graph {
    public Node[] nodes;

    class Node {
         int data;
         boolean check;
         LinkedList<Node> list;

        public Node(int data) {
            this.data = data;
            this.check = false;
            this.list = new LinkedList<Node>();
        }
    }

    public Graph(int size) {
        this.nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i+1);
        }
    }

    public void addEdge(int val_1  , int val_2 ) {
        Node node_1 = nodes[val_1-1];
        Node node_2 = nodes[val_2-1];
        if(!node_1.list.contains(node_2)){
            node_1.list.add(node_2);
        }
        if(!node_2.list.contains(node_1)){
            node_2.list.add(node_1);
        }
    }

    //stack 을 이용한 풀이
    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.check = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (int i=r.list.size()-1; i>=0; i--) {
                if(r.list.get(i).check == false){
                    r.list.get(i).check = true;
                    stack.push(r.list.get(i));
                }
            }
//            Collections.sort(r.list, new Comparator<Node>() {
//                @Override
//                public int compare(Node o1, Node o2) {
//                    return (o1.data > o2.data) ? +1 : -1;
//                }
//            });
            System.out.println(r.data);
        }
    }

    //queue 를 이용한 풀이
    void bfs(int index){
        Node root = nodes[index];
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        root.check = true;

        while (!que.isEmpty()){
            Node r = que.poll();
            System.out.println(r.data);
            for(Node node : r.list) {
                if(node.check == false){
                    node.check = true;
                    que.add(node);
                }
            }
        }
    }


}


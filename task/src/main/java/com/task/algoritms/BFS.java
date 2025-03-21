package com.task.algoritms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

   static class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
    public static boolean search(Node root, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.value == target) {
                return true; // элемент найден
            }

            for (Node child : node.children) {
                queue.add(child);
            }
        }

        return false; // элемент не найден
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));

        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        root.children.get(1).children.add(new Node(7));
        root.children.get(1).children.add(new Node(8));

        int target = 7;
        boolean found = search(root, target);

        if (found) {
            System.out.println("Элемент " + target + " найден");
        } else {
            System.out.println("Элемент " + target + " не найден");
        }
        int[] i = {1,2,3,};

    }
}


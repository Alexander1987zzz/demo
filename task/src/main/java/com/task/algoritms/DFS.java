package com.task.algoritms;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    static class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public static boolean search(Node node, int target) {
        if (node == null) {
            return false;
        }

        if (node.value == target) {
            return true; // элемент найден
        }

        for (Node child : node.children) {
            if (search(child, target)) {
                return true; // элемент найден в дочернем узле
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
    }
}

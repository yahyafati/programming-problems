package com.yahyafati.problems;

import java.util.ArrayList;
import java.util.List;

public class OneDArray implements IProblem{

    static class Node {
        String name;
        List<Node> children;

        Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }

        Node getChildNode(String name) {
            return children
                    .stream()
                    .filter(n -> n.name.equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + this.children.toString() + ")";
        }
    }

    private void print(List<String> list) {
        Node root = new Node("/");
        for (String path : list) {
            String[] subPaths = path.split("/");
            if (subPaths.length == 0) continue;
            Node current = root;
            for (int i = 0; i < subPaths.length - 1; i++) {
                Node childNode = current.getChildNode(subPaths[i]);
                if (childNode == null) {
                    childNode = new Node(subPaths[i]);
                    current.children.add(childNode);
                }
                current = childNode;
            }
            current.children.add(new Node(subPaths[subPaths.length - 1]));
        }

        for (Node child: root.children) {
            printDfs(child, "");
            System.out.println();
        }
    }


    String toSpace(int length) {
        StringBuilder sb = new StringBuilder();
        while (length-- > 0){
            sb.append(" ");
        }
        return sb.toString();
    }

    void printDfs(Node node, String space) {
        System.out.print(" --> " + node.name);
        String newSpace = space + "     " + toSpace(node.name.length());
        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            printDfs(child, newSpace);
            if (i < node.children.size() - 1) {
                System.out.print("\n" + newSpace);
            }
        }
    }

    @Override
    public void solve() {
        List<String> list = new ArrayList<>();
        list.add("app/src/root/game/file1.cpp");
        list.add("app/src/root/game/file2.cpp");
        list.add("app/src/root/game/file3.cpp");
        list.add("app/src/root/file4.cpp");
        list.add("app/data/file5.cpp");
        list.add("app/data/file6.cpp");
        list.add("pom.xml");
        print(list);
    }
}

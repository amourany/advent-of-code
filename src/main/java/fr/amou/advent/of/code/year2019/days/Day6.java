package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Day6 extends Day2019 {

    public Day6() {
        super(6);
    }

    public static void main(String[] args) throws IOException {
        new Day6().printParts();
    }

    private static Set<TreeNode> buildTree(List<String> mapEntries) {
        AtomicReference<Set<TreeNode>> nodesReference = new AtomicReference<>(new HashSet<>());
        mapEntries.stream()
                .map(entry -> entry.split("\\)"))
                .forEach(entry -> {
                    Set<TreeNode> allNodes = nodesReference.get();

                    TreeNode firstNode = allNodes.stream()
                            .filter(node -> node.objectName.equals(entry[0]))
                            .findFirst()
                            .orElse(new TreeNode(null, entry[0]));

                    TreeNode secondNode = allNodes.stream()
                            .filter(node -> node.objectName.equals(entry[1]))
                            .findFirst()
                            .orElse(new TreeNode(firstNode, entry[1]));

                    secondNode.parent = firstNode;

                    allNodes.add(firstNode);
                    allNodes.add(secondNode);
                });

        return nodesReference.get();
    }

    public static Integer countOrbits(List<String> mapEntries) {
        Set<TreeNode> nodes = buildTree(mapEntries);

        return nodes.stream()
                .map(TreeNode::getDepth)
                .reduce(0, Math::addExact);
    }

    @Override
    public Object part1() throws IOException {
        List<String> mapEntries = readDataAsList();
        return countOrbits(mapEntries);
    }

    @Override
    public Object part2() throws IOException {
        return null;
    }

    static class TreeNode {

        private final String objectName;
        private TreeNode parent;

        public TreeNode(TreeNode parent, String objectName) {
            this.parent = parent;
            this.objectName = objectName;
        }

        public int getDepth() {
            return parent == null ? 0 : parent.getDepth() + 1;
        }

        @Override
        public int hashCode() {
            return Objects.hash(objectName);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return objectName.equals(treeNode.objectName);
        }
    }
}

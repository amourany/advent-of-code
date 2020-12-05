package fr.amou.advent.of.code.year2019.days;

import fr.amou.advent.of.code.year2019.Day2019;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day6 extends Day2019 {

    public static final TreeNode MY_POSITION = new TreeNode(null, "YOU");
    public static final TreeNode SANTA_POSITION = new TreeNode(null, "SAN");

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
                            .filter(node -> StringUtils.equals(node.objectName, entry[0]))
                            .findFirst()
                            .orElse(new TreeNode(null, entry[0]));

                    TreeNode secondNode = allNodes.stream()
                            .filter(node -> StringUtils.equals(node.objectName, entry[1]))
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

    private static Stream<List<TreeNode>> moveNextOrbit(Set<TreeNode> nodes, TreeNode currentNode) {
        if (currentNode.equals(SANTA_POSITION)) {
            return Stream.of(List.of(currentNode));
        }

        return nodes.stream()
                .filter(node -> (node.equals(currentNode.parent) || currentNode.equals(node.parent)) && nodes.contains(
                        node))
                .map(node -> {
                    Set<TreeNode> unexploredNodes = new HashSet<>(nodes);
                    unexploredNodes.remove(currentNode);
                    return moveNextOrbit(unexploredNodes, node).map(orbits -> {
                        List<TreeNode> newOrbits = new ArrayList<>(orbits);
                        newOrbits.add(node);
                        return newOrbits;
                    })
                            .collect(Collectors.toList());
                })
                .flatMap(List::stream);
    }

    public static Integer countJumps(List<String> mapEntries) {
        Set<TreeNode> nodes = buildTree(mapEntries);

        TreeNode currentPosition = nodes.stream()
                .filter(node -> node.equals(MY_POSITION))
                .findFirst()
                .get();

        return moveNextOrbit(nodes, currentPosition).findFirst()
                .get()
                .size() - 3;
    }

    @Override
    public Object part1() throws IOException {
        List<String> mapEntries = readDataAsList();
        return countOrbits(mapEntries);
    }

    @Override
    public Object part2() throws IOException {
        List<String> mapEntries = readDataAsList();
        return countJumps(mapEntries);
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

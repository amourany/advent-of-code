package fr.amou.advent.of.code.year2020.days;

import fr.amou.advent.of.code.year2020.Day2020;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 extends Day2020 {

    private static final Pattern BAG_COLOR_PATTERN = Pattern.compile("([0-9]?)([a-z ]*) bag[s]?");

    public Day7() {
        super(7);
    }

    public static void main(String[] args) throws IOException {
        new Day7().printParts();
    }

    private static Set<TreeNode> buildRulesTree(List<String> ruleset) {
        AtomicReference<Set<TreeNode>> nodesReference = new AtomicReference<>(new HashSet<>());
        ruleset.stream()
                .map(rule -> rule.split(" contain "))
                .forEach(ruleParts -> {
                    Set<TreeNode> allNodes = nodesReference.get();

                    Matcher containingBagMatcher = BAG_COLOR_PATTERN.matcher(ruleParts[0]);
                    containingBagMatcher.find();
                    String containingBag = containingBagMatcher.group(2);

                    TreeNode containingBagNode = allNodes.stream()
                            .filter(node -> StringUtils.equals(node.objectName, containingBag))
                            .findFirst()
                            .orElse(new TreeNode(new HashMap<>(), containingBag));
                    allNodes.add(containingBagNode);

                    Matcher containedBagMatcher = BAG_COLOR_PATTERN.matcher(ruleParts[1]);
                    while (containedBagMatcher.find()) {
                        String bag = StringUtils.trim(containedBagMatcher.group(2));
                        if (!bag.contains("no other")) {
                            Integer nbBags = Integer.parseInt(containedBagMatcher.group(1));

                            TreeNode containedBag = allNodes.stream()
                                    .filter(node -> StringUtils.equals(node.objectName, bag))
                                    .findFirst()
                                    .orElse(new TreeNode(new HashMap<>(), bag));

                            containingBagNode.children.put(containedBag, nbBags);
                            allNodes.add(containedBag);
                        }
                    }
                });

        return nodesReference.get();
    }

    private static Stream<TreeNode> findParentBags(Set<TreeNode> nodes, TreeNode currentNode) {

        boolean isRoot = nodes.stream()
                .noneMatch(node -> node.children.containsKey(currentNode));

        if (isRoot) {
            return Stream.of(currentNode);
        }

        return nodes.stream()
                .filter(node -> node.children.containsKey(currentNode))
                .flatMap(node -> {
                    Set<TreeNode> unexploredBags = new HashSet<>(nodes);
                    unexploredBags.remove(currentNode);
                    Set<TreeNode> foundBags = findParentBags(unexploredBags, node).collect(Collectors.toSet());
                    foundBags.add(node);
                    return foundBags.stream();
                });
    }

    public static int countContainingBags(List<String> ruleset) {
        Set<TreeNode> nodes = buildRulesTree(ruleset);

        TreeNode shinyGoldBag = nodes.stream()
                .filter(node -> node.equals(new TreeNode(null, "shiny gold")))
                .findFirst()
                .get();

        return findParentBags(nodes, shinyGoldBag).collect(Collectors.toSet())
                .size();
    }

    public static int countTotalBags(List<String> ruleset) {
        Set<TreeNode> nodes = buildRulesTree(ruleset);

        TreeNode shinyGoldBag = nodes.stream()
                .filter(node -> node.equals(new TreeNode(null, "shiny gold")))
                .findFirst()
                .get();

        return shinyGoldBag.getNbOfInnerBags();
    }

    @Override
    public Object part1() throws IOException {
        List<String> ruleset = readDataAsList();
        return countContainingBags(ruleset);
    }

    @Override
    public Object part2() throws IOException {
        List<String> ruleset = readDataAsList();
        return countTotalBags(ruleset);
    }

    static class TreeNode {

        private final String objectName;
        private final Map<TreeNode, Integer> children;

        public TreeNode(Map<TreeNode, Integer> children, String objectName) {
            this.children = children;
            this.objectName = objectName;
        }

        public Integer getNbOfInnerBags() {
            return children.isEmpty() ? 0 : children.entrySet()
                    .stream()
                    .map(entry -> entry.getValue() * (entry.getKey()
                            .getNbOfInnerBags() + 1))
                    .reduce(0, Math::addExact);
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
            return StringUtils.equals(objectName, treeNode.objectName);
        }
    }
}

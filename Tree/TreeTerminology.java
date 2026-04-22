import java.util.*;

class OrgNode {
    String name;
    List<OrgNode> children;
    OrgNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class TreeTerminology {
    public static void main(String[] args) {
        // Construct the tree
        OrgNode ceo = new OrgNode("CEO");
        OrgNode cto = new OrgNode("CTO");
        OrgNode cfo = new OrgNode("CFO");
        ceo.children.add(cto);
        ceo.children.add(cfo);
        
        OrgNode devLead = new OrgNode("Dev Lead");
        cto.children.add(devLead);
        
        OrgNode hr = new OrgNode("HR");
        cfo.children.add(hr); 
        
        OrgNode dev1 = new OrgNode("Dev1");
        OrgNode dev2 = new OrgNode("Dev2");
        devLead.children.add(dev1);
        devLead.children.add(dev2);

        System.out.println("Problem 1: Tree Terminology Identification\n");

        System.out.println("a) Leaf nodes: " + getLeafNodes(ceo));
        System.out.println("b) Height of the tree: " + getHeight(ceo));
        System.out.println("c) Depth of 'Dev Lead': " + getDepth(ceo, "Dev Lead", 0));
        System.out.println("d) Ancestors of 'Dev1': " + getAncestors(ceo, "Dev1"));
        System.out.println("e) Degree of 'CTO' node: " + cto.children.size() + " (assuming unspecified node is ignored)");
    }

    static List<String> getLeafNodes(OrgNode root) {
        List<String> leaves = new ArrayList<>();
        if (root == null) return leaves;
        if (root.children.isEmpty()) leaves.add(root.name);
        for (OrgNode child : root.children) {
            leaves.addAll(getLeafNodes(child));
        }
        return leaves;
    }

    static int getHeight(OrgNode root) {
        if (root == null || root.children.isEmpty()) return 0;
        int maxChildHeight = 0;
        for (OrgNode child : root.children) {
            maxChildHeight = Math.max(maxChildHeight, getHeight(child));
        }
        return 1 + maxChildHeight;
    }

    static int getDepth(OrgNode root, String target, int currentDepth) {
        if (root == null) return -1;
        if (root.name.equals(target)) return currentDepth;
        for (OrgNode child : root.children) {
            int depth = getDepth(child, target, currentDepth + 1);
            if (depth != -1) return depth;
        }
        return -1;
    }

    static List<String> getAncestors(OrgNode root, String target) {
        List<String> path = new ArrayList<>();
        findPath(root, target, path);
        if (!path.isEmpty()) {
            path.remove(path.size() - 1); // remove target itself
            Collections.reverse(path); // order from closest ancestor to farthest root
        }
        return path;
    }

    static boolean findPath(OrgNode root, String target, List<String> path) {
        if (root == null) return false;
        path.add(root.name);
        if (root.name.equals(target)) return true;
        for (OrgNode child : root.children) {
            if (findPath(child, target, path)) return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}

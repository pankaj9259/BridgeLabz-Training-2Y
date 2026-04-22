class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int val) { this.val = val; }
}

public class BSTConstruction {
    static BSTNode root;
    
    public static void main(String[] args) {
        System.out.println("Problem 3: BST Construction and Validation\n");
        
        int[] vals = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        for (int v : vals) insert(v);
        System.out.println("a) BST internally populated. Height is: " + height(root));
        
        System.out.println("\nb) Sequence of comparisons for finding element 25:");
        searchAndPrint(root, 25);
        
        System.out.print("\nc) Inorder traversal of constructed BST: ");
        inorder(root);
        System.out.println();
        
        // Creating an invalid BST setup for test validation
        BSTNode invalidRoot = new BSTNode(50);
        invalidRoot.left = new BSTNode(30);
        invalidRoot.right = new BSTNode(70);
        invalidRoot.left.left = new BSTNode(20);
        invalidRoot.left.right = new BSTNode(65); // Invalid point (65 is > 50 so it can't be in left subtree of 50 root)
        invalidRoot.right.left = new BSTNode(60);
        invalidRoot.right.right = new BSTNode(80);
        
        System.out.println("\nd) Is the provided sample tree a valid BST? " + isValidBST(invalidRoot, null, null));
        System.out.println("   Explanation: It is invalid because node 65 appears in left subtree of 50, but 65 > 50.");
        
        System.out.println("\ne) Height of completely skewed BST with 9 elements would be 8.");
        System.out.println("   However, the balanced tree's height for these elements is " + height(root) + ".");
    }

    static void insert(int val) {
        root = insertRec(root, val);
    }

    static BSTNode insertRec(BSTNode root, int val) {
        if (root == null) return new BSTNode(val);
        if (val < root.val) root.left = insertRec(root.left, val);
        else if (val > root.val) root.right = insertRec(root.right, val);
        return root;
    }

    static void searchAndPrint(BSTNode node, int val) {
        if (node == null) {
            System.out.println("Not found.");
            return;
        }
        System.out.println("Comparing with " + node.val);
        if (val == node.val) {
            System.out.println("Node Found! -> " + val);
        } else if (val < node.val) {
            searchAndPrint(node.left, val);
        } else {
            searchAndPrint(node.right, val);
        }
    }

    static void inorder(BSTNode node) {
        if (node != null) {
            inorder(node.left);  System.out.print(node.val + " ");  inorder(node.right);
        }
    }

    static boolean isValidBST(BSTNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    
    static int height(BSTNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

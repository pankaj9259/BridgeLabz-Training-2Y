class OpsNode {
    int val;
    OpsNode left, right;
    OpsNode(int val) { this.val = val; }
}

public class BSTOperations {
    static OpsNode root;
    
    public static void main(String[] args) {
        System.out.println("Problem 4: BST Operations\n");
        int[] vals = {15, 10, 20, 8, 12, 17, 25};
        for (int v : vals) insert(v);
        
        System.out.print("Base tree inorder: ");
        inorder(root); System.out.println("\n");
        
        System.out.println("a) Deleting 10 (has two children)...");
        root = deleteNode(root, 10);
        System.out.print("   Post-deletion inorder: ");
        inorder(root); System.out.println();
        
        System.out.println("\nb) Inserting 14 into the modified tree...");
        insert(14);
        System.out.print("   Post-insertion inorder: ");
        inorder(root); System.out.println();
        
        System.out.println("\nc) Inserting 9...");
        insert(9);
        System.out.print("   Post-insertion inorder: ");
        inorder(root); System.out.println();
        
        System.out.print("\nd) Students strictly between 10 and 20: ");
        findRange(root, 10, 20);
        System.out.println("\n   Which traversal is efficient? Range Search Using Inorder traversal (pruning unrelated branches) since it yields sorted elements.");
        
        System.out.println("\ne) Time complexity to search roll 25:");
        System.out.println("   Best-case: O(1) (if lucky element placed at root spot)");
        System.out.println("   Worst-case: O(N) (if elements inserted linearly turning BST to LinkedList)");
    }
    
    static void insert(int val) { root = insertRec(root, val); }
    
    static OpsNode insertRec(OpsNode root, int val) {
        if (root == null) return new OpsNode(val);
        if (val < root.val) root.left = insertRec(root.left, val);
        else if (val > root.val) root.right = insertRec(root.right, val);
        return root;
    }
    
    static void inorder(OpsNode node) {
        if (node != null) {
            inorder(node.left); System.out.print(node.val + " "); inorder(node.right);
        }
    }
    
    static OpsNode deleteNode(OpsNode root, int key) {
        if (root == null) return root;
        
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            // Node with 2 children handled here
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            
            // Replaces node iteratively using Inorder Successor rules
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    static int minValue(OpsNode root) {
        int minh = root.val;
        while (root.left != null) {
            minh = root.left.val;
            root = root.left;
        }
        return minh;
    }
    
    static void findRange(OpsNode node, int low, int high) {
        if (node == null) return;
        if (node.val > low) findRange(node.left, low, high);
        if (node.val >= low && node.val <= high) System.out.print(node.val + " ");
        if (node.val < high) findRange(node.right, low, high);
    }
}

class FileNode {
    String val;
    FileNode left, right;
    FileNode(String val) { this.val = val; }
}

public class TraversalApplication {
    public static void main(String[] args) {
        FileNode root = new FileNode("root");
        root.left = new FileNode("home");
        root.right = new FileNode("var");
        root.left.left = new FileNode("user");
        root.left.right = new FileNode("docs");
        root.right.right = new FileNode("log");
        root.left.left.left = new FileNode("config");

        System.out.println("Problem 2: Traversal Application\n");
        System.out.println("a) To list files alphabetically in a BST, use: Inorder Traversal");
        System.out.println("b) To calculate directory size, use: Postorder Traversal");
        System.out.println("c) To copy entire structure, use: Preorder Traversal\n");
        
        System.out.print("d) Inorder Traversal: ");
        inorder(root);
        System.out.println();
        
        System.out.print("   Preorder Traversal: ");
        preorder(root);
        System.out.println();
        
        System.out.print("   Postorder Traversal: ");
        postorder(root);
        System.out.println();

        System.out.println("\ne) Postorder safely deletes directories by deleting children contents before reaching the root parent item, bypassing empty-dependency OS restrictions.");
    }

    static void inorder(FileNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }

    static void preorder(FileNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    static void postorder(FileNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val + " ");
        }
    }
}

import java.util.*;

class ExpNode {
    String val;
    ExpNode left, right;
    ExpNode(String val) { this.val = val; }
}

public class ExpressionTree {
    public static void main(String[] args) {
        System.out.println("Problem 5: Expression Tree Evaluation\n");
        
        // Tree 1 construction: (3 + 5) * (8 - 2)
        ExpNode root = new ExpNode("*");
        root.left = new ExpNode("+");
        root.right = new ExpNode("-");
        root.left.left = new ExpNode("3");
        root.left.right = new ExpNode("5");
        root.right.left = new ExpNode("8");
        root.right.right = new ExpNode("2");
        
        System.out.print("a) Postorder traversal (Postfix Notation): ");
        postorder(root); 
        System.out.println("\n   Shows Reverse-Polish by placing Operators at the end of node combinations.");
        
        System.out.print("\nb) Inorder traversal (Produces valid original Infix Format with parens): ");
        System.out.print(inorderExpr(root)); 
        System.out.println();
        
        System.out.print("\nc) Preorder traversal (Prefix Notation): ");
        preorder(root); 
        System.out.println("\n   Shows Polish Notation pushing Operators cleanly to the front boundary.");
        
        System.out.println("\nd) Process Evaluated Total from Traversing Tree Output: " + evaluateExpTree(root));
        
        System.out.println("\ne) Process Traversals on second Expression Tree structure: a * b + c / d - e");
        ExpNode root2 = buildSecondTree();
        System.out.print("   Inorder: "); inorderRaw(root2); System.out.println();
        System.out.print("   Preorder: "); preorder(root2); System.out.println();
        System.out.print("   Postorder: "); postorder(root2); System.out.println();
    }
    
    // Evaluating the structure dynamically
    static int evaluateExpTree(ExpNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return Integer.parseInt(node.val);
        
        int leftVal = evaluateExpTree(node.left);
        int rightVal = evaluateExpTree(node.right);
        
        switch (node.val) {
            case "+": return leftVal + rightVal;
            case "-": return leftVal - rightVal;
            case "*": return leftVal * rightVal;
            case "/": return leftVal / rightVal;
        }
        return 0;
    }
    
    static String inorderExpr(ExpNode node) {
        if (node == null) return "";
        if (node.left == null && node.right == null) return node.val;
        return "(" + inorderExpr(node.left) + " " + node.val + " " + inorderExpr(node.right) + ")";
    }

    static void inorderRaw(ExpNode node) {
        if (node != null) {
            inorderRaw(node.left); System.out.print(node.val + " "); inorderRaw(node.right);
        }
    }
    
    static void preorder(ExpNode node) {
        if (node != null) {
            System.out.print(node.val + " "); preorder(node.left); preorder(node.right);
        }
    }
    
    static void postorder(ExpNode node) {
        if (node != null) {
            postorder(node.left); postorder(node.right); System.out.print(node.val + " ");
        }
    }
    
    static ExpNode buildSecondTree() {
        ExpNode root2 = new ExpNode("-");
        root2.left = new ExpNode("+");
        root2.right = new ExpNode("e");
        root2.left.left = new ExpNode("*");
        root2.left.right = new ExpNode("/");
        root2.left.left.left = new ExpNode("a");
        root2.left.left.right = new ExpNode("b");
        root2.left.right.left = new ExpNode("c");
        root2.left.right.right = new ExpNode("d");
        return root2;
    }
}

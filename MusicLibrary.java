class Node {
    String title;
    Node left, right;

    public Node(String title) {
        this.title = title;
        left = right = null;
    }
}

class MusicLibrary {
    private Node root;

    public MusicLibrary() {
        root = null;
    }

    // Insert a new song into the BST
    public void insert(String title) {
        root = insertRec(root, title);
    }

    private Node insertRec(Node root, String title) {
        if (root == null) {
            root = new Node(title);
            return root;
        }

        if (title.compareTo(root.title) < 0) {
            root.left = insertRec(root.left, title);
        } else if (title.compareTo(root.title) > 0) {
            root.right = insertRec(root.right, title);
        }

        // If the title is equal, we do nothing (no duplicates in BST)
        return root;
    }

    // Search for a song in the BST
    public boolean search(String title) {
        return searchRec(root, title);
    }

    private boolean searchRec(Node root, String title) {
        if (root == null) {
            return false;
        }

        if (title.equals(root.title)) {
            return true;
        } else if (title.compareTo(root.title) < 0) {
            return searchRec(root.left, title);
        } else {
            return searchRec(root.right, title);
        }
    }

    // Delete a song from the BST
    public void delete(String title) {
        root = deleteRec(root, title);
    }

    private Node deleteRec(Node root, String title) {
        if (root == null) {
            return null;
        }

        if (title.compareTo(root.title) < 0) {
            root.left = deleteRec(root.left, title);
        } else if (title.compareTo(root.title) > 0) {
            root.right = deleteRec(root.right, title);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.title = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.title);
        }

        return root;
    }

    private String minValue(Node root) {
        String minValue = root.title;
        while (root.left != null) {
            root = root.left;
            minValue = root.title;
        }
        return minValue;
    }

    // InOrder Traversal
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.println(root.title);
            inOrderTraversalRec(root.right);
        }
    }

    // PreOrder Traversal
    public void preOrderTraversal() {
        preOrderTraversalRec(root);
    }

    private void preOrderTraversalRec(Node root) {
        if (root != null) {
            System.out.println(root.title);
            preOrderTraversalRec(root.left);
            preOrderTraversalRec(root.right);
        }
    }

    // PostOrder Traversal
    public void postOrderTraversal() {
        postOrderTraversalRec(root);
    }

    private void postOrderTraversalRec(Node root) {
        if (root != null) {
            postOrderTraversalRec(root.left);
            postOrderTraversalRec(root.right);
            System.out.println(root.title);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();
        library.insert("Navarasam");
        library.insert("Over the Horizon");
        library.insert("Eswarane Thedi");
        library.insert("Nammal");
        library.insert("Charlie");
        library.insert("Gokulam");
        library.insert("Anvar");
        library.insert("Matinee");
        library.insert("Ivan Megharoopan");
        library.insert("Madhanolsavam");
        library.insert("Avial");
        library.insert("Indian Summer");

        System.out.println("The names of few Malayalam album songs are listed, They are Navarasam, Over the Horizon, Eswarane Thedi, Nammal, Charlie, Gokulam, Anvar, Matinee, Ivan Megharoopan, Madhanolsavam, Avial, Indian Summer")  ;

        System.out.println("InOrder Traversal:");
        library.inOrderTraversal();

        System.out.println("PreOrder Traversal:");
        library.preOrderTraversal();

        System.out.println("PostOrder Traversal:");
        library.postOrderTraversal();

        System.out.println("Search for Indian Summer: " + library.search("Indian Summer"));
        System.out.println("Search for English Rap: " + library.search("English Rap"));

        library.delete("Matinee");
        System.out.println("Matinee deleted.");

        System.out.println("InOrder Traversal after deletion:");
        library.inOrderTraversal();
    }
}

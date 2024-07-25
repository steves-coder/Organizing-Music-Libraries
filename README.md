# Organizing-Music-Libraries
This is a code done in JAVA based on B.nary Search Tree (BST). For applications managing music libraries or playlists. 

Let's break down the Java code for creating a Binary Search Tree (BST) for organizing a music library with song titles, including the insertion, search, deletion, and traversal operations. We will go through the provided code line by line to explain its functionality.

The Node class represents each node in the BST, storing the song title and references to its left and right child nodes.
class Node {
    String title;
    Node left, right;

    public Node(String title) {
        this.title = title;
        left = right = null;
    }
}
The MusicLibrary class manages the BST and includes methods for inserting, searching, deleting, and traversing the nodes.
class MusicLibrary {
    Node root;

    public MusicLibrary() {
        root = null;
    }
    // Constructor initializes the root of the BST to null.

    The insert method inserts a new song into the BST, maintaining the property of the BST.

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

        return root;
    }

The search method searches for a song in the BST and returns true if the song is found, otherwise false.

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

    The delete method removes a song from the BST while maintaining the properties of the BST.

    // Delete a song from the BST
    public void delete(String title) {
        root = deleteRec(root, title);
    }

    private Node deleteRec(Node root, String title) {
        if (root == null) {
            return null;
        }

        // (Implementation of deleteRec method)
The minValue method helps in finding the node with the minimum value in the right subtree when deleting a node with two children.

private String minValue(Node node) {
        String minValue = node.title;
        while (node.left != null) {
            minValue = node.left.title;
            node = node.left;
        }

        return minValue;
    }

The inOrderTraversal, preOrderTraversal, and postOrderTraversal methods perform InOrder, PreOrder, and PostOrder traversal, respectively, of the BST, printing out the song titles in the specified order.

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

    // PreOrder Traversal (Implementation of preOrderTraversal and preOrderTraversalRec methods)

    // PostOrder Traversal (Implementation of postOrderTraversal and postOrderTraversalRec methods)

1. Create a MusicLibrary object:
   MusicLibrary library = new MusicLibrary();
2. Insert songs into the BST:
   library.insert("List of Songs");
3. Perform InOrder, PreOrder, and PostOrder Traversal:

   System.out.println("InOrder Traversal:");
library.inOrderTraversal();

System.out.println("PreOrder Traversal:");
library.preOrderTraversal();

System.out.println("PostOrder Traversal:");
library.postOrderTraversal();

Prints the songs in the BST in InOrder, PreOrder, and PostOrder traversal orders. These traversal methods internally traverse the binary search tree and print the song titles in the specified order.

4. Search for songs in the BST:
   System.out.println("Search for a song : " + library.search("Song"));

5. Delete a song from the BST:

  library.delete("Song");
  System.out.println("Song deleted.");

6. Perform InOrder Traversal after deletion:
   System.out.println("InOrder Traversal after deletion:");
   library.inOrderTraversal();


Prints the songs in the BST in InOrder traversal order after the deletion operation to showcase the updated contents of the binary search tree.

Overall, this main method provides a comprehensive demonstration of managing a music library using a binary search tree, showcasing the insertion, traversal, search, and deletion operations.





So the final code is:


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


The output of the provided code will include the results of the in-order, pre-order, and post-order traversals of the binary search tree (BST), as well as the results of the search operations and the BST structure after deleting a node. Here is the expected output:

InOrder Traversal:
Anvar
Avial
Charlie
Eswarane Thedi
Gokulam
Indian Summer
Ivan Megharoopan
Madhanolsavam
Matinee
Nammal
Navarasam
Over the Horizon

PreOrder Traversal:
Navarasam
Gokulam
Charlie
Anvar
Avial
Eswarane Thedi
Ivan Megharoopan
Indian Summer
Madhanolsavam
Matinee
Nammal
Over the Horizon

PostOrder Traversal:
Avial
Anvar
Eswarane Thedi
Charlie
Indian Summer
Matinee
Madhanolsavam
Ivan Megharoopan
Gokulam
Nammal
Over the Horizon
Navarasam

Search for Indian Summer: true
Search for English Rap: false
Matinee deleted.

InOrder Traversal after deletion:
Anvar
Avial
Charlie
Eswarane Thedi
Gokulam
Indian Summer
Ivan Megharoopan
Madhanolsavam
Nammal
Navarasam
Over the Horizon


Explanation:
InOrder Traversal:

Visits nodes in the order: left, root, right.
Output: The songs are listed in alphabetical order.
PreOrder Traversal:

Visits nodes in the order: root, left, right.
Output: The songs are listed starting from the root and recursively visiting the left and right subtrees.
PostOrder Traversal:

Visits nodes in the order: left, right, root.
Output: The songs are listed starting from the leftmost node and recursively visiting the left and right subtrees, ending with the root.
Search Operations:

Searches for "Indian Summer": Found (true).
Searches for "English Rap": Not found (false).
Deletion and InOrder Traversal After Deletion:

Deletes "Matinee" and performs an in-order traversal again.
Output: "Matinee" is removed from the list, and the remaining songs are still in alphabetical order.

   


   
    

    
    



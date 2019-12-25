import java.util.stream.Stream;

public class GfG {

    Node root; 
  
    // returns true if the binary tree is bst
    int isBST(Node root)  {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
     		   .anyMatch(v -> v == false)? 0: 1;
    } 
  
    Stream<Boolean> isBSTUtil(Node node, int min, int max) 
    { 
        // empty tree is BST
        if (node == null) 
        	return Stream.of(true); 
  
        if (node.data < min || node.data > max) 
        	return Stream.of(false); 
  
        //recursively check subtrees
        return Stream.concat(isBSTUtil(node.left, min, node.data-1),
        		isBSTUtil(node.right, node.data+1, max));       	
    }
}

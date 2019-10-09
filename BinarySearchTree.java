/**
 * @ClassName BinarySearchTree
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/10/8  18:44
 * @Veresion 1.0
 */


public class BinarySearchTree {
    class Node{
        int key;

        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
     static Node root=null;
    public Node search(int key){
        Node cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur;
            }
            else if(key<cur.key){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        return null;
    }
    public boolean insert(int key){
        Node cur=root;
        Node parent=null;
        if(root==null){
            root=new Node(key);
            return true;
        }
        while(cur!=null){
            if(key==cur.key){
                return false;
            }
            else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else {
                parent=cur;
                cur = cur.right;
            }
        }
        Node node=new Node(key);
        if(key<parent.key){
            parent.left=node;
        }
        else{
            parent.right=node;
        }
        return true;
    }


    public static boolean remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                //找到删除
                delete(parent,cur);
                return true;
            }
            else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else {
                parent=cur;
                cur = cur.right;
            }
        }
        return false;
    }

    private static void delete(Node parent, Node cur) {
        if(cur.left==null){
            if(cur==root){
                cur=cur.right;
            }
            else if(cur==parent.left){
                parent.left=cur.right;
            }
            else{
                parent.right=cur.right;
            }
        }
        else if(cur.right==null){
            if(cur==root){
                cur=cur.left;
            }
            else if(cur==parent.left){
                parent.left=cur.left;
            }
            else{
                parent.right=cur.left;
            }
        }
        else{
            Node goatparent=cur;
            Node goat=cur.left;
            while(goat.right!=null){
                goatparent=goat;
                goat=goat.right;
            }
            cur.key=goat.key;
            if(goatparent.right==goat){
                goatparent.right=goat.left;
            }
            else{
                goatparent.left=goat.left;
            }
        }
    }

    public static void inorder(Node root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
       BinarySearchTree tree=new BinarySearchTree();
        int[] keys={3,6,4,2,7,8,9};
        for(int key:keys){
            System.out.println(tree.insert(key));
        }
        System.out.println("插入重复元素");
        System.out.println(tree.insert(8));
        System.out.println("插入不重复元素");
        System.out.println(tree.insert(5));
        System.out.println("前序遍历");
        preorder(tree.root);
        System.out.println("中序遍历");
        inorder(tree.root);
        System.out.println("删除4");
        System.out.println(remove(4));

    }
}

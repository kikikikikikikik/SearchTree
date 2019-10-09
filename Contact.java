/**
 * @ClassName Contact
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/10/8  19:26
 * @Veresion 1.0
 */
public class Contact {
    public static class Node{
        String name;
        String phone;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }
    }
    private Node root=null;
    public boolean insert(String name,String phone){
        Node cur=root;
        Node parent=null;
        int r=name.compareTo(cur.name);
       if(root==null){
           root=new Node(name);
           return true;
       }
       while(cur!=null){

           if(r==0){
               return false;
           }
           else if(r<0){
               parent=cur;
               cur=cur.left;
           }
           else{
               parent=cur;
               cur=cur.right;
           }
       }
       Node node=new Node(name);
       if(r>0){
           parent.right=node;
       }
       else{
           parent.left=node;
       }
       return true;
    }
    public String update(String name,String phone){
        Node cur=root;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                String oldPhone=cur.phone;
                cur.phone=phone;
                return oldPhone;
            }
            else if(r<0){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        return null;
    }
    public String search(String name){
        Node cur=root;
        while(cur!=null){
            int r=name.compareTo(cur.name);
            if(r==0){
                return cur.phone;
            }
            else if(r<0){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        return null;
    }
}

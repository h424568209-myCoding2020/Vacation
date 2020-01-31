import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day14 {
  static   class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    TreeNode root = null;
    public  TreeNode buildTree(){
    root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
     TreeNode n2 = new TreeNode(2);
     TreeNode n3 = new TreeNode(3);
     TreeNode n4 = new TreeNode(4);
     TreeNode n5 = new TreeNode(5);
     TreeNode n6 = new TreeNode(6);
     TreeNode n7 = new TreeNode(7);
     TreeNode n8 = new TreeNode(8);
     TreeNode n9 = new TreeNode(9);
     root.left = n1;
     root.right = n2;
     n1.left = n3;
     n1.right = n4;
     n2.left = n5;
     n2.right = n6;
     n3.left = n7;
     n3.right = n8;
     n6.left = n9;
     return  root;
 }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if(root == null){
            return list;
        }
        while(!queue.isEmpty()){
            int count  = queue.size();
            while(count>0){
                TreeNode tmp = queue.poll();
                count--;
                if(count == 0){
                    list.add(tmp.val);
                }
                if(root.left !=null){
                    queue.offer(root.left);
                }
                if(root.right !=null){
                    queue.offer(root.right);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Day14 d = new Day14();
        TreeNode root = d.buildTree();
        System.out.println(root);

        System.out.println(d.rightSideView(root));
    }
}

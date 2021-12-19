import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_11_1_Depth_First_Search {
    public static void main(String[] args) {
        TreeNode parent = new TreeNode(' ', "", "");
        String[] words = {"Hello", "How", "Are", "You", "Howwe"};
        for (String word : words) {
            addNode(parent, word);
        }
        System.out.println(parent);

        printNode_dfs(parent);
        System.out.println("");
        
        printNode_bfs(parent);

        dfsSearchByStack(parent);
    }

    public static void addNode(TreeNode node, String word) {
        for (char w : word.toCharArray()) {
            node = createTreeNode(node, w);
        }
    }

    public static TreeNode createTreeNode(TreeNode node, char w) {
        TreeNode found = null;
        if (node.sons.containsKey(w)) {
            // Found
            found = node.sons.get(w);
        } else {
            TreeNode son = new TreeNode(w, "", "");
            node.sons.put(w, son);
            found = son;
        }

        return found;
    }

    public static void printNode_dfs (TreeNode node) {
        if (node.sons.size() == 0) {
            System.out.println("");
            return;
        }

        node.sons.forEach((k, v) -> {
            printNode_dfs(v);
            System.out.print(k);
        });
    }

    public static void printNode_bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        // HashSet<Character> visited = new HashSet<>();

        queue.offer(node);
        System.out.print(node.label);

        while(!queue.isEmpty()) {
            TreeNode current_node = queue.poll();
            Iterator<java.util.Map.Entry<Character, TreeNode>> iter 
                    = current_node.sons.entrySet().iterator();
            
            while(iter.hasNext()) {
                TreeNode child = iter.next().getValue();
                queue.offer(child);
                System.out.print(child.label + " ");
            }
            //System.out.println("");
        }
    }

    public static void dfsSearchByStack(TreeNode parent) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(parent);

        while(!stk.isEmpty()) {
            TreeNode node = stk.pop();
            // System.out.println(node.label);

            if (node.sons.size() == 0) {
                // ここはいらない
                // return;
            } else {
                Iterator<java.util.Map.Entry<Character, TreeNode>> iter 
                    = node.sons.entrySet().iterator();

                Stack<TreeNode> tmpStk = new Stack<TreeNode>();
                while(iter.hasNext()) {
                    tmpStk.push(iter.next().getValue());
                }
                while(!tmpStk.isEmpty()) {
                    stk.push(tmpStk.pop());
                }
            }
        }
    }
}


class TreeNode {
    // 子节点,Hash映射存放子节点， 方便确认是否添加过某个字母腿影的子节点
    public HashMap<Character, TreeNode> sons = null;
    // 接点的名称在前缀树里是单个字母
    public char label;
    // 从树的根到当前节点的这条通路上，全部字母所组成的前缀
    public String prefix;
    // 词条个解释
    public String explanation;

    // 初始化节点
    public TreeNode(char l, String pref, String expl) {
        sons = new HashMap<>();
        label = l;
        prefix = pref;
        explanation = expl;
    }
}
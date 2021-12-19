import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class L_13_1_Breadth_First_Search {
    public static void main(String[] args) {
        
    }

    public static void bfs(Node[] nodes, int user_id) {

    }

    public static void createRandomReleationShip(int length) {
        Node[] nodes = new Node[length];

        //　生成所有用户节点
        for (int i = 0; i < length; i++) {
            nodes[i] = new Node(i);
        }

        // 为所有用户节点生成边
        for (int i = 0; i < 3; i++) {
            // 随机生成两个用户ID准备互相添加好友
            int friend_a_id = new Random().nextInt(length);
            int friend_b_id = new Random().nextInt(length);

            // 自己不能添加自己为好友， 略过
            if (friend_a_id == friend_b_id) continue;

            // 互相添加好友
            Node friend_a = nodes[friend_a_id];
            Node friend_b = nodes[friend_b_id];
            friend_a.firends.add(friend_b_id);
            friend_b.firends.add(friend_a_id);
        }
    }
}

class Node {
    public int user_id; // 节点名称
    public HashSet<Integer> firends = null; // 使用Hash映射存放相连的好友节点，Hash便于确认和某个用户是否相连
    public int degree; // 用于存放和给定用户节点是几度好友

    public Node(int user_id) {
        this.user_id = user_id;
        this.firends = new HashSet<>();
        this.degree = 0;
    }
}
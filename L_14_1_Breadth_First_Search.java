import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 双向广度优先搜索
 */
public class L_14_1_Breadth_First_Search {
    public static void main(String[] args) {
        Node[] nodes = createRandomRelationShip(10);

        System.out.println(bi_bfs(nodes, 2, 3)); 
    }

    /**
     * @Description: 通过双向广度优先搜索，查找两人之间最短通路的长度
     * @param user_nodes-用户的结点
     * @param user_id_a-用户a的ID
     * @param user_id_b-用户b的ID 
     * @return void
     */
    public static int bi_bfs(Node[] user_nodes, int user_id_a, int user_id_b) {
        // 边界值判断
        if (user_id_a > user_nodes.length || user_id_b > user_nodes.length) return -1;
        if (user_id_a == user_id_b) return 0;

        Queue<Integer> queue_a = new LinkedList<>();
        Queue<Integer> queue_b = new LinkedList<>();
        HashSet<Integer> visited_a = new HashSet<>();
        HashSet<Integer> visited_b = new HashSet<>();

        queue_a.offer(user_id_a);
        visited_a.add(user_id_a);
        queue_b.offer(user_id_b);
        visited_b.add(user_id_b);

        int degree_a = 0, degree_b = 0, max_degree = 20;

        while (degree_a + degree_b < max_degree) {
            degree_a++;
            getNextDegreeFriend(user_nodes, user_id_a, queue_a, visited_a, degree_a);
            if (hasOverlap(visited_a, visited_b)) return degree_a + degree_b;

            degree_b++;
            getNextDegreeFriend(user_nodes, user_id_b, queue_b, visited_b, degree_b);
            if (hasOverlap(visited_a, visited_b)) return degree_a + degree_b;
        }

        return -1;
    }

    public static void getNextDegreeFriend(Node[] user_nodes, int user_id, Queue<Integer> queue, HashSet<Integer> visited_id, int degree) {
        while(!queue.isEmpty()) {
            int current_user_id = queue.poll();

            if (user_nodes[current_user_id] == null) continue;

            for (int friend_user_id : user_nodes[current_user_id].firends) {

                if (user_nodes[friend_user_id] == null) continue;
                if (visited_id.contains(friend_user_id)) continue;

                if (user_nodes[current_user_id].degree + 1 > degree) continue;

                user_nodes[friend_user_id].degree = user_nodes[current_user_id].degree + 1;

                queue.offer(friend_user_id);
                visited_id.add(friend_user_id);

                System.out.println(String.format("\t目标用户：%d %d度好友：%d", user_id, user_nodes[friend_user_id].degree, friend_user_id));
            }
        }
    }

    public static boolean hasOverlap(HashSet<Integer> visited_a, HashSet<Integer> visited_b) {
        boolean ret = false;

        for (Integer item : visited_a) {
            if (visited_b.contains(item)) {
                ret = true;
                break;
            }
        }

        return ret;
    }


    public static Node[] createRandomRelationShip(int length) {
        Node[] nodes = new Node[length];

        // 生成所有用户节点
        for (int i=0; i<length; i++) {
            nodes[i] = new Node(i);
        }

        // 随机生成用户的边,并且互相添加好友
        for (int i=0; i < length * 2; i++) {
            int friend_ship_a = new Random().nextInt(length);
            int friend_ship_b = new Random().nextInt(length);

            if (friend_ship_a == friend_ship_b) continue;

            Node friend_a = nodes[friend_ship_a];
            Node friend_b = nodes[friend_ship_b];

            friend_a.firends.add(friend_ship_b);
            friend_b.firends.add(friend_ship_a);
        }

        return nodes;
    }
}

class Node {
    public int user_id; // 节点名称
    public HashSet<Integer> firends = null; // 使用Hash映射存放相连的好友节点，Hash便于确认和某个用户是否相连
    public int degree; // 用于存放和给定用户节点是几度好友
    public HashMap<Integer, Integer> degrees; // 存放从不同用户出发，当前用户结点是第几度

    public Node(int user_id) {
        this.user_id = user_id;
        this.firends = new HashSet<>();
        this.degree = 0;
        this.degrees = new HashMap<>();
        degrees.put(user_id, 0);
    }
}
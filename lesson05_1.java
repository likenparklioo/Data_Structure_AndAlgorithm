import java.lang.reflect.Array;
import java.util.ArrayList;

public class lesson05_1 {
    static int[] moneyLlist = {1, 2, 5, 10};

    public static void main(String[] args) {
        System.out.println("hello");
        get(10, new ArrayList<>());
    }

    private static void get(int totalReward, ArrayList<Integer> result) {
        if (totalReward == 0) {
            System.out.println(result);
            return;
        } else if (totalReward < 0) {
            return;
        } else {
            for (int money : moneyLlist) {
               // totalReward = totalReward - money;
               int _totalReward = totalReward - money;
               // result.add(money);
               ArrayList<Integer> newResult =  (ArrayList<Integer>)(result.clone());
               newResult.add(money);
               get(_totalReward, newResult);
            }
        }
    }
}
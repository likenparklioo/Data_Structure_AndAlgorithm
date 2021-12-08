import java.util.ArrayList;

public class L_05_1_Recursion {
    static int[] moneyLlist = { 1, 2, 5, 10 };

    public static void main(String[] args) {
        get(10, new ArrayList<>());
    }

    /**
     * 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合 
     * 
     * @param totalReward-奖赏总金额，result-保存当前的解 
     * @return void
     */
    @SuppressWarnings("unchecked")
    private static void get(int totalReward, ArrayList<Integer> result) {
        if (totalReward == 0) {
            System.out.println(result);
            // 满足条件 递归结束
            return;
        } else if (totalReward < 0) {
            // 不满足条件 不输出
            return;
        } else {
            for (int money : moneyLlist) {
                try {
                    // totalReward = totalReward - money;
                    int _totalReward = totalReward - money;
                    // result.add(money);
                    ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                    newResult.add(money);
                    get(_totalReward, newResult);
                } catch (Exception e) {
                    System.out.println("conver error:" + e);
                }
            }
        }
    }
}
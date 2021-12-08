import java.util.ArrayList;
import java.util.Arrays;

// 排列arrangement
// 组合combination

public class L_08_1_Combination {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
        combine(teams, new ArrayList<>(), 2);
    }

    /**
     * 使用函数的递归（嵌套）调用，找出所有可能的队伍组合
     * @param teams-目前还剩多少队伍没有参与组合
     * @param result-保存当前已经组合的队伍
     * @return void 
     */
    @SuppressWarnings("unchecked")
    public static void combine(ArrayList<String> teams, ArrayList<String> result, int length) {
        // 挑选完了m个元素，输出结果
        if (result.size() == length) {
            System.out.println(result);
            return;
        }

        int _index = 0;
        for (String team : teams) {
            // 从剩下的队伍中，选择一队，加入结果
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            new_result.add(team);

            // 只考虑当前选择之后的所有队伍
            ArrayList<String> new_teams = new ArrayList<>(teams.subList(_index + 1, teams.size()));

            // 递归调用，对于剩余的队伍继续生成组合
            combine(new_teams, new_result, length);
            
            _index++;
        }
    }
}

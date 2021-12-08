import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 排列arrangement
// 组合combination

public class L_07_1_Arrangement {
    private static final HashMap<String, Double> t_horeses_times = new HashMap<>(){
      {
        put("t1", 1.5);
        put("t2", 2.5);
        put("t3", 3.5);
      }
    };

    private static final HashMap<String, Double> q_horeses_times = new HashMap<>(){
        {
          put("q1", 2D);
          put("q2", 3D);
          put("q3", 4D);
        }
      };

    private static final ArrayList<String> q_horeses = new ArrayList<>(Arrays.asList("q1", "q2", "q3"));
    
    public static void main(String[] args) {
        ArrayList<String> horeses = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
        ArrayList<String> result = new ArrayList<>();
        permutate(horeses, result);
    }

    /** 
     * 使用函数的递归（嵌套）调用，找出所有可能的马匹出战顺序
     * @param horses-目前还剩多少马没有出战，result-保存当前已经出战的马匹及顺序 
     * @return void 
     */
    @SuppressWarnings("unchecked")
    public static void permutate(ArrayList<String> horeses, ArrayList<String> result) {
        // 所有马匹都已经出战，判断哪方获胜，输出结果
        if (horeses.size() == 0) {
            System.out.println(result);
            compare(result);
            return;
        }

        for (String horese : horeses) {
            // 从剩下的未出战马匹中，选择一匹，加入结果
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            new_result.add(horese);

            // 将已选择的马匹从未出战的列表中移出
            ArrayList<String> new_horeses = (ArrayList<String>) horeses.clone();
            new_horeses.remove(horese);

            // 递归调用，对于剩余的马匹继续生成排列
            permutate(new_horeses, new_result);
        }
    }

    public static void compare(ArrayList<String> result) {
        int t_win_count = 0;
        int _index = 0;
        for (String ret : result) {
            if (t_horeses_times.get(ret) > q_horeses_times.get(q_horeses.get(_index))) t_win_count++;
            _index++;
        }
        if (t_win_count >= 2) {
            System.out.println("t horese win!!");
        }
    }
}

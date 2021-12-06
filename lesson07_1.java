import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lesson07_1 {
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

    public static void permutate(ArrayList<String> horeses, ArrayList<String> result) {
        if (horeses.size() == 0) {
            System.out.println(result);
            // TODO: compare
            compare(result);
            return;
        }

        for (String horese : horeses) {
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            ArrayList<String> new_horeses = (ArrayList<String>) horeses.clone();

            new_result.add(horese);
            new_horeses.remove(horese);

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

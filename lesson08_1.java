import java.util.ArrayList;
import java.util.Arrays;

public class lesson08_1 {

    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
        combine(teams, new ArrayList<>(), 2);
    }

    public static void combine(ArrayList<String> teams, ArrayList<String> result, int length) {
        if (result.size() >= length) {
            System.out.println(result);
            return;
        }

        int _index = 0;
        for (String team : teams) {
            ArrayList<String> new_teams = new ArrayList<>(teams.subList(_index + 1, teams.size()));
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            
            new_result.add(team);

            combine(new_teams, new_result, length);
            
            _index++;
        }
    }
}

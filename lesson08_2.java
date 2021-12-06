import java.util.ArrayList;
import java.util.HashMap;

public class lesson08_2 {
    public static HashMap<Integer, Integer> lucky_level_count = new HashMap<>() {
        {
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }
    };
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        for (int i=0; i<10; i++) {
            peoples.add("people_" + i);
        }
        lucky03(peoples, new ArrayList<>(), 3);
    }

    public static void lucky03 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel) {
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + luckyLevel + result);

            ArrayList<String> new_peoples  = (ArrayList<String>) peoples.clone();
            ArrayList<String> new_result  = (ArrayList<String>) result.clone();
            lucky02(new_peoples, new ArrayList<>(), 2);

            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));
            ArrayList<String> new_result  = (ArrayList<String>) result.clone();

            new_result.add(peoples.get(i));

            lucky03(new_peoples, new_result, luckyLevel);
        }
    }

    public static void lucky02 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel) {
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + luckyLevel + result);

            ArrayList<String> new_peoples  = (ArrayList<String>) peoples.clone();
            ArrayList<String> new_result  = (ArrayList<String>) result.clone();
            lucky01(new_peoples, new ArrayList<>(), 1);

            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));
            ArrayList<String> new_result  = (ArrayList<String>) result.clone();

            new_result.add(peoples.get(i));

            lucky02(new_peoples, new_result, luckyLevel);
        }
    }

    public static void lucky01 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel) {
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + luckyLevel + result);
            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));
            ArrayList<String> new_result  = (ArrayList<String>) result.clone();

            new_result.add(peoples.get(i));

            lucky01(new_peoples, new_result, luckyLevel);
        }
    }
}

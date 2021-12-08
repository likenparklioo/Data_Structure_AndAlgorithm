import java.util.ArrayList;
import java.util.HashMap;

// 排列arrangement
// 组合combination

public class L_08_2_Combination {
    private static final int maxLucky1 = 1;
    private static final int maxLucky2 = 3;
    private static final int maxLucky3 = 10;

    /**
     * LuckLevel, LuckCount
     */
    public static HashMap<Integer, Integer> lucky_level_count = new HashMap<>() {
        {
            put(1, maxLucky1);
            put(2, maxLucky2);
            put(3, maxLucky3);
        }
    };

    private static ArrayList<String> _peoples = new ArrayList<>();

    /**
     * 假设现在需要设计一个抽奖系统。需要依次从 100 个人中，抽取三等奖 10 名，二等奖 3 名和一等奖 1 名。请列出所有可能的组合，需要注意的每人最多只能被抽中 1 次。
     */
    public static void main(String[] args) {
        for (int i=0; i < 15; i++) {
            _peoples.add("people_" + i);
        }
        lucky03(_peoples, new ArrayList<>(), 3);
    }

    @SuppressWarnings("unchecked")
    public static void lucky03 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel) {
        
        if (luckyLevel == 0) {
            return;
        }
        
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + "_" + luckyLevel + "_" + result);

            // System.out.println("lucky" + "_" + luckyLevel + "_" + result  + "_" + _new_peoples + "_" + _new_result + "_" + newlevel );
            ArrayList<String> new_lucky_result  = (ArrayList<String>) result.clone();
            lucky02(_peoples,  new ArrayList<>(), 2, new_lucky_result);
            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));

            ArrayList<String> new_result  = (ArrayList<String>) result.clone();
            new_result.add(peoples.get(i));

            lucky03(new_peoples, new_result, luckyLevel);
        }
    }

    @SuppressWarnings("unchecked")
    public static void lucky02 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel, ArrayList<String> luckyResult) {
        
        if (luckyLevel == 0) {
            return;
        }
        
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + "_" + luckyLevel + "_" + result);
            ArrayList<String> new_lucky_result  = (ArrayList<String>) result.clone();
            new_lucky_result.addAll(luckyResult);
            lucky01(_peoples,  new ArrayList<>(), 1, new_lucky_result);
            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            boolean isExist = false;
            for (int j = 0; j < luckyResult.size(); j++) {
                if (peoples.get(i) == luckyResult.get(j)) isExist = true;
            }
            if (isExist) {
                continue;
            }
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));

            ArrayList<String> new_result  = (ArrayList<String>) result.clone();
            new_result.add(peoples.get(i));

            lucky02(new_peoples, new_result, luckyLevel, luckyResult);
        }
    }

    @SuppressWarnings("unchecked")
    public static void lucky01 (ArrayList<String> peoples, ArrayList<String> result, int luckyLevel, ArrayList<String> luckyResult) {
        
        if (luckyLevel == 0) {
            return;
        }
        
        if (result.size() == lucky_level_count.get(luckyLevel)) {
            System.out.println("lucky" + "_" + luckyLevel + "_" + result);

            return;
        }

        for (int i = 0; i < peoples.size(); i++) {
            boolean isExist = false;
            for (int j = 0; j < luckyResult.size(); j++) {
                if (peoples.get(i) == luckyResult.get(j)) isExist = true;
            }
            if (isExist) {
                continue;
            }
            ArrayList<String> new_peoples = new ArrayList<>(peoples.subList(i + 1, peoples.size()));

            ArrayList<String> new_result  = (ArrayList<String>) result.clone();
            new_result.add(peoples.get(i));

            lucky01(new_peoples, new_result, luckyLevel, luckyResult);
        }
    }
}

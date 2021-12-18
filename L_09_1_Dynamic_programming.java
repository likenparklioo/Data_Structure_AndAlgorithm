class L_09_1_Dynamic_programming {
    public static void main(String[] args) {
        String a = "mouse";
        String b = "se";
        
        int dist = getStrDistance(a, b);

        System.out.println(a + "<->" + b + ":" + dist);

        int combCount = getMinCombination(100, new int[] {2, 3, 7});

        System.out.println("min comb count :" + combCount);
    }

    /** 
     * 使用状态转移方程，计算两个字符串之间的编辑距离 
     * @param a-第一个字符串，b-第二个字符串 
     * @return int-两者之间的编辑距离 
     */
    public static int getStrDistance(String a, String b) {
        int ret = -1;

        if (a == null || b == null) return ret;

        // 初始用于记录化状态转移的二维表
        int[][] distanceTable = new int[a.length() + 1][b.length() + 1];

        // 如果i大于等于0，且j为0，那么distanceTable[i, j]为i
        for (int i = 0 ; i < a.length() + 1 ; i++) {
            distanceTable[i][0] = i;
        }

        // 如果i为0，且j大于等于0，那么distanceTable[i, j]为j
        for (int j = 0 ; j < b.length() + 1 ; j++) {
            distanceTable[0][j] = j;
        }

        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j< b.length() + 1; j++) {
                int rep = distanceTable[i-1][j-1];
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    rep += 1; 
                }
                
                int append_A = distanceTable[i-1][j] + 1;
                int append_B = distanceTable[i][j-1] + 1; 

                int min_step = Math.min(rep, (Math.min(append_A, append_B)));

                distanceTable[i][j] = min_step;
            }
        }

        for (int i = 0; i< distanceTable.length; i++) {
            for (int j = 0; j < distanceTable[0].length; j++) {
                System.out.print(distanceTable[i][j]);
            }
            System.out.println();
        }

        return distanceTable[a.length()][b.length()];
    }

    /** 
     * 钱币组合的新问题
     * 给定总金额和面值种类，求钱币最少的组合
     * @param total
     * @return 钱币数
     */
    public static int getMinCombination(int total, int[] arrayCurrency) {
        if (total <= 0 || arrayCurrency.length == 0) return -1;

        int[] minCombList = new int[total];
        for (int i = 0; i < total; i++) {
            minCombList[i] = -1;
        }

        for (int i = 0; i < total; i++) {
            
            int min = -1;
            for(int j=0; j < arrayCurrency.length; j++) {
                int _combCount = -1;

                int diff = i + 1 - arrayCurrency[j];
                
                if (diff == 0) {
                    _combCount = 1;
                }

                if (diff > 0) {
                    if (minCombList[diff - 1] != -1) {
                        _combCount = minCombList[diff - 1] + 1;
                    }
                }

                if (_combCount != -1) {
                    if (min == -1) {
                        min = _combCount;
                    } else {
                        if (_combCount < min) {
                            min = _combCount;
                        }   
                    }
                }
            }
            minCombList[i] = min;
        }

        for (int item : minCombList) {
            System.out.println(item);
        }
        return minCombList[total - 1];
    }
}
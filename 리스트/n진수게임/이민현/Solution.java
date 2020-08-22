class Solution {
    private static final String[] NumString = {
      "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    };

    public String solution(int n, int t, int m, int p) {
        int curNum = 0;
        String curNumToString = "";

        int repeatCount = ((t - 1) * m) + p;

        String answer = "";
        if(p == m) p = 0;

        for(int i = 1; i <= repeatCount; ) {
            curNumToString = parse(n, curNum);
            for (int j = 0; j < curNumToString.length(); j++) {
                if(i > repeatCount) {
                    break;
                }

                if(i % m == p) {
                    answer += curNumToString.charAt(j);
                }
                i++;
            }
            curNum++;
        }

        return answer;
    }

    public String parse(int numaric, int value) {
        String valueToString = "";

        while (value >= numaric) {
            valueToString += NumString[value % numaric];
            value = value / numaric;
        }

        valueToString += NumString[value % numaric];

        return new StringBuilder(valueToString).reverse().toString();
    }
}
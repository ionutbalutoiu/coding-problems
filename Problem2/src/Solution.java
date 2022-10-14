import java.util.Random;

class Solution {
    private int groupSize(int N) {
        if (N <= 26) {
            return 1;
        }
        int i = 26;
        for (; i > 1; i--) {
            if (N % i == 0) {
                break;
            }
        }
        return N / i;
    }

    public String solution(int N) {
        Random random = new Random();
        StringBuilder abc = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder word = new StringBuilder();
        int groupSize = groupSize(N);

        while (word.length() < N) {
            int index = random.nextInt(abc.length());
            for(int i = 0; i < groupSize; i++) {
                word.append(abc.charAt(index));
            }
            abc.deleteCharAt(index);
        }

        return word.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(27));
        // System.out.println(sol.solution(200000));
    }
}

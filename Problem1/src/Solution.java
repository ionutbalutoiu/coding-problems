class Solution {
    public void solution(int N) {
        char l = 'L';
        StringBuilder w = new StringBuilder();

        for (int i = 1; i < N; i++) {
            w.append(l);
            System.out.println(l);
        }

        w.append(l);
        System.out.println(w);
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.solution(6);
    }
}

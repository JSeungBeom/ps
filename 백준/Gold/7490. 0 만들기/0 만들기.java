import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int T, N;
    static int[] num;
    static char[] ops = new char[] { ' ', '+', '-' }; // 출력 순서 맞춤: 공백 -> + -> -
    static char[] arr; // 길이 N-1 (두 숫자 사이의 연산자)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            num = new int[N];
            arr = new char[N - 1];

            for (int i = 0; i < N; i++) num[i] = i + 1;

            dfs(0, out);

            if (tc != T - 1) out.append('\n'); // 테스트 케이스 사이 빈 줄
        }

        System.out.print(out.toString());
    }

    // n: 현재 채울 연산자 인덱스 (0..N-2)
    static void dfs(int n, StringBuilder out) {
        if (n == N - 1) {
            if (evaluateIsZero()) {
                // 식을 그대로 출력 (숫자와 연산자/공백)
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N - 1; i++) {
                    sb.append(num[i]).append(arr[i]);
                }
                sb.append(num[N - 1]);
                out.append(sb).append('\n');
            }
            return;
        }

        for (char op : ops) {
            arr[n] = op;
            dfs(n + 1, out);
        }
    }

    // 공백은 이어 붙이기, +/− 는 계산
    static boolean evaluateIsZero() {
        long sum = 0;
        long cur = num[0];  // 현재 누적 숫자 (공백 처리로 이어붙인 값)
        char prevOp = '+';  // 직전 연산자 (cur을 sum에 반영할 때 사용)

        // arr[i]는 num[i]와 num[i+1] 사이의 연산자
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == ' ') {
                // 이어 붙이기
                cur = cur * 10 + num[i + 1];
            } else {
                // 이전 연산자로 cur을 sum에 반영
                if (prevOp == '+') sum += cur;
                else sum -= cur;

                // 새 토큰 시작
                prevOp = arr[i];
                cur = num[i + 1];
            }
        }

        // 마지막 토큰 반영
        if (prevOp == '+') sum += cur;
        else sum -= cur;

        return sum == 0;
    }
}

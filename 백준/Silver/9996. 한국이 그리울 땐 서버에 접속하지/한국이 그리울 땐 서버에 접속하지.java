import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String[] parts = pattern.split("\\*");
        String front = parts[0];
        String back = parts[1];

        for (int i = 0; i < N; i++) {
            String file = br.readLine();

            if (file.length() < front.length() + back.length()) {
                System.out.println("NE");
                continue;
            }

            boolean ok = file.startsWith(front) && file.endsWith(back);
            System.out.println(ok ? "DA" : "NE");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_repeat {
    public static void main(String[] args) throws IOException {

       /* 문제 - 문자열 반복
        문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
        즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
        S에는 QR Code "alphanumeric" 문자만 들어있다.

        QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

        입력
        첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8),
        문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

        출력
        각 테스트 케이스에 대해 P를 출력한다. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("테스트 케이스 개수를 입력한 후 Enter");

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 1; i <= t; i++){
            String total = br.readLine();  // 반복 횟수와 문자열을 입력받는데
            StringTokenizer st = new StringTokenizer(total); // 스트링 토크나이저로 자른다.

            int r = Integer.parseInt(st.nextToken()); // 반복횟수
            String s = st.nextToken();  // 반복할 문자열

            for (int j = 0; j < s.length(); j++){ // 문자열 길이만큼
                for (int k = 0; k < r; k++){    // 반복횟수만큼
                    System.out.print(s.charAt(j));  // 문자열0번부터 출력
                }
            }
            System.out.println();

        }

    }

}

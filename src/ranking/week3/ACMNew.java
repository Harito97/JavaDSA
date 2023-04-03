package DataStructureAndAlgorithms.AssignmentLT.spoj.week3;

import java.io.DataInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
//import java.util.Scanner;

public class ACMNew {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
  
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (neg)
                return -ret;
            return ret;
        }
    }
    public static void main(String[] args) throws IOException {
        Instant start = Instant.now();
        //Scanner sc = new Scanner("2 4 40 50 60 80 160 5 50 70 60 80 75 200");
        Reader sc = new Reader();
        StringBuilder builder = new StringBuilder();
        int t = sc.nextInt();
        int n, M;
        int[] array;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            M = sc.nextInt();
            Arrays.sort(array);
            builder.append(maxWeightOfTeam(array, M)).append("\n");
        }
        System.out.print(builder.toString());
        //sc.close();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    public static int maxWeightOfTeam(int[] array, int M) {
        int length = array.length;
        int sumMaxWeightOfTeam = 0;
        for (int i = length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    sumMaxWeightOfTeam = array[i] + array[j] + array[k];
                    if (sumMaxWeightOfTeam <= M) {
                        return sumMaxWeightOfTeam;
                    }
                }
            }
        }
        return -1;
    }
}

/** Đề bài
 * 
Cải tiến ACM/ICPC

Hiện nay trong thi ACM/ICPC có nhiều dư luận bàn tán về các thí sinh. Nhiều người cho rằng các thí sinh tuy giỏi lập trình thật nhưng bề ngoài nhìn không khỏe mạnh, những người thi thường gầy gò, ốm yếu. Đứng trước dư luận như vậy, ban tổ chức ACM/ICPC quyết định cải tiến việc tham gia thi. Khi xét giải, ngoài kết quả lập trình tốt, ban tổ chức còn xét đến tổng cân nặng của các thành viên đội dự thi. Hiện nay, trình độ lập trình của các đội dự thi cũng ngang ngữa nhau, do đó, đội nào có tổng cân nặng của các thành viên lớn hơn sẽ có cơ hội thắng lớn hơn. Tuy nhiên, để công bằng cho các đội dự thi, ban tổ chức đưa ra một ngưỡng cân nặng, theo đó, tổng cân nặng của các thành viên một đội không được vượt quá ngưỡng này.

Với thể lệ xét giải mới này thì huấn luyện viên các trường dự thi cũng phải thay đổi lại cách lựa chọn thành viên của đội trường mình. Với một danh sách các ứng viên, huấn luyện viên sẽ chọn ra ba người có tổng trọng lượng lớn nhất mà không vượt quá ngưỡng ban tổ chức quy định. Hãy lập trình giúp huấn luyện viên các trường lựa chọn.

Biết rằng, mỗi đội tuyển ACM/ICPC gồm đúng 3 thành viên.

Input

Dữ liệu vào từ luồng nhập chuẩn: Dòng đầu tiên chứa số nguyên T là tổng số tests (0<T<10). Sau đó là T bộ test lần lượt trên các dòng. Mỗi bộ test gồm 3 dòng, dòng thứ nhất chứa số nguyên dương N (3<N<20) là tổng số ứng viên của một một trường dự thi, dòng thứ hai gồm N số nguyên dương a1, a2,…, aN (40<=ai<=80) ngăn cách bởi các dấu cách là cân nặng của các ứng viên; dòng thứ ba là ngưỡng cân nặng M (1<M<240).

Output

Với mỗi bộ test, đưa ra trên một dòng tổng số cân nặng lớn nhất có thể của đội tuyển của trường tương ứng.

Dữ liệu input đảm bảo luôn có kết quả lựa chọn đội tuyển.

Ví dụ:

Input

2

4

40 50 60 80

160

5

50 70 60 80 75

200

 

Output

150

200
 * 
 */
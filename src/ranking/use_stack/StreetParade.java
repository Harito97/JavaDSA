package ranking.use_stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        while (n != 0) {
            String[] trucksStr = reader.readLine().split(" ");
            int[] trucks = new int[n];
            for (int i = 0; i < n; i++) {
                trucks[i] = Integer.parseInt(trucksStr[i]);
            }
            writer.write(canBeReordered(trucks) ? "yes\n" : "no\n");
            n = Integer.parseInt(reader.readLine());
        }
        writer.flush();
    }

    public static boolean canBeReordered(int[] trucks) {
        Stack<Integer> sideStreet = new Stack<>();
        int currentTruck = 1;
        // check all truck step by step
        for (int truck : trucks) {
            // if the top of side street have the current truck then 
            // trans that truck to sorted part and current truck be the next
            while (!sideStreet.empty() && sideStreet.peek() == currentTruck) {
                sideStreet.pop();
                currentTruck++;
            }
            // if truck is checking is sorted (= current truck) then
            // trans it to sorted part and current truck be the next
            if (truck == currentTruck) {
                currentTruck++;
            } else {
                // is truck is checking is not sorted yet then 
                // push it to the side street and check the next truck
                sideStreet.push(truck);
            }
        }
        // now we may be still have some struck in side street
        // we will check is it sorted increasing step by 1 from top of side street to the end of it
        while (!sideStreet.empty() && sideStreet.peek() == currentTruck) {
            sideStreet.pop();
            currentTruck++;
        }
        // now if trucks can be soft then it should be all in sorted part
        // if not then trucks can't be sorted increasing
        return sideStreet.empty();
    }
}

/*
 * STPAR - Diễu Hành Đường Phố
 * 
 * Chắc chắn những chú dế yêu sẽ lại tung hoành trên đường phố mùa hè này. Mỗi
 * năm, ban tổ chức quyết định một đơn đặt hàng cố định cho những chiếc xe tải
 * được trang trí. Kinh nghiệm đã dạy họ phải để trống một bên đường để có thể
 * đưa xe tải vào trật tự.
 * 
 * Con đường bên cạnh hẹp đến nỗi hai chiếc xe không thể vượt qua nhau. Vì vậy,
 * tình yêu di động đi vào đường nhánh cuối cùng nhất thiết phải rời khỏi đường
 * nhánh trước. Vì xe tải và xe cào cào di chuyển sát nhau nên xe tải không thể
 * lùi lại và đi vào lại đường bên hoặc đường tiếp cận.
 * 
 * Bạn được cung cấp thứ tự mà điện thoại di động tình yêu đến. Viết một chương
 * trình quyết định xem những chiếc điện thoại di động tình yêu có thể được sắp
 * xếp theo thứ tự mà ban tổ chức mong muốn hay không.
 * Đầu vào
 * 
 * Có một số trường hợp thử nghiệm. Dòng đầu tiên của mỗi test chứa một số duy
 * nhất n, số lượng điện thoại di động tình yêu. Dòng thứ hai ghi các số từ 1
 * đến n theo thứ tự tùy ý. Tất cả các số được phân tách bằng dấu cách đơn.
 * Những con số này cho biết thứ tự các xe tải đến đường tiếp cận. Không quá
 * 1000 xế yêu tham gia diễu hành trên đường phố. Đầu vào kết thúc bằng số 0.
 * đầu ra
 * 
 * Đối với mỗi trường hợp thử nghiệm, chương trình của bạn phải xuất ra một dòng
 * chứa một từ duy nhất " có " nếu điện thoại di động tình yêu có thể được sắp
 * xếp lại với sự trợ giúp của đường phố và một từ duy nhất " không " trong
 * trường hợp ngược lại.
 * Ví dụ
 * 
 * Đầu vào mẫu:
 * 5
 * 5 1 2 4 3
 * 0
 * 
 * Đầu ra mẫu:
 * yes
 */
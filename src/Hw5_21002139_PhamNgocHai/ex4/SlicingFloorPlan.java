package Hw5_21002139_PhamNgocHai.ex4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Node {
    public int type; // 0: horizontal cut, 1: vertical cut
    public int min_width;
    public int min_height;
    public int width;
    public int height;
    public Node left;
    public Node right;

    public Node(int type, int min_width, int min_height, Node left, Node right) {
        this.type = type;
        this.min_width = min_width;
        this.min_height = min_height;
        this.left = left;
        this.right = right;
        this.width = 0;
        this.height = 0;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}

/*
 * Đây là một chương trình Java giải quyết bài toán nén và vẽ kế hoạch cắt tầng.
 * Chương trình sử dụng đệ quy để duyệt cây cắt tầng và tính toán các thông số
 * của từng nút.
 */
public class SlicingFloorPlan extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int MARGIN = 50;

    private Node root;
    private List<String> labels;

    public SlicingFloorPlan(Node root, List<String> labels) {
        this.root = root;
        this.labels = labels;
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawNode(g, root, MARGIN, MARGIN, WIDTH - 2 * MARGIN, HEIGHT - 2 * MARGIN);
        }
    }

    private void drawNode(Graphics g, Node node, int x, int y, int w, int h) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);
        if (node.isLeaf()) {
            g.drawString(labels.get(labels.size() - 1), x + w / 2, y + h / 2);
            labels.remove(labels.size() - 1);
        } else {
            int x1 = node.type == 0 ? x : x + node.width;
            int y1 = node.type == 1 ? y : y + node.height;
            g.drawLine(x1, y1, x1, y1 + node.height);
            g.drawLine(x1, y1, x1 + node.width, y1);
            drawNode(g, node.left, x, y, node.type == 0 ? node.width : w, node.type == 1 ? node.height : h);
            drawNode(g, node.right, node.type == 0 ? x + node.width : x, node.type == 1 ? y + node.height : y,
                    node.type == 0 ? w - node.width : node.width, node.type == 1 ? h - node.height : node.height);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0, 100, 120, null, null);
        Node left = new Node(1, 60, 120, null, null);
        Node right = new Node(1, 40, 120, null, null);
        root.left = left;
        root.right = right;
        Node left1 = new Node(0, 60, 80, null, null);
        Node right1 = new Node(0, 40, 80, null, null);
        left.left = left1;
        left.right = right1;
        Node left2 = new Node(0, 20, 80, null, null);
        Node right2 = new Node(1, 40, 80, null, null);
        right.left = left2;
        right.right = right2;
        List<String> labels = new ArrayList<>();
        labels.add("A");
        labels.add("B");
        labels.add("C");
        labels.add("D");
        labels.add("E");
        labels.add("F");
        JFrame frame = new JFrame("Layer Cutting Plan");
        frame.add(new SlicingFloorPlan(root, labels));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

/*
 * Bên trong phương thức`main`, ta khởi tạo một cây cắt tầng mẫu và một danh
 * sách các nhãn tương ứng với các nút lá của cây. Sau đó, ta tạo một đối tượng
 * LayerCuttingPlan với cây và danh sách nhãn này và hiển thị nó trong một cửa
 * sổ JFrame.
 * 
 * Lớp SlicingFloorPlan kế thừa lớp JPanel để vẽ kế hoạch cắt tầng trên một bề
 * mặt đồ họa. Trong phương thức paintComponent, ta sử dụng đệ quy để vẽ từng
 * nút của cây cắt tầng. Đầu tiên, ta vẽ một hình chữ nhật trắng với kích thước
 * tương ứng với kích thước của nút. Sau đó, ta vẽ đường viền đen cho hình chữ
 * nhật đó. Nếu nút đang xét là nút lá, ta vẽ tên của lá ở giữa hình chữ nhật
 * đó. Nếu nút đang xét là nút nội bộ, ta tính toán vị trí và chiều dài của
 * đường cắt và tiếp tục vẽ các nút con của nút đó.
 */

 /*
 * Để thiết kế một cấu trúc dữ liệu cho kế hoạch cắt tầng, ta có thể sử dụng một
 * lớp đối tượng để đại diện cho một nút trong cây cắt tầng. Mỗi nút sẽ có các
 * thuộc tính như sau:
 * 
 * - `is_leaf`: một boolean để biết xem nút có phải là lá hay không.
 * - `cut_type`: một string để biết loại cắt của nút, có thể là "ngang" hoặc
 * "dọc".
 * - `min_width`: một integer để lưu chiều rộng tối thiểu của hình chữ nhật cơ
 * bản liên quan đến nút.
 * - `min_height`: một integer để lưu chiều cao tối thiểu của hình chữ nhật cơ
 * bản liên quan đến nút.
 * - `width`: một integer để lưu chiều rộng của hình chữ nhật được phân rã bởi
 * nút.
 * - `height`: một integer để lưu chiều cao của hình chữ nhật được phân rã bởi
 * nút.
 * - `left_child`: một tham chiếu tới nút con trái.
 * - `right_child`: một tham chiếu tới nút con phải.
 * 
 * Để tạo một kế hoạch cắt tầng bao gồm một hình chữ nhật cơ bản duy nhất, ta có
 * thể tạo một nút lá với `is_leaf = True` và các giá trị `min_width` và
 * `min_height` được cung cấp.
 * 
 * Để phân rã một hình chữ nhật cơ bản bằng một cắt ngang hoặc dọc, ta có thể
 * tạo một nút nội bộ với `is_leaf = False` và `cut_type` tương ứng. Sau đó, ta
 * gán `left_child` và `right_child` cho nút tương ứng với hai hình chữ nhật con
 * được phân rã bởi cắt.
 * 
 * Để gán chiều cao và chiều rộng tối thiểu cho một hình chữ nhật cơ bản, ta có
 * thể tìm kiếm cây cắt tầng liên quan đến hình chữ nhật cơ bản và gán giá trị
 * `min_width` và `min_height` cho nút lá tương ứng.
 * 
 * Để vẽ cây cắt tầng liên quan đến kế hoạch cắt tầng, ta có thể sử dụng thuật
 * toán đệ quy để duyệt cây theo thứ tự trước (preOrder) và vẽ từng nút theo thứ
 * tự đó. Khi vẽ một nút, ta vẽ hình chữ nhật được phân rã bởi nút và các cắt
 * liên quan đến nút con.
 * 
 * Để nén kế hoạch cắt tầng, ta có thể duyệt cây cắt tầng liên quan đến kế hoạch
 * cắt tầng theo thứ tự sau (postOrder):
 * 
 * - Nếu nút đang xét là lá, ta gán `width` và `height` của nút bằng `min_width`
 * và `min_height` tương ứng.
 * - Nếu nút đang xét là nút nội bộ, ta tính toán `width` và `height` của nút
 * dựa trên `width` và `height` của nút con trái và phải tương ứng với loại cắt
 * của nút.
 * 
 * Sau khi nén, ta có thể vẽ kế hoạch cắt tầng bằng cách duyệt cây cắt tầng theo
 * thứ tự trước (preOrder) và vẽ từng nút theo thứ tự đó. Khi vẽ một nút, ta vẽ
 * hình chữ nhật được phân rã bởi nút và các cắt liên quan đến nút. Nếu nút đang
 * xét là nút nội bộ, ta vẽ các đường cắt ở giữa hình chữ nhật. Nếu nút đang xét
 * là lá, ta thêm tên của lá vào hình chữ nhật.
 */

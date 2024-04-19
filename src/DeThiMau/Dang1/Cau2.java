package DeThiMau.Dang1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cau2 extends JFrame {
    public Cau2() {
        JFrame frame = new JFrame();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(10,10));
        pnMain.setBorder(new EmptyBorder(10, 30, 10, 30));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTieuDe = new JPanel();
        JLabel lblTieuDe = new JLabel("Tinh Tien Choi BIDA");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setForeground(Color.BLUE);
        pnTieuDe.add(lblTieuDe);
        pnMain.add(pnTieuDe, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.X_AXIS));
        pnMain.add(pnCenter, BorderLayout.CENTER);

        JPanel pnCenterLeft = new JPanel();
        TitledBorder border = new TitledBorder(new LineBorder(Color.BLUE, 3, true), "Thong Tin");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitleColor(Color.RED);
        pnCenterLeft.setBorder(border);
        pnCenterLeft.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblGioBatDau = new JLabel("Gio Bat Dau");
        JTextField txtGioBatDau = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        pnCenterLeft.add(lblGioBatDau, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        pnCenterLeft.add(txtGioBatDau, gbc);

        JLabel lblGioKetThuc = new JLabel("Gio Ket Thuc");
        JTextField txtGioKetThuc = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnCenterLeft.add(lblGioKetThuc, gbc);
        gbc.gridx = 1;
        pnCenterLeft.add(txtGioKetThuc, gbc);

        JLabel lblTienThanhToan = new JLabel("Tien Thanh Toan");
        JTextField txtTienThanhToan = new JTextField(15);
        txtTienThanhToan.setBackground(Color.CYAN);
        txtTienThanhToan.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pnCenterLeft.add(lblTienThanhToan, gbc);
        gbc.gridx = 1;
        pnCenterLeft.add(txtTienThanhToan, gbc);

        pnCenter.add(pnCenterLeft);

        JPanel pnCenterRight = new JPanel();
        pnCenterRight.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = GridBagConstraints.RELATIVE;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.insets = new Insets(5, 5, 5, 5);

        JButton btnThanhToan = new JButton("Thanh Toan");
        JButton btnLamMoi = new JButton("Lam Moi");
        JButton btnDong = new JButton("Dong");

        // Viểt code Java cho nút tính tiền: (3 điể m)
        // Nếu giờ kết thúc > giờ bắt đầu thì tính và xuất kết quả tiền thanh toán. Trong đó:
        // Tiền thanh toán = (giờ kết thúc – giờ bắt đầủ) * đơn giá. Đơn giá được tính theo qui cách sau:
        // Trước 10 giờ và từ sau 23 giờ là giờ nghĩ
        // Từ 10 giờ đến trước 17 giờ thì đơn giá cho 1 giờ là 20000 đồng
        // Từ 17 giờ đến 23 giờ thì đơn giá cho 1 giờ là 45000 đồng
        // Ngược lại thì thông báo “Giờ kết thúc phải > giờ bắt đầu”.

        btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double batDau = Double.parseDouble(txtGioBatDau.getText());
                double ketThuc = Double.parseDouble(txtGioKetThuc.getText());

                if (ketThuc > batDau) {
                    double tong = ketThuc - batDau;
                    double tienThanhToan = 0;
                    for (double i = batDau; i < ketThuc; i++) {
                        if (i < 10 || i >= 23) {
                            tienThanhToan += 0;
                        } else if (i >= 10 && i < 17) {
                            tienThanhToan += 20000;
                        } else if (i >= 17 && i < 23) {
                            tienThanhToan += 45000;
                        }
                    }
                    txtTienThanhToan.setText(String.valueOf(tienThanhToan));
                } else {
                    JOptionPane.showMessageDialog(null, "Giờ kết thúc phải > giờ bắt đầủ");
                }
            }
        });

        //Viết code Java cho nút Làm Mới là xoá dữ liệủ trổng các ô JTextField và đưa con trỏ vào ô Giờ bắt đầu. (1 điểm)

        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtGioBatDau.setText(null);
                txtGioKetThuc.setText(null);
                txtTienThanhToan.setText(null);
                txtGioBatDau.requestFocus();
            }
        });

        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pnCenterRight.add(btnThanhToan, gbc1);
        pnCenterRight.add(btnLamMoi, gbc1);
        pnCenterRight.add(btnDong, gbc1);

        btnThanhToan.setPreferredSize(new Dimension(150, 40));
        btnLamMoi.setPreferredSize(new Dimension(150, 40));
        btnDong.setPreferredSize(new Dimension(150, 40));

        pnCenter.add(pnCenterRight);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Cau2();
    }
}

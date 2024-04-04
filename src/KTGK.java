import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KTGK extends JFrame {
    public KTGK() {
        JFrame frm = new JFrame("Thiet Ke Giao Dien");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(500,300);
        JPanel pnMain = new JPanel();
        pnMain.setBorder(new EmptyBorder(20,30,20,30));
        frm.getContentPane().add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BorderLayout(5,5));
        frm.add(pnMain);

        JPanel pnTieuDe = new JPanel();
        pnTieuDe.setLayout(new FlowLayout());
        JLabel lblTieuDe = new JLabel("Nhap Ho Va Ten");
        JTextField txtTieuDe = new JTextField(25);
        pnMain.add(pnTieuDe, BorderLayout.NORTH);
        pnTieuDe.add(lblTieuDe);
        pnTieuDe.add(txtTieuDe);

        JPanel pnGiua = new JPanel();
        pnGiua.setLayout(new GridLayout(1,2));
        pnMain.add(pnGiua, BorderLayout.CENTER);

        JPanel pnTrai = new JPanel();
        TitledBorder borderTrai = BorderFactory.createTitledBorder(new LineBorder(Color.WHITE, 4), "Color");
        borderTrai.setTitleColor(Color.RED);
        pnTrai.setBorder(borderTrai);
        pnTrai.setLayout(new GridLayout(0,1));
        JRadioButton rRed = new JRadioButton("Red");
        rRed.setForeground(Color.RED);
        JRadioButton rBlue = new JRadioButton("Blue");
        rBlue.setForeground(Color.BLUE);
        JRadioButton rBlack = new JRadioButton("Black");
        rBlack.setForeground(Color.BLACK);
        JRadioButton rGreen = new JRadioButton("Green");
        rGreen.setForeground(Color.GREEN);
        pnTrai.setBackground(Color.BLUE);
        pnTrai.add(rRed);
        pnTrai.add(rBlack);
        pnTrai.add(rGreen);
        pnTrai.add(rBlue);
        pnGiua.add(pnTrai);

        JPanel pnPhai = new JPanel();
        TitledBorder borderPhai = BorderFactory.createTitledBorder(new LineBorder(Color.WHITE,4), "Font" , TitledBorder.RIGHT, TitledBorder.DEFAULT_POSITION);
        borderPhai.setTitleColor(Color.BLUE);
        pnPhai.setBorder(borderPhai);
        pnPhai.setLayout(new GridLayout(0,1));
        JCheckBox cBold = new JCheckBox("Bold");
        JCheckBox cUnderLine = new JCheckBox("UnderLine");
        JCheckBox cItalic = new JCheckBox("Italic");
        pnPhai.setBackground(Color.ORANGE);
        pnPhai.add(cItalic);
        pnPhai.add(cBold);
        pnPhai.add(cUnderLine);
        pnGiua.add(pnPhai);

        JPanel pnCuoi = new JPanel();
        pnCuoi.setLayout(new FlowLayout());
        JLabel lblLapTrinh = new JLabel("Lap Trinh Boi:");
        lblLapTrinh.setForeground(Color.RED);
        JLabel lblHoTen = new JLabel("Phan Hoang Phuc");
        JButton btnThoat = new JButton("Thoat");
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,"Ban co muon thoat khong","Xac nhan thoat",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        pnCuoi.add(lblLapTrinh);
        pnCuoi.add(lblHoTen);
        pnCuoi.add(btnThoat);
        pnMain.add(pnCuoi, BorderLayout.SOUTH);



        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new KTGK();
    }
}

package Tuan05;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bai01 extends JFrame {
    private JTextField txtThongTin;

    public Bai01() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(5, 5));
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTop = new JPanel();
        JLabel lblTieuDe = new JLabel("Thong Tin Cac Nganh Hoc");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 15));
        pnTop.add(lblTieuDe);
        pnMain.add(pnTop, BorderLayout.NORTH);

        JPanel pnMid = new JPanel();
        pnMid.setLayout(new GridLayout(0, 2));
        pnMain.add(pnMid, BorderLayout.CENTER);

        JPanel pnLeft = new JPanel();
        pnLeft.setLayout(new GridLayout(0, 1));

        JPanel pnLeftButton = new JPanel();
        pnLeftButton.setBorder(new EmptyBorder(20, 50, 5, 10));
        pnLeftButton.setLayout(new GridLayout(0, 1));

        JButton btnThem = new JButton("Them");
        JButton btnCapNhat = new JButton("Cap Nhat");
        JButton btnXoa = new JButton("Xoa");

        JPanel pnLeftText = new JPanel();
        pnLeftText.setLayout(new FlowLayout());
        pnLeftButton.setBorder(new EmptyBorder(20, 40, 5, 10));

        JLabel lblNhapThongTin = new JLabel("Nhap Thong Tin:");
        JTextField txtThongTin = new JTextField(15);
        pnLeftButton.add(btnThem);
        pnLeftButton.add(btnCapNhat);
        pnLeftButton.add(btnXoa);
        pnLeft.add(pnLeftButton);
        pnLeftText.add(lblNhapThongTin);
        pnLeftText.add(txtThongTin);
        pnLeft.add(pnLeftText);
        pnMid.add(pnLeft);

        JPanel pnRight = new JPanel();
        DefaultMutableTreeNode root = null;
        JTree tree;

        root = new DefaultMutableTreeNode("KCNTT");
        tree = new JTree(root);
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    txtThongTin.setText(selectedNode.getUserObject().toString());
                }
            }
        });

        DefaultMutableTreeNode nodeKTPM = new DefaultMutableTreeNode("Nganh KTPM");
        root.add(nodeKTPM);
        DefaultMutableTreeNode nodeTTNT = new DefaultMutableTreeNode("Nganh TTNT");
        root.add(nodeTTNT);
        DefaultMutableTreeNode nodeKHDL = new DefaultMutableTreeNode("Nganh KHDL");
        root.add(nodeKHDL);
        tree.expandRow(0);

        tree.setPreferredSize(new Dimension(300, 300));

        JScrollPane sc = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnRight.add(sc, BorderLayout.CENTER);
        pnMid.add(pnRight);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(txtThongTin.getText());
                    selectedNode.add(newNode);

                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.reload();
                    for (int i = 0; i < tree.getRowCount(); i++) {
                        tree.expandRow(i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban Chua Chon Node!!");
                }
            }
        });

        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount()>0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    selectedNode.setUserObject(txtThongTin.getText());
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.reload();
                    for (int i=0; i<tree.getRowCount(); i++) {
                        tree.expandRow(i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Ban Chua Chon Node!!");
                }
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount()>0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    if (selectedNode != tree.getModel().getRoot()) {
                        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                        model.removeNodeFromParent(selectedNode);
                        model.reload();
                        for (int i=0; i<tree.getRowCount(); i++) {
                            tree.expandRow(i);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Khong duoc xoa Node nha!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua chon Node!!");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai01();
    }
}

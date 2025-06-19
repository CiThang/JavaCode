package BaiTap;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.*;

public class Bai_1 extends JFrame {

    private JTree fileTree;

    public Bai_1() {
        super("File Explorer");

        // Set up the UI
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new File("/"));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        fileTree = new JTree(treeModel);
        fileTree.setRootVisible(false);

        JScrollPane scrollPane = new JScrollPane(fileTree);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add listener to expand directories
        fileTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
            if (node == null) return;
            File file = (File) node.getUserObject();
            if (file.isDirectory() && node.getChildCount() == 0) {
                expandNode(node);
            }
        });

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void expandNode(DefaultMutableTreeNode node) {
        File directory = (File) node.getUserObject();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(file);
                node.add(newNode);
                if (file.isDirectory()) {
                    newNode.add(new DefaultMutableTreeNode(true));
                }
            }
            ((DefaultTreeModel) fileTree.getModel()).reload(node);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai_1::new);
    }
}

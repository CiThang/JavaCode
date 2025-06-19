package BaiTap;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Bai_2 extends JFrame {

    private JTree fileTree;
    private JButton copyButton;
    private JButton moveButton;

    public Bai_2() {
        super("File Explorer");

        // Set up the UI
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new File("/"));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        fileTree = new JTree(treeModel);
        fileTree.setRootVisible(false);

        JScrollPane scrollPane = new JScrollPane(fileTree);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        copyButton = new JButton("Copy");
        moveButton = new JButton("Move");
        buttonPanel.add(copyButton);
        buttonPanel.add(moveButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Add listener to expand directories
        fileTree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
            if (node == null) return;
            File file = (File) node.getUserObject();
            if (file.isDirectory() && node.getChildCount() == 0) {
                expandNode(node);
            }
        });

        // Add action listeners for copy and move buttons
        copyButton.addActionListener(e -> copySelectedFiles());
        moveButton.addActionListener(e -> moveSelectedFiles());

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

    private void copySelectedFiles() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        if (selectedNode == null) return;

        File source = (File) selectedNode.getUserObject();
        if (!source.exists()) return;

        File destination = showFileChooserDialog("Select destination directory for copy");
        if (destination == null) return;

        if (source.isDirectory()) {
            copyDirectory(source, destination);
        } else {
            copyFile(source, new File(destination, source.getName()));
        }
        refreshTree();
    }

    private void moveSelectedFiles() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        if (selectedNode == null) return;

        File source = (File) selectedNode.getUserObject();
        if (!source.exists()) return;

        File destination = showFileChooserDialog("Select destination directory for move");
        if (destination == null) return;

        if (source.isDirectory()) {
            moveDirectory(source, destination);
        } else {
            moveFile(source, new File(destination, source.getName()));
        }
        refreshTree();
    }

    private File showFileChooserDialog(String title) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(title);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showDialog(this, "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    private void copyFile(File source, File destination) {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyDirectory(File source, File destination) {
        if (!destination.exists()) {
            destination.mkdir();
        }

        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    copyDirectory(file, new File(destination, file.getName()));
                } else {
                    copyFile(file, new File(destination, file.getName()));
                }
            }
        }
    }

    private void moveFile(File source, File destination) {
        if (!source.renameTo(destination)) {
            copyFile(source, destination);
            source.delete();
        }
    }

    private void moveDirectory(File source, File destination) {
        if (!destination.exists()) {
            destination.mkdir();
        }

        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    moveDirectory(file, new File(destination, file.getName()));
                } else {
                    moveFile(file, new File(destination, file.getName()));
                }
            }
        }
        source.delete();
    }

    private void refreshTree() {
        DefaultTreeModel model = (DefaultTreeModel) fileTree.getModel();
        model.reload();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai_2::new);
    }
}

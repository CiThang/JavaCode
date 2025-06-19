package BaiTap;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Bai_3 extends JFrame {

    private JTree fileTree;
    private JButton copyButton;
    private JButton moveButton;
    private JButton createFileButton;
    private JButton readFileButton;

    public Bai_3() {
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
        createFileButton = new JButton("Create File");
        readFileButton = new JButton("Read File");
        buttonPanel.add(copyButton);
        buttonPanel.add(moveButton);
        buttonPanel.add(createFileButton);
        buttonPanel.add(readFileButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners for copy, move, create file, and read file buttons
        copyButton.addActionListener(e -> copySelectedFiles());
        moveButton.addActionListener(e -> moveSelectedFiles());
        createFileButton.addActionListener(e -> createFile());
        readFileButton.addActionListener(e -> readFile());

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
        // Copy functionality
        // ...
    }

    private void moveSelectedFiles() {
        // Move functionality
        // ...
    }

    private void createFile() {
        File selectedDirectory = showFileChooserDialog("Select directory to create file");
        if (selectedDirectory == null) return;

        String fileName = JOptionPane.showInputDialog(this, "Enter file name:");
        if (fileName == null || fileName.trim().isEmpty()) return;

        String fileContent = JOptionPane.showInputDialog(this, "Enter file content:");
        if (fileContent == null) return;

        File newFile = new File(selectedDirectory, fileName);
        try (FileWriter writer = new FileWriter(newFile)) {
            writer.write(fileContent);
            writer.flush();
            refreshTree();
            JOptionPane.showMessageDialog(this, "File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while creating file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void readFile() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        if (selectedNode == null) return;

        File file = (File) selectedNode.getUserObject();
        if (!file.isFile()) {
            JOptionPane.showMessageDialog(this, "Selected item is not a file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            StringBuilder content = new StringBuilder();
            int data;
            while ((data = reader.read()) != -1) {
                content.append((char) data);
            }
            JOptionPane.showMessageDialog(this, "File content:\n\n" + content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while reading file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    private void refreshTree() {
        DefaultTreeModel model = (DefaultTreeModel) fileTree.getModel();
        model.reload();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai_3::new);
    }
}

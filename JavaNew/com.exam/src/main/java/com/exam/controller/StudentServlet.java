package com.exam.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.model.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username và password của database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "";

    // Các câu lệnh SQL
    private static final String SQL_SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String SQL_INSERT_STUDENT = "INSERT INTO students (full_name, birth_year, gpa) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE_STUDENT = "UPDATE students SET full_name = ?, birth_year = ?, gpa = ? WHERE id = ?";
    private static final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE id = ?";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            // Xử lý đăng nhập
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Kiểm tra username và password trong cơ sở dữ liệu (giả sử đã có hàm kiểm tra)

            // Chuyển hướng tới trang chính sau khi đăng nhập thành công
            response.sendRedirect(request.getContextPath() + "/main.jsp");
        } else if ("getAllStudents".equals(action)) {
            // Lấy danh sách sinh viên từ cơ sở dữ liệu và gửi về cho client
            List<Student> students = getAllStudentsFromDB();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/showStudents.jsp").forward(request, response);
        } else {
            // Mặc định hiển thị trang chủ
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addStudent".equals(action)) {
            // Thêm sinh viên vào cơ sở dữ liệu
            String fullName = request.getParameter("fullName");
            int birthYear = Integer.parseInt(request.getParameter("birthYear"));
            double gpa = Double.parseDouble(request.getParameter("gpa"));

            addStudentToDB(fullName, birthYear, gpa);
        } else if ("updateStudent".equals(action)) {
            // Cập nhật thông tin sinh viên trong cơ sở dữ liệu
            int id = Integer.parseInt(request.getParameter("id"));
            String fullName = request.getParameter("fullName");
            int birthYear = Integer.parseInt(request.getParameter("birthYear"));
            double gpa = Double.parseDouble(request.getParameter("gpa"));

            updateStudentInDB(id, fullName, birthYear, gpa);
        } else if ("deleteStudent".equals(action)) {
            // Xóa sinh viên từ cơ sở dữ liệu
            int id = Integer.parseInt(request.getParameter("id"));

            deleteStudentFromDB(id);
        }

        // Sau khi thực hiện các thao tác, chuyển hướng về trang hiển thị danh sách sinh viên
        response.sendRedirect(request.getContextPath() + "/student?action=getAllStudents");
    }

    // Phương thức để lấy danh sách sinh viên từ cơ sở dữ liệu
    private List<Student> getAllStudentsFromDB() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_ALL_STUDENTS);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                int birthYear = rs.getInt("birth_year");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, fullName, birthYear, gpa);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Phương thức để thêm sinh viên vào cơ sở dữ liệu
    private void addStudentToDB(String fullName, int birthYear, double gpa) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT_STUDENT)) {
            
            stmt.setString(1, fullName);
            stmt.setInt(2, birthYear);
            stmt.setDouble(3, gpa);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để cập nhật thông tin sinh viên trong cơ sở dữ liệu
    private void updateStudentInDB(int id, String fullName, int birthYear, double gpa) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_STUDENT)) {
            
            stmt.setString(1, fullName);
            stmt.setInt(2, birthYear);
            stmt.setDouble(3, gpa);
            stmt.setInt(4, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để xóa sinh viên từ cơ sở dữ liệu
    private void deleteStudentFromDB(int id) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_STUDENT)) {
            
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

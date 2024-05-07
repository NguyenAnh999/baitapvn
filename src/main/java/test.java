import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    private static final String URL = "jdbc:mysql://localhost:3306/stdlquanly";
    private static final String UER_NAME = "root";
    private static final String PASS = "123456";

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,UER_NAME,PASS);
            PreparedStatement pre= conn.prepareStatement("select * from Student");
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setName(rs.getString("name"));
                s.setId(Integer.valueOf(rs.getString("id")));
                s.setImg(rs.getString("img"));
                studentList.add(s);
            }
            System.out.println(studentList.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
                try {
                    assert conn != null;
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
        try {
            conn=DriverManager.getConnection(URL,UER_NAME,PASS);
            PreparedStatement pre = conn.prepareStatement("insert into student (name,img) values('anh','yhigudrfwshjkidfcas')");
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}

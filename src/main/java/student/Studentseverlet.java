package student;

import ra.example.service.UploadService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "Studentseverlet", value = "/Studentseverlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB - kích thước bộ nhớ tạm
        maxFileSize = 1024 * 1024 * 5,   // 5MB
        maxRequestSize = 1024 * 1024 * 5 * 10 // 50MB
)
public class Studentseverlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("stdList", Iplm.studentList);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadService up = new UploadService();
        Student s = new Student();
        String name = request.getParameter("name");
        s.setName(name);
//        String path = getServletContext().getRealPath("/uploads");
        Part file = request.getPart("img");
        if (file!=null&&file.getSize()>0){
            // uploads
            s.setImg(up.uploadFileToServer(file,getServletContext()));
//            file.write(path+File.separator+file.getSubmittedFileName());
        }
        Iplm.studentList.add(s);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}
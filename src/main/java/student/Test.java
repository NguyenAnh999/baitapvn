package student;

import ra.example.service.UploadService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Test", value = "/Test")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB - kích thước bộ nhớ tạm
        maxFileSize = 1024 * 1024 * 5,   // 5MB
        maxRequestSize = 1024 * 1024 * 5 * 10 // 50MB
)
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file = request.getPart("img");
        UploadService u =  new UploadService();
        String url = null;
        if (file.getSize()>0){
            url = u.uploadFileToServer(file,getServletContext());
        }
        request.setAttribute("url",url);
        request.getRequestDispatcher("/sfjhgjkds.jsp").forward(request,response);
    }
}
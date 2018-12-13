package quanlynhahang.controllers.download;

import quanlynhahang.common.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "DocumentDownloadServlet", urlPatterns = { "/document/download" })
public class DocumentDownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fileName = request.getParameter("fileName");
            if (fileName == null || fileName.trim().isEmpty()) {
                response.sendError(400);
                return;
            }

            String physicalFile = Consts.DOCUMENT_PATH + fileName;
            Path path = Paths.get(physicalFile);
            byte[] data = Files.readAllBytes(path);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            response.setContentLength(data.length);

            InputStream sin = new BufferedInputStream(new ByteArrayInputStream(data));
            OutputStream sout = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = sin.read(buffer)) != -1) {
                sout.write(buffer, 0, bytesRead);
            }
            sin.close();
            sout.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}

package main.java.controllers;

import annotations.Controller;
import annotations.GetMapping;
import annotations.PostMapping;
import annotations.RequestParam;
import annotations.Url;
import jakarta.servlet.http.Part;
import view.ModelView;

@Controller
public class FileController {

    @Url("/form-file")
    public ModelView fileForm() { 
        ModelView mv = new ModelView();
        mv.setView("form-file.jsp");

        return mv;
    }

    @PostMapping("/upload")
    public String upload(Part file) {
        String fileName = file.getSubmittedFileName();
        long fileSize = file.getSize();
        return "File <strong>" + fileName + "</strong> uploaded successfully with size <strong>" + fileSize + "</strong> bytes.";
    }

    @PostMapping("/uploadMultiple")
    public String uploadMultiple(@RequestParam("files") Part[] files) {
        StringBuilder response = new StringBuilder();
        for (Part file : files) {
            String fileName = file.getSubmittedFileName();
            long fileSize = file.getSize();
            response.append("File : ")
                .append("<strong>").append(fileName).append("</strong>")
                .append(" uploaded successfully with size ")
                .append("<strong>").append(fileSize).append("</strong>").append(" bytes.").append("</br>");
        }
        return response.toString(); 
    }
}

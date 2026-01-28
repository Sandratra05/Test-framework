package main.java.controllers;

import java.util.Map;

import mg.ririnina.annotations.Controller;
import mg.ririnina.annotations.GetMapping;
import mg.ririnina.annotations.PostMapping;
import mg.ririnina.annotations.RequestParam;
import mg.ririnina.annotations.Url;
import jakarta.servlet.http.Part;
import mg.ririnina.view.ModelView;

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

    @PostMapping("/uploadBytes")
    public String uploadBytes(@RequestParam("files") Map<String, byte[]> fileContents) {
        //return "Hello";
        if (fileContents == null || fileContents.isEmpty()) return "No files uploaded.";
        //return "Uploaded " + fileContents.size() + " files successfully.";
        StringBuilder response = new StringBuilder();
        for (Map.Entry<String, byte[]> entry : fileContents.entrySet()) {
            String fileName = entry.getKey();
            byte[] content = entry.getValue();
            if (fileName == null) fileName = "Unknown";  // <-- Ajout : gérer null
            response.append("File : ")
                .append("<strong>").append(fileName).append("</strong>")
                .append(" uploaded successfully with size ")
                .append("<strong>").append(content != null ? content.length : 0).append("</strong>").append(" bytes.").append("<br>");
        }
        return response.toString();
    }
}

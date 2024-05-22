package si.um.ris.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import si.um.ris.repository.IAppUserRepo;
import si.um.ris.repository.IEventRepo;
import si.um.ris.service.PDFGeneratorService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Uporabnik on 25. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pdf")
public class PDFExportController {
    private final PDFGeneratorService pdfGeneratorService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }


    @GetMapping("/generate")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.export(response);
    }


}

package si.um.ris.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.ris.models.AppUser;
import si.um.ris.models.Event;
import si.um.ris.repository.IAppUserRepo;
import si.um.ris.repository.IEventRepo;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Uporabnik on 25. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Service
public class PDFGeneratorService {
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
    @Autowired
    private IEventRepo eventRepo;
    @Autowired
    private IAppUserRepo appUserRepo;

    public Iterable<Event> findEvents() {
        return eventRepo.findAll();
    }

    public Iterable<AppUser> findUsers() {
        return appUserRepo.findAll();
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();    //ko enkrat odpres document lahko delas z njim

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Report for " + currentDateTime, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontSubTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(14);
        Paragraph subTitle = new Paragraph("Events", fontSubTitle);
        subTitle.setAlignment(Paragraph.ALIGN_LEFT);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph1 = new Paragraph(findEvents().toString(), fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph subTitle1 = new Paragraph("Users", fontSubTitle);
        subTitle1.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph2 = new Paragraph(findUsers().toString(), fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(subTitle);
        document.add(paragraph1);
        document.add(subTitle1);
        document.add(paragraph2);
        document.close();
    }
}

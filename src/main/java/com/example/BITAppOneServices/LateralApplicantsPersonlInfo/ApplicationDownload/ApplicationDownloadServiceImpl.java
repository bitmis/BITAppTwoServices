package com.example.BITAppOneServices.LateralApplicantsPersonlInfo.ApplicationDownload;


import com.example.BITAppOneServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfo;
import com.example.BITAppOneServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfoRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class ApplicationDownloadServiceImpl {

    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;


    public OutputStream generateApplicationPDF(String application_no) {

        LateralApplicantsPersonlInfo applicationInfor = lateralApplicantsPersonlInfoRepository.findByApplicationNo(application_no);
        if(applicationInfor != null) {
            String full_name = applicationInfor.getFull_name();
            String id_no = applicationInfor.getId_no();

            try {
                String filename = "PaymentVouchers/" + application_no + "_payment_voucher.pdf";
                Document document = new Document();
                OutputStream file = new FileOutputStream(filename);
                PdfWriter writer = PdfWriter.getInstance(document, file);
                document.open();

                BufferedImage barcodeImage = generateBarcodeImage(application_no);
                String barcodeImagePath = "PaymentVouchers/" + application_no + "_barcode.jpg";
                File saveImage = new File(barcodeImagePath);
                ImageIO.write(barcodeImage, "jpg", saveImage);


                StringBuilder htmlString = new StringBuilder();

                htmlString.append(new String("<table style=\"border:0 solid #000;width:100%;margin-bottom:3%\"><tr><td>barcode and Application No</td><td>timestamp</td></tr></table><table style=\"border:0 solid #000;width:100%;margin-bottom:3%\"><tr><td>APPLICATION FORM FOR DIPLOMA IN INFORMATION TECHNOLOGY OF THE BACHELOR OF INFORMATION TECHNOLOGY (BIT) DEGREE PROGRAMME - 2022 UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING</td></tr></table><table style=\"border:1px solid #000;width:100%;margin-bottom:3%\"><tr><td>1. Name in Full:</td><td>fsfsffwefwewewefwe</td></tr><tr><td>2. Name with Initials:</td><td>ffsfwsefwefwe</td></tr></table><table style=\"border:1px solid #000;width:100%;margin-bottom:3%\"><tr><td>3. Title :</td><td>Ms</td><td>4. Gender :</td><td>Female</td></tr><tr><td>5. Citizenship :</td><td>Sri Lankan</td><td>6. Nationality :</td><td>Sri Lankan</td></tr><tr><td>7. National ID Number :</td><td>200180800414</td><td>8. Date of Birth :</td><td>2001-11-03</td></tr></table><table style=\"border:1px solid #000;width:100%;margin-bottom:3%\"><tr><td>10. Contact Details</td><td></td></tr><tr><td>(a) Permanent Address :</td><td>-, Rathmehera Estate, Aluthwala, Galle</td></tr><tr><td>(b) Country :</td><td>Sri Lanka</td></tr><tr><td>(c) Mobile :</td><td>+94775722245</td></tr><tr><td>(d) Land Phone :</td><td>94718307504</td></tr><tr><td>(e) E-mail :</td><td>hgiff@gmail.com</td></tr></table><table style=\"border:1px solid #000;width:100%;margin-bottom:3%\"><tr><td>11. Education Qualification :</td></tr><tr><td>(a) Ordinary Level (O/L) Results :</td></tr><tr><td><table style=\"border:0 solid #000;width:100%\"><tr><td>Subject</td><td>Year</td><td>Result</td><td>Index</td></tr><tr><td>Subject1</td><td>Year1</td><td>Result1</td><td>Index1</td></tr><tr><td>Subject2</td><td>Year2</td><td>Result2</td><td>Index2</td></tr></table></td></tr></table>"));
                htmlString.append(new String("<p style=\"font-size:10px ; text-align:center\">DO NOT WRITE ANYTHING BELOW THIS LINE</p><br/><br/><br/><br/>"));



                InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
                XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
                document.close();
                file.close();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    public static BufferedImage generateBarcodeImage(String barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createCode128(barcodeText);

        return BarcodeImageHandler.getImage(barcode);
    }
}

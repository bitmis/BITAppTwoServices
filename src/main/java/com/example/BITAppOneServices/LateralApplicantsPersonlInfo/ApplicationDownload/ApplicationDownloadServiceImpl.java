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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class ApplicationDownloadServiceImpl {

    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;


    public OutputStream generateApplicationPDF(String application_no) {

        LateralApplicantsPersonlInfo applicationInfor = lateralApplicantsPersonlInfoRepository.findByApplicationNo(application_no);
        if (applicationInfor != null) {
            String full_name = applicationInfor.getFull_name();
            String name_marking = applicationInfor.getName_marking();
            String initials = applicationInfor.getInitials();

            String title = applicationInfor.getTitle();
            String gender = applicationInfor.getGender();
            String citizenship = applicationInfor.getCitizenship();
            String nationality = applicationInfor.getNationality();

            String id_no = applicationInfor.getId_no();
            String dob = applicationInfor.getDob();

            String address1 = applicationInfor.getAddress1();
            String address2 = applicationInfor.getAddress2();
            String address3 = applicationInfor.getAddress3();
            String district = applicationInfor.getDistrict();
            String country = applicationInfor.getCountry();

            String phone = applicationInfor.getPhone();
            String mobile = applicationInfor.getMobile();
            String email = applicationInfor.getEmail();

            String disabilities = applicationInfor.getDisabilities();

            String full_address = address1 + " " + address2 + " " + address3 + " " + district;

            try {
                String filename = "PaymentVouchers/" + application_no + "_application.pdf";
                Document document = new Document();
                OutputStream file = new FileOutputStream(filename);
                PdfWriter writer = PdfWriter.getInstance(document, file);
                document.open();

                BufferedImage barcodeImage = generateBarcodeImage(application_no);
                String barcodeImagePath = "PaymentVouchers/" + application_no + "_barcode.jpg";
                File saveImage = new File(barcodeImagePath);
                ImageIO.write(barcodeImage, "jpg", saveImage);

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


                StringBuilder htmlString = new StringBuilder();

                htmlString.append(new String("<table style=\"border:0px solid black; width:100%;margin-bottom:3% ;font-family:Times New Roman ;\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> <br/>" + application_no + "</td>\n" +
                        "    <td>" + sdf.format(timestamp) + "</td>\n" +
                        "  </tr>\n" +
                        "</table>"));
                htmlString.append(new String("<br/><br/>"));
                htmlString.append(new String("<table style=\"border:0px solid black; width:100%;margin-bottom:30%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\" font-family:Times New Roman ;text-align: center;\">APPLICATION FOR THE DIPLOMA IN INFORMATION TECHNOLOGY OF THE BACHELOR OF INFORMATION TECHNOLOGY (BIT) DEGREE PROGRAMME - 2022  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING </td>\n" +
                        "  </tr>\n" +
                        "</table>"));
                htmlString.append(new String("<br/><br/><br/>"));
                htmlString.append(new String("<table style=\"border:1px solid black; width:100%;font-family:Times New Roman ;margin-top:10%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"width:30% ; color: #808080 ;padding:5%\">1. Name in Full:</td>\n" +
                        "    <td style=\"padding:5%\">" + full_name + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td style=\"width:30% ; color: #808080 ;padding:5%\">2. Name with Initials:</td>\n" +
                        "    <td style=\"padding:5%\">" + initials + " " + name_marking + "</td>\n" +
                        "  </tr>\n" +
                        "</table> <br/><br/><br/><br/>"));

                htmlString.append(new String("<br/><br/><br/><p> </p>"));
                htmlString.append(new String("<table style=\"border:1px solid #000;width:100%;margin-top:3%;font-family:Times New Roman;padding:5%\"><tr><td style=\"color: #808080;padding:5%\">3. Title :</td><td style=\"text-align:left;padding:5%\">" + title + "</td><td style=\"color: #808080;padding:5%\">4. Gender :</td><td style=\"text-align:left;padding:5%\">" + gender + "</td></tr><tr><td style=\"color: #808080;padding:5%\">5. Citizenship :</td><td style=\"text-align:left;padding:5%\">" + citizenship + "</td><td style=\"color: #808080;padding:5%\">6. Nationality :</td><td style=\"text-align:left;padding:5%\">" + nationality + "</td></tr><tr><td style=\"color: #808080;padding:5%\">7. NIC Number :</td><td style=\"text-align:left;padding:5%\">" + id_no + "</td><td style=\"color: #808080;padding:5%\">8. DoB :</td><td style=\"text-align:left;padding:5%\">" + dob + "</td></tr></table>"));

                htmlString.append(new String("<table style=\"border:1px solid #000;width:100%;margin-top:3%;font-family:Times New Roman\"><tr><td>10. Contact Details</td><td></td></tr><tr><td style=\"width:30%;color:#808080;padding:5%\">(a) Permanent Address :</td><td style=\"padding:5%;word-wrap:break-word\"> " + full_address + "</td></tr><tr><td style=\"width:30%;color:#808080;padding:5%\">(b) Country :</td><td style=\"padding:5%\">" + country + "</td></tr><tr><td style=\"width:30%;color:#808080;padding:5%\">(c) Mobile :</td><td style=\"padding:5%\">" + mobile + "</td></tr><tr><td style=\"width:30%;color:#808080;padding:5%\">(d) Land Phone :</td><td style=\"padding:5%\">" + phone + "</td></tr><tr><td style=\"width:30%;color:#808080;padding:5%\">(e) E-mail :</td><td style=\"padding:5%\">" + email + "</td></tr></table>"));

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

package com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.PaymentVoucher;

import com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfo;
import com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfoRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
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
public class PaymentVoucherServiceImpl {

    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;



    public OutputStream generatePaymentVoucherPDF(String application_no) throws IOException, DocumentException {

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

                htmlString.append(new String("<table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:20%\"><b>CASH-PAYING-IN-SLIP</b> <br/><p style=\"font-size:8px\">(To be filled in quadruplicate) </p>EDC COPY-1  <br/>Paid Date</td><td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> "+application_no+"</td><td>DEGREE OF BACHELOR OF INFORMATION TECHNOLOGY-BIT  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING (UCSC)</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>D</td><td>D</td><td>M</td><td>M</td><td>Y</td><td>Y</td></tr><tr style=\"background-color:#fff;height:30px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></td><td>&nbsp;&nbsp;&nbsp;</td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid at People's  <br/>Bank Branch</td><td style=\"background-color:#fff;width:250px\"></td></tr></table></td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid <br/>Bank Branch <br/> Code  <br/></td><td style=\"background-color:#fff;width:100px\"></td></tr></table></td></tr></table><table style=\"border:0;background-color:#000;font-family:Courier New,Courier,monospace;font-size:75% ; margin-top:20px;margin-bottom:10px\"><tr style=\"background-color:#fff\"><td>Purpose</td><td>Please tick the appropriate</td></tr><tr style=\"background-color:#fff\"><td>Application fee</td><td style=\"text-align:center\">#</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>Paid in credit of <br/> <b>UCSC EXTERNAL DEGREE PROGRAMME-PEOPLE'S BANK,THIMBIRIGASYAYA - AC No. 086-1001-111-89667</b></td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>AMOUNT PAID :</td><td>1,800.00</td></tr><tr><td>AMOUNT IN WORDS :</td><td>SRI LANKAN RUPEES ONE THOUSAND EIGHT HUNDRED ONLY</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:300px\"><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>  <br/>...........................  <br/> CASH DEPOSITER'S SIGNATURE </td></tr></table></td><td><u>Instruction to Bank</u>  <br/>Please do not accept unless the cage below is filled</td></tr><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style =\"font:10px\">  <br/>  <br/>...........................  <br/>CASHIER'S SIGNATURE</td></tr></table></td><td><table style=\"background-color:#fff;border:1px #000 solid;font-size:90% ; width:85%\"\"><tr><td>Applicant's Full Name :</td><td><b>"+full_name+"</b></td></tr><tr><td>Application Number :</td><td><b>"+application_no+"</b></td></tr><tr><td>Applicant's NIC No:</td><td><b>"+id_no+"</b></td></tr></table></td></tr></table><hr></hr>"));
                htmlString.append(new String("<p style=\"font-size:10px ; text-align:center\">DO NOT WRITE ANYTHING BELOW THIS LINE</p><br/><br/><br/><br/>"));

                htmlString.append(new String("<table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:20%\"><b>CASH-PAYING-IN-SLIP</b> <br/><p style=\"font-size:8px\">(To be filled in quadruplicate) </p>CANDIDATE’S COPY-2  <br/>Paid Date</td><td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> "+application_no+"</td><td>DEGREE OF BACHELOR OF INFORMATION TECHNOLOGY-BIT  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING (UCSC)</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>D</td><td>D</td><td>M</td><td>M</td><td>Y</td><td>Y</td></tr><tr style=\"background-color:#fff;height:30px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></td><td>&nbsp;&nbsp;&nbsp;</td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid at People's  <br/>Bank Branch</td><td style=\"background-color:#fff;width:250px\"></td></tr></table></td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid <br/>Bank Branch <br/> Code  <br/></td><td style=\"background-color:#fff;width:100px\"></td></tr></table></td></tr></table><table style=\"border:0;background-color:#000;font-family:Courier New,Courier,monospace;font-size:75% ; margin-top:20px;margin-bottom:10px\"><tr style=\"background-color:#fff\"><td>Purpose</td><td>Please tick the appropriate</td></tr><tr style=\"background-color:#fff\"><td>Application fee</td><td style=\"text-align:center\">#</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>Paid in credit of <br/> <b>UCSC EXTERNAL DEGREE PROGRAMME-PEOPLE'S BANK,THIMBIRIGASYAYA - AC No. 086-1001-111-89667</b></td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>AMOUNT PAID :</td><td>1,800.00</td></tr><tr><td>AMOUNT IN WORDS :</td><td>SRI LANKAN RUPEES ONE THOUSAND EIGHT HUNDRED ONLY</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:300px\"><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>  <br/>...........................  <br/> CASH DEPOSITER'S SIGNATURE </td></tr></table></td><td><u>Instruction to Bank</u>  <br/>Please do not accept unless the cage below is filled</td></tr><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style =\"font:10px\">  <br/>  <br/>...........................  <br/>CASHIER'S SIGNATURE</td></tr></table></td><td><table style=\"background-color:#fff;border:1px #000 solid;font-size:80% ; width:85%\"\"><tr><td>Applicant's Full Name</td><td><b>" + full_name + "</b></td></tr><tr><td>Application Number</td><td><b>" + application_no + "</b></td></tr><tr><td>Applicant's NIC No.</td><td><b>" + id_no + "</b></td></tr></table></td></tr></table><hr></hr>"));
                htmlString.append(new String("<p style=\"font-size:10px ; text-align:center\">DO NOT WRITE ANYTHING BELOW THIS LINE</p><br/><br/><br/><br/><br/><br/><br/>"));

                htmlString.append(new String("<table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:20%\"><b>CASH-PAYING-IN-SLIP</b> <br/><p style=\"font-size:8px\">(To be filled in quadruplicate) </p>BANK COPY-3  <br/>Paid Date</td><td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> "+application_no+"</td><td>DEGREE OF BACHELOR OF INFORMATION TECHNOLOGY-BIT  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING (UCSC)</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>D</td><td>D</td><td>M</td><td>M</td><td>Y</td><td>Y</td></tr><tr style=\"background-color:#fff;height:30px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></td><td>&nbsp;&nbsp;&nbsp;</td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid at People's  <br/>Bank Branch</td><td style=\"background-color:#fff;width:250px\"></td></tr></table></td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid <br/>Bank Branch <br/> Code  <br/></td><td style=\"background-color:#fff;width:100px\"></td></tr></table></td></tr></table><table style=\"border:0;background-color:#000;font-family:Courier New,Courier,monospace;font-size:75% ; margin-top:20px;margin-bottom:10px\"><tr style=\"background-color:#fff\"><td>Purpose</td><td>Please tick the appropriate</td></tr><tr style=\"background-color:#fff\"><td>Application fee</td><td style=\"text-align:center\">#</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>Paid in credit of <br/> <b>UCSC EXTERNAL DEGREE PROGRAMME-PEOPLE'S BANK,THIMBIRIGASYAYA - AC No. 086-1001-111-89667</b></td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>AMOUNT PAID :</td><td>1,800.00</td></tr><tr><td>AMOUNT IN WORDS :</td><td>SRI LANKAN RUPEES ONE THOUSAND EIGHT HUNDRED ONLY</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:300px\"><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>  <br/>...........................  <br/> CASH DEPOSITER'S SIGNATURE </td></tr></table></td><td><u>Instruction to Bank</u>  <br/>Please do not accept unless the cage below is filled</td></tr><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style =\"font:10px\">  <br/>  <br/>...........................  <br/>CASHIER'S SIGNATURE</td></tr></table></td><td><table style=\"background-color:#fff;border:1px #000 solid;font-size:80% ; width:85%\"\"><tr><td>Applicant's Full Name</td><td><b>" + full_name + "</b></td></tr><tr><td>Application Number</td><td><b>" + application_no + "</b></td></tr><tr><td>Applicant's NIC No.</td><td><b>" + id_no + "</b></td></tr></table></td></tr></table><hr></hr>"));
                htmlString.append(new String("<p style=\"font-size:10px ; text-align:center\">DO NOT WRITE ANYTHING BELOW THIS LINE</p><br/><br/><br/><br/>"));

                htmlString.append(new String("<table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:20%\"><b>CASH-PAYING-IN-SLIP</b> <br/><p style=\"font-size:8px\">(To be filled in quadruplicate) </p>PAYING BANK COPY-4 <br/>Paid Date</td><td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> "+application_no+"</td><td>DEGREE OF BACHELOR OF INFORMATION TECHNOLOGY-BIT  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING (UCSC)</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>D</td><td>D</td><td>M</td><td>M</td><td>Y</td><td>Y</td></tr><tr style=\"background-color:#fff;height:30px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></td><td>&nbsp;&nbsp;&nbsp;</td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid at People's  <br/>Bank Branch</td><td style=\"background-color:#fff;width:250px\"></td></tr></table></td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"font-size:13px;background-color:#fff;width:100px\">Paid <br/>Bank Branch <br/> Code  <br/></td><td style=\"background-color:#fff;width:100px\"></td></tr></table></td></tr></table><table style=\"border:0;background-color:#000;font-family:Courier New,Courier,monospace;font-size:75% ; margin-top:20px;margin-bottom:10px\"><tr style=\"background-color:#fff\"><td>Purpose</td><td>Please tick the appropriate</td></tr><tr style=\"background-color:#fff\"><td>Application fee</td><td style=\"text-align:center\">#</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>Paid in credit of <br/> <b>UCSC EXTERNAL DEGREE PROGRAMME-PEOPLE'S BANK,THIMBIRIGASYAYA - AC No. 086-1001-111-89667</b></td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>AMOUNT PAID :</td><td>1,800.00</td></tr><tr><td>AMOUNT IN WORDS :</td><td>SRI LANKAN RUPEES ONE THOUSAND EIGHT HUNDRED ONLY</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:300px\"><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>  <br/>...........................  <br/> CASH DEPOSITER'S SIGNATURE </td></tr></table></td><td><u>Instruction to Bank</u>  <br/>Please do not accept unless the cage below is filled</td></tr><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style =\"font:10px\">  <br/>  <br/>...........................  <br/>CASHIER'S SIGNATURE</td></tr></table></td><td><table style=\"background-color:#fff;border:1px #000 solid;font-size:80% ; width:85%\"\"><tr><td>Applicant's Full Name</td><td><b>" + full_name + "</b></td></tr><tr><td>Application Number</td><td><b>" + application_no + "</b></td></tr><tr><td>Applicant's NIC No.</td><td><b>" + id_no + "</b></td></tr></table></td></tr></table><hr></hr>"));
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

package com.example.BITAppOneServices.PaymentVoucher;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.*;

public class ItextHtmlToPDFExample {

    public static void main(String[] args)
    {
        try
        {
            OutputStream file = new FileOutputStream(new File("HTMLtoPDF.pdf"));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            StringBuilder htmlString = new StringBuilder();
//            htmlString.append(new String("<html><body> This is HMTL to PDF conversion Example<table border='2' align='center'> "));
//            htmlString.append(new String("<tr><td>JavaCodeGeeks</td><td><a href='examples.javacodegeeks.com'>JavaCodeGeeks</a> </td></tr>"));
//            htmlString.append(new String("<tr> <td> Google Here </td> <td><a href='www.google.com'>Google</a> </td> </tr></table></body></html>"));

            htmlString.append(new String("<table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:30%\">CASH-PAYING-IN-SLIP (To be filled in quadruplicate)  <br/>EDC COPY-1  <br/>Paid Date</td><td>Barcode 22N003895</td><td>DEGREE OF BACHELOR OF INFORMATION TECHNOLOGY-BIT  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING (UCSC)</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>D</td><td>D</td><td>M</td><td>M</td><td>Y</td><td>Y</td></tr><tr style=\"background-color:#fff;height:30px\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table></td><td>&nbsp;&nbsp;&nbsp;</td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"background-color:#fff;width:100px\">Paid at People's  <br/>Bank Branch</td><td style=\"background-color:#fff;width:250px\"></td></tr></table></td><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td style=\"background-color:#fff;width:150px\">Paid Bank  <br/>Branch Code  <br/></td><td style=\"background-color:#fff;width:100px\"></td></tr></table></td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>Paid in credit of UCSC EXTERNAL DEGREE PROGRAMME-PEOPLE'S BANK,THIMBIRIGASYAYA - AC No. 086-1001-111-89667</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td>AMOUNT PAID :</td><td>1,800.00</td></tr><tr><td>AMOUNT IN WORDS :</td><td>SRI LANKAN RUPEES ONE THOUSAND EIGHT HUNDRED ONLY</td></tr></table><table style='font-family:\"Courier New\",Courier,monospace;font-size:75%'><tr><td style=\"width:300px\"><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>..............................  <br/>CASH DEPOSITER'S SIGNATURE</td></tr></table></td><td><u>Instruction to Bank</u>  <br/>Please do not accept unless the cage below is filled</td></tr><tr><td><table style=\"border:0;background-color:#000\"><tr style=\"background-color:#fff\"><td>  <br/>  <br/>..............................  <br/>CASHIER'S SIGNATURE</td></tr></table></td><td><table style=\"background-color:#fff;border:1px #000 solid;font-size:80% ; width:85%\"\"><tr><td>Applicant's Full Name</td><td><b>ATHTHANAYAKE MUDIYANSELAGE ALUTH GEDARA THIRANJA VIDUNADI ATHTHANAYAKE</b></td></tr><tr><td>Applicantion Number</td><td><b>22N003895</b></td></tr><tr><td>Applicant's NIC No.</td><td><b>925012848V</b></td></tr></table></td></tr></table><hr><h6>DO NOT WRITE ANYTHING BELOW THIS LINE</h6>"));

            document.open();
            InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
            document.close();
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

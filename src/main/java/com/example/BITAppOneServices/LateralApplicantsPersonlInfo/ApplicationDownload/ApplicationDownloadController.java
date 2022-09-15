package com.example.BITAppOneServices.LateralApplicantsPersonlInfo.ApplicationDownload;


import com.example.BITAppOneServices.LateralApplicantsPersonlInfo.PaymentVoucher.PaymentVoucherServiceImpl;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class ApplicationDownloadController {


    @Autowired
    private ApplicationDownloadServiceImpl applicationDownloadServiceImpl;
    // Read operation
    @GetMapping(value="/get_application/{application_no}",produces= MediaType.APPLICATION_PDF_VALUE)
    public  @ResponseBody
    byte[]  print(@PathVariable("application_no") String application_no) {

        try {

            OutputStream file =applicationDownloadServiceImpl.generateApplicationPDF(application_no);

            String filename = "PaymentVouchers/"+application_no + "_application.pdf";
            FileInputStream fis= new FileInputStream(new File(filename));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.writeTo(file);

            return targetArray;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

//            File deleteBarcode = new File("PaymentVouchers/" + application_no + "_barcode.jpg");
//            boolean success2 =deleteBarcode.delete();

//            File deleteVoucherImage1 = new File("PaymentVouchers/" + application_no + "_1.jpg");
//            deleteVoucherImage1.delete();
//            File deleteVoucherImage2 = new File("PaymentVouchers/" + application_no + "_2.jpg");
//            deleteVoucherImage2.delete();

        }
        return null;
    }








   public void myhtml(){


       String mystring = "<table style=\"border:0;background-color:#424242;width:100%;margin-bottom:3%\"><tr style=\"background-color:#fff\"><td><span>1. Name in Full:</span><br><span style=\"padding-left:10%\">aaaaaaaaeeeeeeeeeeeeeeeeeee</span><br><span>2. Name with Initials:</span><br><span style=\"padding-left:10%\">aaaaaaaaeeeeeeeeeeeeeeeeeee</span></td></table><table style=\"border:0;background-color:#424242;width:100%;margin-bottom:3%\"><tr style=\"background-color:#fff;border:0 #fff\"><td style=\"border:0\"><span style=\"padding-top:5%\">3. Title:</span><br><span style=\"padding-left:10%;color:red\">Female</span></td><td style=\"border:0\"><span style=\"padding-top:5%\">4. Gender:</span><br><span style=\"padding-left:10%;color:red\">Ms.</span></td><td style=\"border:0\"><span style=\"padding-top:5%\">5. Citizenship:</span><br><span style=\"padding-left:10%;color:red\">Sri Lankan</span></td><td style=\"border:0\"><span style=\"padding-top:5%\">6. Nationality:</span><br><span style=\"padding-left:10%;color:red\">Sri Lankan</span></td></tr></table><table style=\"border:0;background-color:#424242;width:100%;margin-bottom:3%\"><tr style=\"background-color:#fff\"><td><span style=\"padding-top:5%\">7. National ID No:</span><br><span style=\"padding-left:10%;color:red\">kkkkkkkkk</span><br><span>8. Date of Birth:</span><br><span style=\"padding-left:10%\">aaaaaaaaeeeeeeeeeeeeeeeeeee</span></td></tr></table><table style=\"border:0;background-color:#424242;width:100%;margin-bottom:3%\"><tr style=\"background-color:#fff\"><td><span>10. Contact Details:</span><br><span style=\"padding-left:10%\">(a)Permanant Address</span><br><span style=\"padding-left:10%\">(b)Country</span><br><span style=\"padding-left:10%\">(c)Mobile</span></td></tr></table>";
   }
}

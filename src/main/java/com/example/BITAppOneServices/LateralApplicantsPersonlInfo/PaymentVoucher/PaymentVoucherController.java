package com.example.BITAppOneServices.LateralApplicantsPersonlInfo.PaymentVoucher;


import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.*;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class PaymentVoucherController {

    @Autowired
    private PaymentVoucherServiceImpl paymentVoucherServiceImpl;
    // Read operation
    @GetMapping(value="/get_payment_voucher/{application_no}",produces= MediaType.APPLICATION_PDF_VALUE)
    public  @ResponseBody byte[]  print(@PathVariable("application_no") String application_no) {

        try {

            OutputStream file =paymentVoucherServiceImpl.generatePaymentVoucherPDF(application_no);

            String filename = "PaymentVouchers/"+application_no + "_payment_voucher.pdf";
            FileInputStream fis= new FileInputStream(new File(filename));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.writeTo(file);

            return targetArray;
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            File deleteVoucher = new File("PaymentVouchers/" + application_no + "_payment_voucher.pdf");
            boolean success1 = deleteVoucher.delete();
            System.out.println(success1);
            File deleteBarcode = new File("PaymentVouchers/" + application_no + "_barcode.jpg");
            boolean success2 =deleteBarcode.delete();
            System.out.println(success2);
        }
        return null;
    }
}

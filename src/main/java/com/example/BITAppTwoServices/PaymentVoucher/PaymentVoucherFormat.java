package com.example.BITAppTwoServices.PaymentVoucher;


import com.itextpdf.html2pdf.HtmlConverter;

import java.io.*;
import java.io.IOException;

public class PaymentVoucherFormat {

    public static void main(String[] args) throws IOException {

       // HtmlConverter.convertToPdf(new File("com/example/BITAppOneServices/PaymentVoucher/pdf_input.html"),new File("com/example/BITAppOneServices/PaymentVoucher/demo-html.pdf"));

       HtmlConverter.convertToPdf(new File("C:/Users/User/Desktop/pdf_input.html"),new File("C:/Users/User/Desktop/demo-html.pdf"));


         
    }
}

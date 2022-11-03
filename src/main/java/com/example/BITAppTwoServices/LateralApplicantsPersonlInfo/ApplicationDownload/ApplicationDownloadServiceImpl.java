package com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.ApplicationDownload;


import com.example.BITAppTwoServices.Images.ImageModel;
import com.example.BITAppTwoServices.Images.ImagesRepository;
import com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfo;
import com.example.BITAppTwoServices.LateralApplicantsPersonlInfo.LateralApplicantsPersonlInfoRepository;
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
import java.util.Objects;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@Service
public class ApplicationDownloadServiceImpl {

    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    public OutputStream generateApplicationPDF(String application_no) {

        LateralApplicantsPersonlInfo applicationInfor = lateralApplicantsPersonlInfoRepository.findByApplicationNo(application_no);
        if (applicationInfor != null) {
            String full_name = applicationInfor.getFull_name();
            String name_marking = applicationInfor.getName_marking();
            String initials = applicationInfor.getInitials();

            String title_code = applicationInfor.getTitle();
            String title = "";
            switch (title_code) {
                case "1":
                    title = "Rev.";
                    break;
                case "2":
                    title = "Dr.";
                    break;
                case "3":
                    title = "Mr.";
                    break;
                case "6":
                    title = "Ms.";
                    break;

            }
            String gender_code = applicationInfor.getGender();
            String gender = "";
            switch (gender_code) {
                case "1":
                    gender = "Male";
                    break;
                case "2":
                    gender = "Female";
                    break;

            }

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

            String qualification_type = applicationInfor.getQualification_type();
            String qualification_pending = applicationInfor.getQualification_pending();
            String need_different_req = applicationInfor.getNeed_different_req();
            String al_year = applicationInfor.getAl_year();
            String al_index_no = applicationInfor.getAl_index_no();
            String al_type = applicationInfor.getAl_type();

            String al_subject1 = applicationInfor.getAl_subject1();
            String al_result1 = applicationInfor.getAl_result1();

            String al_subject2 = applicationInfor.getAl_subject2();
            String al_result2 = applicationInfor.getAl_result2();

            String al_subject3 = applicationInfor.getAl_subject3();
            String al_result3 = applicationInfor.getAl_result3();

            String al_subject4 = applicationInfor.getAl_subject4();
            String al_result4 = applicationInfor.getAl_result4();

            String ol_year1 = applicationInfor.getOl_year1();
            String ol_subject1 = applicationInfor.getOl_subject1();
            String ol_result1 = applicationInfor.getOl_result1();
            String ol_index1 = applicationInfor.getOl_index1();

            String ol_year2 = applicationInfor.getOl_year2();
            String ol_subject2 = applicationInfor.getOl_subject2();
            String ol_result2 = applicationInfor.getOl_result2();
            String ol_index2 = applicationInfor.getOl_index2();

            String fit_registration_no = applicationInfor.getFit_registration_no();
            String fit_year = applicationInfor.getFit_year();

            String amount = applicationInfor.getAmount();
            String paid_date = applicationInfor.getPaid_date();

            String bank = applicationInfor.getBank();
            String bank_branch = applicationInfor.getBank_branch();
            String type = applicationInfor.getType();


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

                // voucher image one
                String voucherImage1Path = "PaymentVouchers/" + application_no + "_1.jpg";

                Optional<ImageModel> voucherImage1Model = imagesRepository.findByName(application_no + "_1.jpg");
                if (voucherImage1Model.isPresent()) {

                    byte[] picByte1 = decompressBytes(voucherImage1Model.get().getPicByte());
                    BufferedImage voucherImage1 = ImageIO.read(new ByteArrayInputStream(picByte1));
                    File saveVoucherImage1 = new File(voucherImage1Path);
                    ImageIO.write(voucherImage1, "png", saveVoucherImage1);
                }


                // voucher image two
                String voucherImage2Path = "PaymentVouchers/" + application_no + "_2.jpg";

                Optional<ImageModel> voucherImage2Model = imagesRepository.findByName(application_no + "_2.jpg");
                if (voucherImage2Model.isPresent()) {

                    byte[] picByte2 = decompressBytes(voucherImage2Model.get().getPicByte());
                    BufferedImage voucherImage2 = ImageIO.read(new ByteArrayInputStream(picByte2));
                    File saveVoucherImage2 = new File(voucherImage2Path);
                    ImageIO.write(voucherImage2, "png", saveVoucherImage2);
                }

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


                StringBuilder htmlString = new StringBuilder();

                htmlString.append(new String("<table style=\"border:0px solid black; width:100%;margin-bottom:3% ;font-family:Times New Roman ;\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"border:0px solid\">  <img src=\"PaymentVouchers/" + application_no + "_barcode.jpg\" style=\"width:160px;height:40px ;text-align: left\"></img> <br/> &nbsp;&nbsp;" + application_no + "</td>\n" +
                        "    <td>" + sdf.format(timestamp) + "</td>\n" +
                        "  </tr>\n" +
                        "</table>"));
                htmlString.append(new String("<p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:0px solid black; width:100%;margin-bottom:30%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\" font-family:Times New Roman ;text-align: center;\">APPLICATION FOR THE DIPLOMA IN INFORMATION TECHNOLOGY OF THE BACHELOR OF INFORMATION TECHNOLOGY (BIT) DEGREE PROGRAMME - 2022  <br/>UNIVERSITY OF COLOMBO SCHOOL OF COMPUTING </td>\n" +
                        "  </tr>\n" +
                        "</table>"));
                htmlString.append(new String("<br/><p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080; width:100%;font-family:Times New Roman ;margin-top:10%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"width:30% ;font-size:14px; color: #404040 ;padding:5%\">1. Name in Full:</td>\n" +
                        "    <td style=\"padding:5%\">" + full_name + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td style=\"width:30% ; font-size:14px;color: #404040 ;padding:5%\">2. Name with Initials:</td>\n" +
                        "    <td style=\"padding:5%\">" + initials + " " + name_marking + "</td>\n" +
                        "  </tr>\n" +
                        "</table>"));

                htmlString.append(new String("<p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080;width:100%;margin-top:3%;font-family:Times New Roman;padding:5%\"><tr><td style=\"font-size:14px;color: #404040 ;padding:5%\">3. Title :</td><td style=\"text-align:left;padding:5%\">" + title + "</td><td style=\"font-size:14px;color: #404040 ;padding:5%\">4. Gender :</td><td style=\"text-align:left;padding:5%\">" + gender + "</td></tr><tr><td style=\"font-size:14px;color: #404040 ;padding:5%\">5. Citizenship :</td><td style=\"text-align:left;padding:5%\">" + citizenship + "</td><td style=\"font-size:14px;color: #404040 ;padding:5%\">6. Nationality :</td><td style=\"text-align:left;padding:5%\">" + nationality + "</td></tr><tr><td style=\"font-size:14px;color: #404040 ;padding:5%\">7. NIC Number :</td><td style=\"text-align:left;padding:5%\">" + id_no + "</td><td style=\"font-size:14px;color: #404040 ;padding:5%\">8. DoB :</td><td style=\"text-align:left;padding:5%\">" + dob + "</td></tr></table>"));
                htmlString.append(new String(" <p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080;width:100%;margin-top:3%;font-family:Times New Roman\"><tr><td style=\"font-size:14px;padding:5%\">10. Contact Details</td><td></td></tr><tr><td style=\"width:30%;font-size:14px;color: #404040 ;padding:5%\">(a) Permanent Address :</td><td style=\"padding:5%;word-wrap:break-word\"> " + full_address + "</td></tr><tr><td style=\"width:30%;font-size:14px;color: #404040 ;padding:5%\">(b) Country :</td><td style=\"padding:5%\">" + country + "</td></tr><tr><td style=\"width:30%;font-size:14px;color: #404040 ;padding:5%\">(c) Mobile :</td><td style=\"padding:5%\">" + mobile + "</td></tr><tr><td style=\"width:30%;font-size:14px;color: #404040 ;padding:5%\">(d) Land Phone :</td><td style=\"padding:5%\">" + phone + "</td></tr><tr><td style=\"width:30%;font-size:14px;color: #404040 ;padding:5%\">(e) E-mail :</td><td style=\"padding:5%\">" + email + "</td></tr></table>"));
                htmlString.append(new String(" <p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080; border-bottom:0px solid white ;width:100%;margin-bottom:3% ;font-family:Times New Roman ;margin-top:10%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"font-size:14px;padding:5%\">11. Education Qualification : </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td style=\"font-size:14px;color: #404040 ;padding:5%\">(a) Ordinary Level (O/L) Results : </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <table style=\"border:0px solid black; width:100%\">\n" +
                        "        <tr>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Subject</td>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Year</td>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Result</td>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Index</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_subject1 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_year1 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_result1 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_index1 + "</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_subject2 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_year2 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_result2 + "</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + ol_index2 + "</td>\n" +
                        "        </tr>\n" +
                        "      </table>\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>"));


                System.out.println("qualification_type   ->  " + qualification_type);
                if (Objects.equals(qualification_type, "1")) {
                    htmlString.append(new String("<table style=\"border:1px solid #808080;border-top:0px solid white;width:100%;margin-bottom:3%;font-family:Times New Roman ;margin-top:10% ;page-break-after:auto\">\n" +
                            "  <tr>\n" +
                            "    <td style=\"font-size:14px;color: #404040 ;padding:5%\">(b) Entry Qualification : </td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td style=\"padding:5%\"> I have passed the Advanced Level (A/L) exam </td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td style=\"color:#808080;padding:5%\">(c) Advanced Level (A/L) Results : </td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td>\n" +
                            "      <table style=\"border:0px solid black; width:100%\">\n" +
                            "  <tr>\n" +
                            "          <td style=\"width:40%\">\n" +
                            "            <table>\n" +
                            "              <tr>\n" +
                            "                <td style=\"width:20%;font-size:14px;color: #404040 ;padding:5%\">Year</td>\n" +
                            "                <td style=\"text-align:left;padding:5%\">" + al_year + "</td>\n" +
                            "              </tr>\n" +
                            "            </table>\n" +
                            "          </td>\n" +
                            "          <td style=\"width:40%\">\n" +
                            "            <table>\n" +
                            "              <tr>\n" +
                            "                <td style=\"width:20%;font-size:14px;color: #404040 ;padding:5%\">Index No</td>\n" +
                            "                <td style=\"text-align:left;padding:5%\">" + al_index_no + "</td>\n" +
                            "              </tr>\n" +
                            "            </table>\n" +
                            "          </td>\n" +
                            "        </tr> </table>" +

                            "      <table style=\"border:0px solid black; width:100%\">\n" +
                            "        <tr>\n" +
                            "          <td style=\"width:60%;font-size:14px;color: #404040 ;padding:5%\">Subject</td>\n" +
                            "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Result</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + al_subject1 + "</td>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + al_result1 + "</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td style=\"text-align:left;padding:5%\"> " + al_subject2 + "</td>\n" +
                            "          <td style=\"text-align:left;padding:5%\"> " + al_result2 + "</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td style=\"text-align:left;padding:5%\"> " + al_subject3 + "</td>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + al_result3 + " </td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + al_subject4 + " </td>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + al_result4 + "</td>\n" +
                            "        </tr>\n" +
                            "      </table>\n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>"));

                } else if (Objects.equals(qualification_type, "2")) {

                    htmlString.append(new String("<table style=\"border:1px solid #808080;border-top:0px solid white ; width:100%;margin-bottom:3%;font-family:Times New Roman ;margin-top:10% ;page-break-after:always\">\n" +
                            "  <tr>\n" +
                            "    <td style=\"font-size:14px;color: #404040 ;padding:5%\">(b) Entry Qualification : </td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td style=\"padding:5%\"> I have passed the FIT exam conducted by UCSC</td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td style=\"font-size:14px;color: #404040 ;padding:5%\">(c) FIT Information : </td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td>\n" +
                            "      <table style=\"border:0px solid black; width:100%\">\n" +
                            "        <tr>\n" +
                            "          <td style=\"width:30% ; font-size:14px;color: #404040 ;padding:5%\">FIT Year</td>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + fit_year + "</td>" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "         <td style=\"width:30% ; font-size:14px;color: #404040 ;padding:5%\">FIT Index</td>\n" +
                            "          <td style=\"text-align:left;padding:5%\">" + fit_registration_no + "</td>\n" +
                            "        </tr>\n" +
                            "      </table>\n" +
                            "    </td>\n" +
                            "  </tr>\n" +
                            "</table>"));
                }

                htmlString.append(new String("<p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080; width:100%;margin-top:30%;font-family:Times New Roman ;margin-top:10%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"font-size:14px;color: #404040 ;padding:5%\">12. Payment Details : </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <table style=\"border:0px solid black; width:100%\">\n" +
                        "        <tr>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5% ;width:30%\">Amount Paid:</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + amount + "</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Paid Date:</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + paid_date + "</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Paid Bank:</td>\n" +
                        "          <td style=\"text-align:left;padding:5%\">" + bank + " - " + bank_branch + "</td>\n" +
                        "        </tr>\n" +
                        "      </table>\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>"));

                if (Objects.equals(type, "1") && voucherImage1Model.isPresent() && voucherImage2Model.isPresent()) {

                    System.out.println("IMAGES in DB");
                    htmlString.append(new String("<p style=\" color:white\">space</p>"));
                    htmlString.append(new String("<table style=\"border:1px solid #808080; width:100%;margin-bottom:3%;font-family:Times New Roman ;margin-top:10%\">\n" +
                            "  <tr>\n" +
                            "    <td><img src=\" " + voucherImage1Path + "\" style=\"width:300px;height:400px \"></img> </td>\n" +
                            "    <td><img src=\" " + voucherImage2Path + "\" style=\"width:300px;height:400px \"></img></td>\n" +
                            "  </tr>\n" +
                            "</table>"));
                }


//                htmlString.append(new String("<p style=\" color:white\">space</p>"));
//                htmlString.append(new String("<table style=\"border:1px solid #666666; width:100%;margin-bottom:3%;font-family:Times New Roman ;margin-top:10%\">\n" +
//                        "  <tr>\n" +
//                        "    <td style=\"color:#808080;padding:5%;width:30%\">13. Is Differently-abled : </td>\n" +
//                        "    <td style=\"text-align:left;padding:5%\">" + disabilities + "</td>\n" +
//                        "</tr> </table>"));

                htmlString.append(new String("<p style=\" color:white\">space</p>"));
                htmlString.append(new String("<table style=\"border:1px solid #808080; width:100%;margin-bottom:3%;font-family:Times New Roman ;margin-top:10%\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"text-align:center; padding:5%\">DECLARATION </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td style=\"text-align: justify;\n" +
                        "  text-justify: inter-word;padding:5%\">I do hereby certify that the above particulars furnished by me are true and correct. In the event of my application for registration being accepted,I shall abide by all the regulations governing external candidates of the University of Colombo School of Computing. I agree that the University has the right to cancel my registration at any time, either if I am found to have furnished false information or if I do not abide by the regulations governing external candidates of the University of Colombo School of Computing. <br/><br/> </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <table>\n" +
                        "        <tr>\n" +
                        "          <td style=\"width:30%;;text-align:center\">..................................</td>\n" +
                        "          <td style=\"width:70%;text-align:center\">...............................................</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "          <td style=\"width:30%;;text-align:center\">Date</td>\n" +
                        "          <td style=\"width:70%;text-align:center\">Signature of the Applicant</td>\n" +
                        "        </tr>\n" +
                        "      </table>\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>"));

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


    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}


//                            "        <tr>\n" +
//                            "          <td style=\"font-size:14px;color: #404040 ;width:70%; padding:5%\">Year</td>\n" +
//                            "          <td style=\"text-align:left;padding:5%\">" + al_year + "</td>\n" +
//                            "        </tr>\n" +
//                            "        <tr>\n" +
//                            "          <td style=\"font-size:14px;color: #404040 ;padding:5%\">Index No</td>\n" +
//                            "          <td style=\"text-align:left;padding:5%\">" + al_index_no + "</td>\n" +
//                            "        </tr>\n" +
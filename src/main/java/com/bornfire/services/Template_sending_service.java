package com.bornfire.services;
import com.bornfire.entities.BAJAccountLedgerRepo;
import com.bornfire.entities.BAJAccountLedger_Entity;
import com.bornfire.entities.CandEvalFormEntity;
import com.bornfire.entities.CandEvalFormRep;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Template_sending_service {
	@Autowired
	BAJAccountLedgerRepo bAJAccountLedgerRepo;
	@Autowired
    CandEvalFormRep CandEvalFormRep;
    @Autowired
  	Environment env;
    @Autowired
	DataSource srcdataSource;

    public String sendingmail(String from, String host, String to, String cc, String username, String password, String ref_no,String fromDate,String toDate) throws IOException, JRException, SQLException {

        // Set up the properties for SMTP configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Port for TLS/STARTTLS
        properties.put("mail.smtp.auth", "true"); // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        // Get the session object for authenticating SMTP connection
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage for the email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // Set email sender
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // Add recipient
            message.setSubject("BANK OF BARODA - STATEMENT"); // Set subject of the email

            // Add CC recipients if provided
            if (cc != null && !cc.isEmpty()) {
                String[] ccAddresses = cc.split(",");
                for (String ccAddress : ccAddresses) {
                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(ccAddress));
                }
            }

            // Create a multipart container for email content (text, images, attachments)
            MimeMultipart multipart = new MimeMultipart();

            // Add text part for company introduction
            MimeBodyPart textPart = new MimeBodyPart();
             // Add this body part to the multipart
            

            // Fetch candidate evaluation form data using ref_no from database
            List<BAJAccountLedger_Entity> place = bAJAccountLedgerRepo.getaccnodata(ref_no);

            // Iterate through the candidate list to generate personalized email content
            for (BAJAccountLedger_Entity att : place) {

                // Create another multipart for the candidate-specific email content
                MimeMultipart multipart2 = new MimeMultipart();

                // Create a body part for the HTML text content
                MimeBodyPart textPart2 = new MimeBodyPart();

                // Use StringBuilder to build the HTML content dynamically
                StringBuilder htmlContent1 = new StringBuilder();

                htmlContent1.append("<p>Dear ").append(att.getCustomer_name()).append(",</p>")
                .append("<p>Your Bank of Baroda e-statement is now being sent to you as a PDF document.</p>")
                .append("<p>To open this file, you need Adobe Acrobat Reader. If you do not have Adobe Acrobat Reader, please visit the following link to download it: <a href='https://www.adobe.com/products/acrobat/readstep2.html' target='_blank'>www.adobe.com/products/acrobat/readstep2.html</a></p>")
                .append("<p>Please enter one of the following options as a password to view your e-mail account statement:</p>")
                .append("<p>You require an 8-character password. The first four letters of your password are the first 4 letters of the title of your account, followed by your date and month of birth or date and month of incorporation in the case of a current account (in DDMM format). The password is case-sensitive (lowercase). Please do not include any special characters, spaces, or salutations (if any). In the case of a joint account, the details of the first account holder need to be entered in the above-mentioned format.</p>")
                .append("<p>For example, if your account is in the name of Sujit Sawant and your date & month of birth is 05th January, your password will be <b>suji0501</b>. If the title of your account (current account) is ABC Enterprises and the date of incorporation is 05th January, then your password will be <b>abce0501</b>.</p>")
                .append("<p><strong>OR</strong></p>")
                .append("<p>Please enter the 12-digit account number as the password, with the last 2 digits mentioned in the subject line of this email.</p>")
                .append("<p>Add <a href='mailto:ponprasanth.t@bornfire.co.in'>estatements@icicibank.com</a> to your whitelist / safe sender list by clicking here. Otherwise, your mailbox filter or ISP (Internet Service Provider) may prevent you from receiving your e-mail account statement.</p>")
                .append("<p>As per Rule 9B of the Prevention of Money Laundering (Maintenance of Records) Rules, you are required to inform us regarding any change/s in your KYC details and submit the updated documents (i.e., address, contact details, profile, etc.) within 30 days from the date the change was made. Once informed, we will update our records accordingly. Any modifications can be communicated to Bank of Baroda through the bank's available channels.</p>")
                .append("<p><b>Sincerely</b>,<br><br>Team Bank of Baroda</p>");
                // Set the text as HTML content
               // textPart2.setText(htmlContent1.toString(), "UTF-8", "html");
              //  multipart2.addBodyPart(textPart2); // Add this HTML content part

                // Add company logo as inline image
                try {
                    MimeBodyPart imagePart = new MimeBodyPart();
                    InputStream logoStream = getClass().getResourceAsStream("/static/images/Picture1.jpg");
                    if (logoStream != null) {
                        byte[] imageData = readAllBytes(logoStream); // Read the image bytes
                        imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(imageData, "image/jpeg")));
                        imagePart.setHeader("Content-ID", "<logo>");
                        multipart2.addBodyPart(imagePart);

                        // Reference the logo in HTML
                        htmlContent1.append("<img src='cid:logo' alt='Bornfire Logo' width='100' height='50' /><br>");
                    } else {
                        System.err.println("Error loading Picture1.jpg from classpath.");
                    }
                } catch (Exception e) {
                    System.err.println("Error loading Picture1.jpg: " + e.getMessage());
                }

                // Add the rest of the email content (footer, HR contact details, etc.)
                StringBuilder htmlContent2 = new StringBuilder();
                htmlContent2.append("<p>HR Executive</p>")
                .append("<p>Bornfire Innovations Private Limited<br>")
                .append("10, Soundaraiyar Street, Ammapet, Salem - 636003 Tamilnadu, India</p>")
                .append("<p>Land Line: +91 44 24650400</p>")
                .append("<p><a href='http://bornfire.in'>http://bornfire.in</a></p>")
                .append("<p>Disclaimer: The information in this mail is confidential...</p>"); // Continue with contact details

                // Add another inline image (if needed)
                try {
                    MimeBodyPart imagePart1 = new MimeBodyPart();
                    InputStream logoStream1 = getClass().getResourceAsStream("/static/images/logo.png");
                    if (logoStream1 != null) {
                        byte[] imageData1 = readAllBytes(logoStream1); // Read second image bytes
                        imagePart1.setDataHandler(new DataHandler(new ByteArrayDataSource(imageData1, "image/png")));
                        imagePart1.setHeader("Content-ID", "<logo1>");
                        multipart2.addBodyPart(imagePart1);

                        htmlContent2.append("<img src='cid:logo1' alt='Bornfire Logo' width='100' height='70' /><br>");
                    } else {
                        System.err.println("Error loading logo.png from classpath.");
                    }
                } catch (Exception e) {
                    System.err.println("Error loading logo.png: " + e.getMessage());
                }

                // Add the footer to the email
                htmlContent2.append("<p><a href='http://bornfire.in'>http://bornfire.in</a></p>")
                .append("<p>Disclaimer: The information in this mail is confidential and is intended solely for the addressee. Access to this mail by anyone else is unauthorized. Copying or further distribution beyond the original recipient may be unlawful. We are not responsible for any damage caused by a virus or alteration of the e-mail by a third party or otherwise. The contents of this message may not necessarily represent the views or policies of Bornfire Innovations.</p>")
                .append("<p>Thank you for considering this offer, and we look forward to your positive response.</p>");

                // Create a MimeBodyPart for the full HTML content
                MimeBodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(htmlContent1.toString() + htmlContent2.toString(), "text/html");

                // Add the HTML part to the multipart2
                multipart2.addBodyPart(htmlPart);

                // Add each body part from multipart2 to multipart
                for (int i = 0; i < multipart2.getCount(); i++) {
                    multipart.addBodyPart(multipart2.getBodyPart(i));
                }
            }
            
            BAJAccountLedger_Entity value = bAJAccountLedgerRepo.getaccno(ref_no);
    		String tempdata = value.getAccount_type();

    		String account_name = value.getAcct_name(); // Retrieve the account name
    		Date date_of_birth = value.getDate_of_birth(); // Retrieve the date of birth

    		// Extract the first four letters of the account name
    		String namePart = account_name.substring(0, Math.min(account_name.length(), 4)).toUpperCase();

    		// Format the date of birth to extract the first four numbers (DDMM)
    		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMM");
    		String datePart = dateFormat.format(date_of_birth);

    		// Combine namePart and datePart to generate the password
    		String password1 = namePart + datePart;
    		String password2 = value.getAcct_num();

    		// Set the password string variable
    		System.out.println("Generated Password: " + password1);
    		
    		String temp_ids;
    		if ("SBA".equals(tempdata)) {
    			temp_ids = "SBA001";
    			System.out.println("Savings account present: " + temp_ids);
    		} else if ("CAA".equals(tempdata)) {
    			temp_ids = "CAA001";
    			System.out.println("Current account present: " + temp_ids);
    		} else {
    			temp_ids = ""; // Assign a default value if no condition matches
    			System.out.println("No account type matched. Default template ID: " + temp_ids);
    		}

         // Add attachments: Appointment Letter and Salary Structure
            List<BAJAccountLedger_Entity> places = bAJAccountLedgerRepo.getaccnodata(ref_no);
            
            // Assuming you have a valid connection object (e.g., from a DataSource)
            Connection connection = srcdataSource.getConnection();  // Adjust based on your actual data source
            
            InputStream jasperStream = this.getClass().getResourceAsStream("/static/jasper/statement_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
            Map<String, Object> params = new HashMap<>();
            params.put("ACCT_NO", ref_no); // Account number
    		params.put("FROM_DATE", fromDate); // From date
    		params.put("TO_DATE", toDate); // To date
    		params.put("TEMPLATE_ID", temp_ids); // Template ID derived from tempdata
    		// Generate report
    		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);
            byte[] pdfContent = JasperExportManager.exportReportToPdf(jasperPrint);
            
         // Encrypt the PDF with a password using iText
            ByteArrayOutputStream encryptedPdfOutputStream = new ByteArrayOutputStream();
            try {
                // Initialize PdfReader with the original PDF content
                PdfReader reader = new PdfReader(new ByteArrayInputStream(pdfContent));
                
                // Create PdfStamper to apply encryption
                PdfStamper stamper = new PdfStamper(reader, encryptedPdfOutputStream);

                // Set the user and owner password for encryption
                String userPassword = password1;  // User password to open the PDF
                String ownerPassword = password2;  // Owner password for advanced permissions (optional)

                // Apply encryption to allow printing but not copying
                stamper.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);

                // Close the stamper and reader to finalize encryption
                stamper.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "PDF Encryption Failed";
            }

            

            
         // Use the encrypted PDF for the attachment
            byte[] encryptedPdfContent = encryptedPdfOutputStream.toByteArray();
            String attachmentName = "BOB-Estatement-" + ref_no + ".pdf";
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(new ByteArrayDataSource(encryptedPdfContent, "application/pdf")));
            attachmentPart.setFileName(attachmentName);
            multipart.addBodyPart(attachmentPart);

            // Set the full multipart content in the email message
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            // Return success message
            return "Mail Sent Successfully";

        } catch (MessagingException mex) {
            mex.printStackTrace();
            return "Mail Sending Failed";
        }
    }

    // Utility method to read the bytes of an input stream
    private byte[] readAllBytes(InputStream inputStream) throws IOException {
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        }
    }

}

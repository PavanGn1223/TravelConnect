package com.Bus.Ticket.Booking.Operator.Util;

import com.Bus.Ticket.Booking.User.PayLoad.BookingDetailsDto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PdfGenerator {

    public static byte[] generateBookingConfirmationPdf(BookingDetailsDto bookingDetails) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);

            // Add custom fonts for better styling
            BaseFont baseFont = BaseFont.createFont("Helvetica", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
            Font titleFont = new Font(baseFont, 18, Font.BOLD);
            Font subtitleFont = new Font(baseFont, 14, Font.BOLD);
            Font normalFont = new Font(baseFont, 12);

            document.open();

            // Title
            Paragraph title = new Paragraph("Booking Confirmation", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // Booking details
            addEmptyLine(document, 1);
            document.add(new Paragraph("Booking ID: " + bookingDetails.getBookingId(), subtitleFont));
            document.add(new Paragraph("Bus Company: " + bookingDetails.getBusCompany(), normalFont));
            document.add(new Paragraph("Bus Number: " + bookingDetails.getBusNumber(), normalFont));
            document.add(new Paragraph("From City: " + bookingDetails.getFromCity(), normalFont));
            document.add(new Paragraph("To City: " + bookingDetails.getToCity(), normalFont));
            document.add(new Paragraph("Departure Date: " + bookingDetails.getDepartureDate(), normalFont));

            // Passenger details
            addEmptyLine(document, 1);
            document.add(new Paragraph("Passenger: " + bookingDetails.getFirstName() + " " + bookingDetails.getLastName(), normalFont));
            document.add(new Paragraph("Email: " + bookingDetails.getEmail(), normalFont));
            document.add(new Paragraph("Mobile: " + bookingDetails.getMobile(), normalFont));

            // Price details
            addEmptyLine(document, 1);
            document.add(new Paragraph("Price: " + bookingDetails.getPrice(), subtitleFont));

            // Add more details as needed

            document.close();
            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return null;
        }
    }

    private static void addEmptyLine(Document document, int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            document.add(new Paragraph(" "));
        }
    }
}

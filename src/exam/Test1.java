package exam;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
 import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class Test1 {
    public static void main(String[] args) throws DocumentException, IOException {
        // Keyword to search for
String keyword = "match";
        // Create a folder to store the matching keyword files
String folderName = "matching_keyword_files";
java.io.File folder = new java.io.File(folderName);
        folder.mkdir();
        // Create 100 PDF documents
        for (int i = 1; i <= 100; i++) {
            // Create a new PDF document
Document document = new Document();
PdfWriter.getInstance(document, new FileOutputStream("document" + i + ".pdf"));
            document.open();
            // Add text to the document
String text = "This is document number " + i;
            document.add(new Paragraph(text));
            // Check if the keyword is present in the text
            if (text.contains(keyword)) {
                // If the keyword is present, move the file to the matching keyword folder
java.io.File file = new java.io.File("document" + i + ".pdf");
                file.renameTo(new java.io.File(folderName + "/" + "document" + i + ".pdf"));
}
            // Close the document
            document.close();
}
}
}
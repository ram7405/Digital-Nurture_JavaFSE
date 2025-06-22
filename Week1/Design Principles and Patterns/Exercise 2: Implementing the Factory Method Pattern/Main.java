

public class Main {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Process documents
        System.out.println("=== Processing Documents ===");
        wordFactory.processDocument();
        pdfFactory.processDocument();
        excelFactory.processDocument();
    }
}

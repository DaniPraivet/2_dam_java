package AD.Practica2;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class XSLTFormatter {
    private static final String XML_ARCHIVO = "src/main/java/AD/Practica2/ejemplo3.xml";
    private static final String XSLT_ARCHIVO = "src/main/java/AD/Practica2/ejemplo3.xsl";
    private static final String HTML_ARCHIVO = "src/main/java/AD/Practica2/ejemplo3.html";

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try (InputStream is = new FileInputStream(XML_ARCHIVO)) {

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            try (FileOutputStream output = new FileOutputStream(HTML_ARCHIVO)) {
                transform(doc, output);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transform(Document doc, FileOutputStream output) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(new File(XSLT_ARCHIVO)));

            transformer.transform(new DOMSource(doc), new StreamResult(output));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

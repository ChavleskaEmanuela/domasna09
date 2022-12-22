package zadaca02;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {
public void createXMLFile (String fileName) {
		Vraboten v = new Vraboten("Stefan", "Stefanovski", "10000");
		Vraboten v1 = new Vraboten("Aleksandar", "Ristevski", "15000");
		try {
			
			DocumentBuilderFactory documentBuilderFactory =	DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.newDocument();
			
			Element root = document.createElement("Vraboteni");
			document.appendChild(root);
			
			Element vElement = document.createElement("Vraboten");
			root.appendChild(vElement);
			
			Element ime = document.createElement("Ime");
			vElement.appendChild(ime);
			
			Element prezime = document.createElement("Prezime");
			vElement.appendChild(prezime);
	
			Element plata = document.createElement("Plata");
			vElement.appendChild(plata);
			
			ime.appendChild(document.createTextNode(v.getIme()));
			prezime.appendChild(document.createTextNode(v.getPrezime()));
			plata.appendChild(document.createTextNode(v.getPlata()));
			

			Element vElement1 = document.createElement("Vraboten");
			root.appendChild(vElement1);
			
			Element ime1 = document.createElement("Ime");
			vElement1.appendChild(ime1);
			
			Element prezime1 = document.createElement("Prezime");
			vElement1.appendChild(prezime1);
			
			Element plata1 = document.createElement("Plata");
			vElement1.appendChild(plata1);
			
			
			ime.appendChild(document.createTextNode(v.getIme()));
			prezime.appendChild(document.createTextNode(v.getPrezime()));
			plata.appendChild(document.createTextNode(v.getPlata()));
			
			
			ime1.appendChild(document.createTextNode(v1.getIme()));
			prezime1.appendChild(document.createTextNode(v1.getPrezime()));
			plata1.appendChild(document.createTextNode(v1.getPlata()));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(document);
			
			StreamResult result = new StreamResult(new File(fileName));
			
			StreamResult result1 = new StreamResult(System.out);
			transformer.transform(source, result);
			System.out.println("Fajlot e kreiran, imeto e: "+ fileName);

			System.out.println(result1);
			System.out.println("Fajlot e zachuvan.");
			} catch (Exception e) {
			System.out.println(e.toString());
			}
			}
			
		
	}


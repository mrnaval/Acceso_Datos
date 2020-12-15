package parse_libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Libro> libro = null;
	
	public Parser() {
		libro = new ArrayList<Libro>();
	}
	
	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}	
		
	}
	
	public void parseDocument() {
		//Se obtiene el elemento raíz
		Element docEle = dom.getDocumentElement();
		
		//Se obtiene el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (persona)
				Element el = (Element) nl.item(i);

				// obtenemos una persona
				Libro l = getLibro(el);

				// lo añadimos al array
				libro.add(l);
			}
		}
	}
	
	private Libro getLibro(Element libroEle){
		
		//para cada elemento persona, obtenemos su nombre y su edad
		String titulo = getTextValue(libroEle,"titulo");
		   int anyo = getIntValue(libroEle,"anyo");
		String nombre = getTextValue(libroEle,"nombre");
		String apellido = getTextValue(libroEle,"apellido");
		String editor = getTextValue(libroEle,"editor");
		   int paginas = getIntValue(libroEle,"paginas");
		
		//Creamos una nueva persona con los elementos leídos del nodo
		Libro e = new Libro(titulo,anyo,nombre,apellido,editor,paginas);	

		return e;				
	}
	
	private String getTextValue(Element elem, String tagName) {
		String textVal = null;
		NodeList nl = elem.getElementsByTagName(tagName);
		
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element elem, String tagName) {				
		return Integer.parseInt(getTextValue(elem,tagName));
	}
	

	public void print() {
		// TODO Auto-generated method stub
		Iterator it = libro.iterator();
		while(it.hasNext()) {
			Libro l = (Libro) it.next();
			l.print();
		}
	}
	
	
	
	
	
	
	
}

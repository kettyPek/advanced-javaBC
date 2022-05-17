package ajbc.basicOperations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Runner {

	public static void main(String[] args) {
		
		List<Car> cars = new ArrayList<Car>();
		
		cars.add(new Car("Subaru","B4",2006,new LicencePlate(123456789,"yellow")));
		cars.add(new Car("FolksWagen","GOLF",2014,new LicencePlate(456789123,"yellow")));
		cars.add(new Car("FolksWagen","PASSAT",2016,new LicencePlate(789456123,"yellow")));
		
//		svaeListToXML(cars);
		
		List<Car> carsFromXML = parseXMLtoList ();
		carsFromXML.forEach(car -> System.out.println(car));

	}
	
		
	public static void svaeListToXML(List<Car> carslist) {
		try {
		
			Element carsElement = new Element("cars");
			Document carsDocumant = new Document(carsElement);
			
			for(var car: carslist) {
				Element carElement = new Element("car");
				Element manufacturerElement = new Element("manufacturer");
				manufacturerElement.setText(car.getManufacturer());
				Element modelElement = new Element("model");
				modelElement.setText(car.getModel());
				Element yearElement = new Element("year");
				yearElement.setText(Integer.toString(car.getYear()));
				Element licencePlateElement = new Element("licencePlate");
				
				Element plateNumberElement = new Element("plateNumber");
				plateNumberElement.setAttribute(new Attribute("unique","true"));
				plateNumberElement.setText(Long.toString(car.getLicencePlate().getPLATE_NUMBER()));
				Element plateColorElement = new Element("plateColor");
				plateColorElement.setText(car.getLicencePlate().getColor());
				
				licencePlateElement.addContent(plateNumberElement);
				licencePlateElement.addContent(plateColorElement);
				
				carElement.addContent(manufacturerElement);
				carElement.addContent(modelElement);
				carElement.addContent(yearElement);
				carElement.addContent(licencePlateElement);
				
				carsDocumant.getRootElement().addContent(carElement);
			}
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			File outputFile = new File("myFiles/cars.xml");
			
			OutputStream outputStream = new FileOutputStream(outputFile);
			xmlOutput.output(carsDocumant, outputStream);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
				
	}
	
	public static List<Car> parseXMLtoList (){
		List<Car> cars = new ArrayList<Car>();
		
		try{
			File file = new File("myFiles/cars.xml");
			SAXBuilder asxBuilder = new SAXBuilder();
			Document doc = asxBuilder.build(file);
			
			Element carsElemet = doc.getRootElement();
			List<Element> carsList = carsElemet.getChildren();
			
			for(var element : carsList) {
				String manufacturer = element.getChild("manufacturer").getText();
				String model = element.getChild("model").getText();
				int year = Integer.parseInt(element.getChild("year").getText());
				
				Element licencePlateElement = element.getChild("licencePlate");
				long plateNumber = Long.parseLong(licencePlateElement.getChild("plateNumber").getText());
				String plateColor = licencePlateElement.getChild("plateColor").getText();
				
				cars.add(new Car(manufacturer,model,year,new LicencePlate(plateNumber,plateColor)));
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(JDOMException jdome){
			jdome.printStackTrace();
		}
		return cars;
	}

}

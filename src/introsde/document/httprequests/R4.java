package introsde.document.httprequests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import introsde.document.main.Client;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;
import introsde.document.ws.Person;

public class R4 {
	public static long id;

	static public void createPerson() throws DatatypeConfigurationException, ParseException, IOException {
		//set an xmlgregorian calendar data
		//java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 01:00:00");
		Date dob=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dob=df.parse( "1967-09-27 11:15:00" );
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dob);
		XMLGregorianCalendar xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		//create a new person and set the fields
		introsde.document.ws.Person person = new Person();
		person.setFirstname("Francesco");
		person.setLastname("Totti");
		person.setBirthdate(xmlDate2);
		/*
		 * introsde.document.ws.HealthProfile hp = new
		 * introsde.document.ws.HealthProfile(); MeasureDefinition weight= new
		 * MeasureDefinition(); weight.setIdMeasureDef(1);
		 * weight.setMeasureName("weight"); weight.setMeasureType("double");
		 * hp.setMeasureDefinition(weight); hp.setValue("110.6");
		 * person.setHealthProfile(introsde.document.ws.Person.HealthProfile.
		 * class.cast(hp) ); MeasureDefinition weight= new MeasureDefinition();
		 * weight.setIdMeasureDef(1); weight.setMeasureName("weight");
		 * weight.setMeasureType("double"); MeasureDefinition height= new
		 * MeasureDefinition(); weight.setIdMeasureDef(2);
		 * weight.setMeasureName("height"); weight.setMeasureType("double");
		 * 
		 * hp.setMeasureDefinition(weight);
		 * 
		 * 
		 * HealthProfile personhp= new HealthProfile(); personhp.getClass().
		 * 
		 * person.setHealthProfile((HealthProfile) hp);
		 */

		System.out.println("Request 4");
		System.out.println("Create a new person with the following setting values:");
		System.out.println("firstname: Francesco");
		System.out.println("lastname: Totti");
		System.out.println("birthdate: 27/09/1967");

		Client.wlog.write("\nRequest 4");
		Client.wlog.write("\nCreate a new person with the following setting values:");
		Client.wlog.write("\nfirstname: Francesco");
		Client.wlog.write("\nlastname: Totti");
		Client.wlog.write("\nbirthdate: 27/09/1967");
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();

		try {
			//save the new person in the db
			Person personCreated = people.createPerson(person);
			id = personCreated.getIdPerson();
			System.out.println("return statement of the update is the person created. The id is:" + id);
			System.out.println("\n");
			System.out.println("\n");
			Client.wlog.write("\nreturn statement of the update is the person created. The id is:" + id);
			Client.wlog.write("\n");
			Client.wlog.write("\n");
			// checkin if the add suceed
			if (personCreated == null) {
				System.out.println("People not created correctly");
				Client.wlog.write("\nPeople not created correctly");
			} else {
				System.out.println(
						"===============================================================================================================");
				Client.wlog.write(
						"\n===============================================================================================================");
				System.out.println("recall request 2 on the new id.");
				Client.wlog.write("\nrecall request 2 on the new id.");
				R2.readPerson(id);
			}
			
		} catch (Exception e) {
			Client.wlog.write("\nError ==> " + e);
			System.out.println("Error ==> " + e);
		}

	}
}

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


public class R3 {

	static public void updatePerson() throws DatatypeConfigurationException, IOException, ParseException {
		//set an xmlgregorian calendar date
		Date dob=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dob=df.parse( "2003-12-10 11:15:00" );
		GregorianCalendar cal = new GregorianCalendar();

		cal.setTime(dob);
		XMLGregorianCalendar xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		//create a new person and set the fields
		introsde.document.ws.Person personchange = new Person();
		personchange.setFirstname("Kobe");
		personchange.setLastname("Bryant");
		personchange.setBirthdate(xmlDate2);
		personchange.setIdPerson(1);

		System.out.println("Request 3");
		System.out.println("Update person with id 1 setting values:");
		System.out.println("firstname: Kobe");
		System.out.println("lastname: Bryant");
		System.out.println("birthdate:10/12/2003");
		Client.wlog.write("\nRequest 3");
		Client.wlog.write("\nUpdate person with id 1 setting values:");
		Client.wlog.write("\nfirstname: Kobe");
		Client.wlog.write("\nlastname: Bryant");
		Client.wlog.write("\nbirthdate:1/12/2003");
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		int id;
		try {
			//update the person in the db passing the person just created
			Person personresult = people.updatePerson(personchange);
			id = personresult.getIdPerson();
			System.out.println("retunrn statement of the update is the of the person updated. The id is:" + id);
			System.out.println("\n");
			System.out.println("\n");
			Client.wlog.write("\nretunrn statement of the update is the of the person updated. The id is:" + id);
			Client.wlog.write("\n");
			Client.wlog.write("\n");

		} catch (Exception e) {
			id = 0;
			System.out.println("Error ==> " + e);
			Client.wlog.write("\nError ==> " + e);
		}
		//checking if the update suceed
		if (id == 0) {
			System.out.println("Person updated not suceed");
			Client.wlog.write("\nPerson updated not suceed");
		} else {
			System.out.println("Recall request 2 to see the result of the update:");
			Client.wlog.write("\nRecall request 2 to see the result of the update:");
			R2.readPerson(id);
		}
		System.out.println(
				"===============================================================================================================");
		Client.wlog.write(
				"\n===============================================================================================================");
	}

}

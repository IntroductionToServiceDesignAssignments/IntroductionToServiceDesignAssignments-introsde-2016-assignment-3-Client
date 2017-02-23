package introsde.document.httprequests;

import java.io.IOException;
import java.util.List;

import introsde.document.ws.Person;
import introsde.document.ws.Person.HealthProfile;
import introsde.document.main.Client;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;

public class R2 {
	static public void readPerson(long id) throws IOException {
		System.out.println("Request 2");
		System.out.println("Read person with id=" + id);
		Client.wlog.write("\nRequest 2");
		Client.wlog.write("\nRead person with id=" + id);
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		try {
			//get the people with the given id
			Person person = people.readPerson(id);

			System.out.println("Result:");
			Client.wlog.write("\nResult:");
			//print out the person and his relative healtprofiles
			if (person == null) {
				System.out.println("Person with id:" + id + " doesn't exist in the database");
				Client.wlog.write("\nPerson with id:" + id + " doesn't exist in the database");
			} else {
				System.out.println("IdPerson ==> " + person.getIdPerson());
				System.out.println("firstname ==> " + person.getFirstname());
				System.out.println("lastname ==> " + person.getLastname());
				System.out.println("birthdate ==> " + person.getBirthdate());
				Client.wlog.write("\nIdPerson ==> " + person.getIdPerson());
				Client.wlog.write("\nfirstname ==> " + person.getFirstname());
				Client.wlog.write("\nlastname ==> " + person.getLastname());
				Client.wlog.write("\nbirthdate ==> " + person.getBirthdate());
				HealthProfile temphp = person.getHealthProfile();
				List<introsde.document.ws.HealthProfile> listhp = temphp.getMeasureType();

				for (introsde.document.ws.HealthProfile measure : listhp) {
					System.out.println("Measure id ==> " + measure.getIdMeasure());
					System.out.println("Measure type ==> " + measure.getMeasureDefinition().getMeasureName());
					System.out.println("Measure value ==> " + measure.getValue());
					System.out.println("\n");
					Client.wlog.write("\nMeasure id ==> " + measure.getIdMeasure());
					Client.wlog.write("\nMeasure type ==> " + measure.getMeasureDefinition().getMeasureName());
					Client.wlog.write("\nMeasure value ==> " + measure.getValue());
					Client.wlog.write("\n");
				}

				System.out.println("\n");
				System.out.println("\n");

				Client.wlog.write("\n");
				Client.wlog.write("\n");
			}
			System.out.println(
					"===============================================================================================================");
			Client.wlog.write(
					"\n===============================================================================================================");

		} catch (Exception e) {
			Client.wlog.write("\nError ==> " + e);
			System.out.println("Error ==> " + e);
		}

	}

}

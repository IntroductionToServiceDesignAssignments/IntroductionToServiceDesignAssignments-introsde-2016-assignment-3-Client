package introsde.document.httprequests;

import java.io.IOException;
import java.util.List;

import introsde.document.ws.Person;
import introsde.document.ws.Person.HealthProfile;
import introsde.document.main.Client;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;

public class R1 {
	static public void readPersonList() throws IOException {
		System.out.println("Request 1");
		Client.wlog.write("\nRequest 1");
		System.out.println("Read person list");
		Client.wlog.write("\nRead person list");
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		try {
			//list all the people present in the db
			List<Person> listpeople = people.readPersonList();
			System.out.println("Result:");
			//verify if the db has no people
			if (listpeople.size() == 0) {
				System.out.println("There is no person in the database");
				Client.wlog.write("\nThere is no person in the database");
			} else {
				for (Person temp : listpeople) {
					System.out.println("IdPerson ==> " + temp.getIdPerson());
					System.out.println("firstname ==> " + temp.getFirstname());
					System.out.println("lastname ==> " + temp.getLastname());
					System.out.println("birthdate ==> " + temp.getBirthdate());
					Client.wlog.write("\nIdPerson ==> " + temp.getIdPerson());
					Client.wlog.write("\nfirstname ==> " + temp.getFirstname());
					Client.wlog.write("\nlastname ==> " + temp.getLastname());
					Client.wlog.write("\nbirthdate ==> " + temp.getBirthdate());
					HealthProfile temphp = temp.getHealthProfile();
					List<introsde.document.ws.HealthProfile> listhp = temphp.getMeasureType();
					System.out.println("\n");
					Client.wlog.write("\n");
					//list all the healthProfile of the person related
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
			}
			System.out.println(
					"===============================================================================================================");
			Client.wlog.write(
					"\n===============================================================================================================");
		} catch (Exception e) {

			System.out.println("Error ==> " + e);
			Client.wlog.write("\nError ==> " + e);

		}

	}

}

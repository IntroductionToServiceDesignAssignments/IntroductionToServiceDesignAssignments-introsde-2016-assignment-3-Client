package introsde.document.httprequests;

import java.io.IOException;

import introsde.document.main.Client;
import introsde.document.ws.MeasureDefinition;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;

public class R10 {
	static public void updatePersonMeasure(long id, String measure) throws IOException {
		System.out.println("Request 10");
		System.out.println("Update health profile for person with id=" + id + " measure" + measure + " value = 50");
		Client.wlog.write("\nRequest 10");
		Client.wlog.write("\nUpdate health profile for person with id=" + id + " measure" + measure + " value = 50");
		System.out.println("Recall request 2 to see the fields before the update using id =" + id + " measure" + measure);
		Client.wlog.write("\nRecall request 2 to see the fields before the update using id =" + id + " measure" + measure);
		R2.readPerson(id);
		
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		try {
			// create and set a new HealthProfile
			introsde.document.ws.HealthProfile hp = new introsde.document.ws.HealthProfile();
			MeasureDefinition weight = new MeasureDefinition();
			weight.setIdMeasureDef(1);
			weight.setMeasureName(measure);
			weight.setMeasureType("double");
			hp.setMeasureDefinition(weight);
			hp.setValue("50");
			//update the measure identified with {m.mid}, related to the Person identified by {id}
			//check if the operation suceed and print out the result
			introsde.document.ws.HealthProfile newhp = people.updatePersonMeasure(id, hp);
			if (newhp == null) {
				System.out.println("HealthProfile not updated");
				Client.wlog.write("\nHealthProfile not updated");
			} else {
				
				System.out.println("HealthProfile updated correctly");
				Client.wlog.write("\nHealthProfile updated correctly");
				System.out.println("Measure id ==> " + newhp.getIdMeasure());
				System.out.println("Measure type ==> " + newhp.getMeasureDefinition().getMeasureName());
				System.out.println("Measure value ==> " + newhp.getValue());
				System.out.println("\n");
				Client.wlog.write("\nMeasure id ==> " + newhp.getIdMeasure());
				Client.wlog.write("\nMeasure type ==> " + newhp.getMeasureDefinition().getMeasureName());
				Client.wlog.write("\nMeasure value ==> " + newhp.getValue());
				Client.wlog.write("\n");
				
			}
			System.out.println("\n");
			System.out.println("\n");

			System.out.println(
					"===============================================================================================================");
			Client.wlog.write("\n");
			Client.wlog.write("\n");

			Client.wlog.write(
					"\n===============================================================================================================");
			System.out.println("Recall request 2 to see the fields after the update using id =" + id + " measure" + measure);
			Client.wlog.write("\nRecall request 2 to see the fields after the update using id =" + id + " measure" + measure);
			R2.readPerson(id);
		} catch (Exception e) {
			Client.wlog.write("\nError ==> " + e);
			System.out.println("Error ==> " + e);
		}

	}
}

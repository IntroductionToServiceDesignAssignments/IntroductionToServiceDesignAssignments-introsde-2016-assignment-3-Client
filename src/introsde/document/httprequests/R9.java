package introsde.document.httprequests;

import java.io.IOException;
import introsde.document.main.Client;
import introsde.document.ws.MeasureDefinition;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;


public class R9 {

	static public void savePersonMeasure(long id, String measure) throws IOException {
		System.out.println("Request 9");
		System.out.println("Insert a new health profile for" + measure + " for person with id:" + id + " value=100");
		System.out.println("The old health profile value will be inserted in the Hstory");
		Client.wlog.write("\nRequest 9");
		Client.wlog.write("\nInsert a new health profile for" + measure + " for person with id:" + id + " value=100");
		Client.wlog.write("\nThe old health profile value will be inserted in the Hstory");
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
			hp.setValue("100");
			//save the new healthprofile object {m} (e.g. weight) of Person identified by {id} and archive the old value in the history
			introsde.document.ws.HealthProfile newhp = people.savePersonMeasure(id, hp);
			//check if the operation suceed and print out the new healthprofile inserted
			if (newhp==null){System.out.println("Error something went wrong");}else{
			System.out.println("New health profile inserted");
			System.out.println("IdHealthProfile ==> " + newhp.getIdMeasure());
			System.out.println("Measure Type==> " + newhp.getMeasureDefinition().getMeasureName());
			System.out.println("Value==> " + newhp.getValue());
			Client.wlog.write("\nNew health profile inserted");
			Client.wlog.write("\nIdHealthProfile ==> " + newhp.getIdMeasure());
			Client.wlog.write("\nMeasure Type==> " + newhp.getMeasureDefinition().getMeasureName());
			Client.wlog.write("\nValue==> " + newhp.getValue());
			
			
			}
			
			System.out.println("\n");
			System.out.println("\n");

			System.out.println(
					"===============================================================================================================");
			Client.wlog.write("\n");
			Client.wlog.write("\n");

			Client.wlog.write(
					"\n===============================================================================================================");
			System.out.println("Recall request 6 to see if the history with old healthProfile value has been inserted ");
			Client.wlog.write("\nRecall request 6 to see if the history with old healthProfile value has been inserted");
			R6.readPersonHistory(id, measure);
		} catch (Exception e) {
			Client.wlog.write("\nError ==> " + e);
			System.out.println("Error ==> " + e);
		}

	}

}

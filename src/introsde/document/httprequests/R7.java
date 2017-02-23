package introsde.document.httprequests;

import java.io.IOException;
import java.util.List;

import introsde.document.main.Client;
import introsde.document.ws.MeasureDefinition;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;

public class R7 {
	static public void readMeasureTypes() throws IOException {
		System.out.println("Request 7");
		System.out.println("Read measure types available in the db");
		Client.wlog.write("\nRequest 7");
		Client.wlog.write("\nRead measure types available in the db");
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();

		try {
			// get all the measure available in the db
			List<MeasureDefinition> mesList = people.readMeasureTypes();
			System.out.println("Result:");
			Client.wlog.write("\nResult:");
			//checking if there are measures in the db
			if (mesList.size() == 0) {
				System.out.println("There is no measure Types in the database");
				Client.wlog.write("\nThere is no measure Types in the database");
			} else {
				//print out the measure founded
				for (MeasureDefinition temp : mesList) {
					System.out.println("IdMeasureType ==> " + temp.getIdMeasureDef());
					System.out.println("Measure Type ==> " + temp.getMeasureName());
					Client.wlog.write("\nIdMeasureType ==> " + temp.getIdMeasureDef());
					Client.wlog.write("\nMeasure Type ==> " + temp.getMeasureName());

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

package introsde.document.httprequests;

import java.io.IOException;

import introsde.document.main.Client;
import introsde.document.ws.HealthMeasureHistory;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;

public class R8 {
	static public void readPersonMeasure(long id, String measureType, long mid) throws IOException {
		System.out.println("Request 8");
		System.out.println("Read person measure with id=" + id + ",measure=" + measureType + " and mid=" + mid);
		Client.wlog.write("\nRequest 8");
		Client.wlog.write("\nRead person measure with id=" + id + ",measure=" + measureType + " and mid=" + mid);
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();

		try {
			//return the value of {HealthMeasureHistory} (e.g. weight) identified by {mid} for Person identified by {id}
			HealthMeasureHistory hp = people.readPersonMeasure(id, measureType, mid);

			System.out.println("Result:");
			Client.wlog.write("\nResult:");
			//checking if there are histories for the parameter passed
			if (hp == null) {
				System.out.println("There is no History for the request input parameters inserted");
				Client.wlog.write("\nThere is no History for the request input parameters inserted");
			} else {
				//print out the history founded
				System.out.println("Mid " + hp.getIdMeasureHistory());
				System.out.println("Measure Type ==> " + hp.getMeasureDef().getMeasureName());
				System.out.println("Value ==> " + hp.getValue());
				System.out.println("Date ==> " + hp.getTimestamp());
				System.out.println("\n");
				System.out.println("\n");
				Client.wlog.write("\nMid " + hp.getIdMeasureHistory());
				Client.wlog.write("\nMeasure Type ==> " + hp.getMeasureDef().getMeasureName());
				Client.wlog.write("\nValue ==> " + hp.getValue());
				Client.wlog.write("\nDate ==> " + hp.getTimestamp());
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

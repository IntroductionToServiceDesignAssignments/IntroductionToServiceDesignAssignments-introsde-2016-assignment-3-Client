package introsde.document.httprequests;

import java.io.IOException;
import java.util.List;

import introsde.document.main.Client;
import introsde.document.ws.HealthMeasureHistory;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;


public class R6 {
	static public void readPersonHistory(long id, String measureType) throws IOException {
		System.out.println("Request 6");
		System.out.println("Read person History with id=" + id + " and measure=" + measureType);
		Client.wlog.write("\nRequest 6");
		Client.wlog.write("\nRead person History with id=" + id + " and measure=" + measureType);
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();

		try {
			//return the list of values (the history) of {measureType} (e.g. weight) for Person identified by {id}
			List<HealthMeasureHistory> hist = people.readPersonHistory(id, measureType);
			System.out.println("Result:");
			Client.wlog.write("\nResult:");
			//checking if there are histories for the parameter passed
			if(hist.size()==0){
				System.out.println("There is no History for the request input parameters inserted");
				Client.wlog.write("\nThere is no History for the request input parameters inserted");	
			}else{
				//print out the histories founded
			for (HealthMeasureHistory temp : hist) {
				System.out.println("IdMeasureHistory ==> " + temp.getIdMeasureHistory());
				System.out.println("Measure Type ==> " + temp.getMeasureDef().getMeasureName());
				System.out.println("Value ==> " + temp.getValue());
				System.out.println("Date ==> " + temp.getTimestamp());

				Client.wlog.write("\nIdMeasureHistory ==> " + temp.getIdMeasureHistory());
				Client.wlog.write("\nMeasure Type ==> " + temp.getMeasureDef().getMeasureName());
				Client.wlog.write("\nValue ==> " + temp.getValue());
				Client.wlog.write("\nDate ==> " + temp.getTimestamp());

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

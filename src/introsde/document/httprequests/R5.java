package introsde.document.httprequests;

import java.io.IOException;


import introsde.document.main.Client;
import introsde.document.ws.People;
import introsde.document.ws.PeopleService;
import introsde.document.ws.Person;

public class R5 {
	static public void deletePerson(long id) throws IOException {
		System.out.println("Request 5");
		System.out.println("Delete person with id=" + id);
		Client.wlog.write("\nRequest 5");
		Client.wlog.write("\nDelete person with id=" + id);
		//get the service
		PeopleService service = new PeopleService();
		People people = service.getPeopleImplPort();
		try {
			//delet a person passing the id of the person who want to deleted
			int ris = people.deletePerson(id);
			System.out.println("Try to get the person just deleted if the person==null the deletion suceed:");
			Client.wlog.write("\nTry to get the person just deleted if the person==null the deletion suceed:");
			//checking if the ddelete suceed
			Person person = people.readPerson(id);
			if (person == null) {
				System.out.println("Person deleted");
				Client.wlog.write("\nPerson deleted");
			} else {
				System.out.println("Error person not deleted");
				Client.wlog.write("\nError person not deleted");
			}
			System.out.println("\n");
			System.out.println("\n");
			System.out.println(
					"===============================================================================================================");
			Client.wlog.write("\n");
			Client.wlog.write("\n");
			Client.wlog.write(
					"\n===============================================================================================================");
		} catch (Exception e) {
			Client.wlog.write("\nError ==> " + e);
			System.out.println("Error ==> " + e);
		}

	}
}

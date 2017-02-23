package introsde.document.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


import introsde.document.ws.PeopleService;
import introsde.document.httprequests.R1;
import introsde.document.httprequests.R10;
import introsde.document.httprequests.R2;
import introsde.document.httprequests.R3;
import introsde.document.httprequests.R4;
import introsde.document.httprequests.R5;
import introsde.document.httprequests.R6;
import introsde.document.httprequests.R7;
import introsde.document.httprequests.R8;
import introsde.document.httprequests.R9;


public class Client{
	public static Writer wlog;
    public static void main(String[] args) throws Exception {
    	try {
			// create log file
			File filelog = new File("client-server.log");
			FileOutputStream is = new FileOutputStream(filelog);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			wlog = new BufferedWriter(osw);
			

		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}
    	//get the service
        PeopleService service = new PeopleService();
        //print out the aservice address
        System.out.println("Server wsdl url "+service.getWSDLDocumentLocation());
        wlog.write("Server wsdl url "+service.getWSDLDocumentLocation());
        //call all the requests passing the parameters decided
        R1.readPersonList();
        R2.readPerson(1L);
        R3.updatePerson();
        R4.createPerson();
        R5.deletePerson(R4.id);
        R6.readPersonHistory(2, "weight");
        R7.readMeasureTypes();
        R8.readPersonMeasure(1L, "weight", 1);
        R9.savePersonMeasure(1L, "weight");
        R10.updatePersonMeasure(1L, "weight");
        //close the writer
        wlog.close();
        
       
    }
}
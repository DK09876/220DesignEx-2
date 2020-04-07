import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;

public class VisaProcess {
	private Map<String,String> Credentials;
	private Queue<Map<String,String>> ApplicantsList;
	
	public VisaProcess() {
		ApplicantsList=new LinkedList<Map<String,String>>();
		Credentials=new TreeMap<String,String>();
	}
	public void addApplicants(String name,String address) {
		if (!Credentials.containsKey(name)) {
			Credentials.put(name,address);
			Map<String,String> temp= new HashMap<String,String>();
			temp.put(name,address);
			ApplicantsList.add(temp);
		}
	}
	
	public void giveVisa() throws NoSuchElementException{
		//gives the first person to enter the visa process a visa
		if (ApplicantsList.size()==0)
			throw new NoSuchElementException();
		ApplicantsList.remove();
	}
	public String lookup(String name) {
		return Credentials.get(name);
	}
	public int getsizemap() {
		//for testing purposes
		return Credentials.size();
	}
	public int getsizequeue() {
		//for testing purposes
		return ApplicantsList.size();
	}
}

package cityTrain;

import java.util.ArrayList;

// Class definitions and methods for managing nodes (cities)
// One instance per city
// Private data: name of city (CityName) & list of connecting cities w/ direct routes to this city (destination) including fare
// Public data: none
// Connecting route implementation: two ArrayLists (java component) - assumes matching data is the same index across both ArrayLists
//    Note: improved implementation would be to define a class with city name & fare & define a single array list using this class

public class CityNode {
	private String CityName = new String();
	private ArrayList<String> ConnectingCityName = new ArrayList<String>();
	private ArrayList<Integer> ConnectingCityFare = new ArrayList<Integer>();
	
	// Constructor - populate city name
	public CityNode(String city) {
		this.CityName = city;
	}
	
	// Add a direct route to this city
	//  Note: no error checking on fare, should check if fare is positive & throw error or exception 
	public void addRoute (String sourceCity, Integer sourceFare) {
		this.ConnectingCityName.add (sourceCity);
		this.ConnectingCityFare.add(sourceFare);
	}
	
	// Check if a direct route exists
	public int ifDirectRouteExists (String sourceCity) {
		int i;
		if ((i = this.ConnectingCityName.indexOf (sourceCity)) != -1)
			return (this.ConnectingCityFare.get(i));
		else return -1;
	}
	
	public int numDirectRoutes() {
		return (this.ConnectingCityName.size());
	}
	
	public String indexCityName(int i) {
		return (this.ConnectingCityName.get(i));
	}
	
	public int costFromCity(String fromCity) {
		return (ifDirectRouteExists(fromCity));
	}

	public void printCityNode() {
		System.out.printf ("City %s\n", this.CityName);
		for (int i = 0; i < ConnectingCityName.size(); i++) {
			System.out.printf ("index %d\tSourceCity %s\tSourceFare %d\n", i, ConnectingCityName.get(i), ConnectingCityFare.get(i));
		}
	}
}

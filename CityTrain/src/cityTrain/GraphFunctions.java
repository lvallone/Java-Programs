/*
 * Classname: GraphFunctions including:
 *  ifPathExists() - recursive, depth first path method
 *  createListUnvisitedNodes() - copies ArrayList containing unvisited nodes & subtracts listed node
 *  printNodeList() - prints the contents of an ArrayList containing Strings
 *  buildGraph() - initialize node & direct route data
 * 
 * Version information: version 1
 *
 * Date: 26-March, 2012
 * 
 * Copyright notice - none, free for anyone to steal (not that they'd want to)
 */

package cityTrain;

import java.util.ArrayList;

public class GraphFunctions {
	
	public ArrayList<String> cityName = new ArrayList<String>();		// city name corresponding to destination pointer
	public ArrayList<CityNode> cityGraph = new ArrayList<CityNode>();	// pointers to destination objects
	
	public static Boolean Debug = true;  // Debug option, set to false to eliminate execution printfs
	private static final int MAX_COST = 99999;
	
	// constructor - nothing to do - this class is constructed once & never destroyed
	public GraphFunctions() {
	}
	
	// Method: ifPathExists()
	//   Recursive, depth first search for a valid path from source to destination
	//   returns cost of route from source to destination
	//   if successful route from source to destination, path contains list of nodes to travel between source & destination
	//   -1 returned if no valid route is identified
	//
	public int ifPathExists(String source, String destination, ArrayList<String> unvisitedNodes, ArrayList<String> path) {
		// locate destination object
		if (Debug) {
			System.out.printf("source %s (index %d) -> destination %s (index %d)\n", source, cityName.indexOf(source),
			 destination, cityName.indexOf(destination));
			printNodeList(unvisitedNodes);
			printNodeList(path);
		}
		
		// initialize pointer to destination object
		//   if direct route from source to destination, return cost of the route
		CityNode p; int cost = 0; 
		// int lowestCostRoute = MAX_COST; 
		// String lowestCostPathNode = "";
		p = cityGraph.get(cityName.indexOf(destination));
		if ((cost = p.ifDirectRouteExists(source)) != -1) {
			path.add(source);
			path.add(destination);
			return cost;
		}
		
		// no direct route, use recursion to find routes between source & nodes that are one hop from destination
		//   p points to destination object
		//   retrieve the # of nodes that can reach destination directly (numDirectRoutes)
		//      < note way-point below refers to each city that has a direct (one hop) route TO destination>
		//   for each direct route, check if we've already visited the way-point, if true ignore & get the next way-point
		//     update list of un-visited nodes, but subtract off way-point
		//   cost = -1 means there is no way to get from the source to the destination
		//
		//   Efficiency note:
		//		generation of unvisited node list is expensive, for each direct route, scanning entire list to remove way-point
		//		net: computation order = # direct routes * # of nodes * string comparison cost
		//      there are likely ways to do this more efficiently
		else {
			for (int i = 0; i < p.numDirectRoutes(); i++) {
				if (unvisitedNodes.indexOf(p.indexCityName(i)) != -1) {
					ArrayList<String> listUnvisitedNodes = createListUnvisitedNodes(unvisitedNodes, p.indexCityName(i));
					cost = ifPathExists(source, p.indexCityName(i), listUnvisitedNodes, path);
					if (cost != -1) {
						cost += p.costFromCity(p.indexCityName(i));  // compute total cost
						path.add(destination);
						// get the cost of way-point to destination & add to returned cost
						return cost;
					} // check next route
				} // else already visited this node - next city
			}
			return -1; 
		}
	}
	
	public ArrayList<String> createListUnvisitedNodes(ArrayList<String> currentList, String removeCity) {
		// create copy of nodes minus Destination
		ArrayList<String> ListUnvisitedNodes = new ArrayList<String>();
		int i;
		for (i = 0; i < currentList.size(); i++) {
			String s = currentList.get(i);
			if (!s.equals(removeCity))
					ListUnvisitedNodes.add(s);
		}
		// printNodeList(ListUnvisitedNodes);
		return ListUnvisitedNodes;
	}
	
	public void printNodeList(ArrayList<String> nodeList) {
		int i;
		for (i = 0; i < nodeList.size(); i++)
			System.out.printf("%s\t", nodeList.get(i));
		System.out.println();
	}
	
	// initialize nodes & direct routes
	public void buildGraph() {

		CityNode p;
		
		cityName.add("New York");
		p = new CityNode("New York");
		cityGraph.add(p);
		p.addRoute ("Boston", 50);
		p.addRoute ("Washington", 100);
		
		cityName.add("E");
		p = new CityNode ("E");
		cityGraph.add(p);
		p.addRoute("D", 10);
	
		cityName.add("A'");
		p = new CityNode("A'");
		cityGraph.add(p);
		
		cityName.add("A");
		p = new CityNode("A");
		cityGraph.add(p);
		p.addRoute ("A'", 5);
		
		cityName.add("B");
		p = new CityNode("B");
		cityGraph.add(p);
		p.addRoute ("A", 15);
		
		cityName.add("C");
		p = new CityNode("C");
		cityGraph.add(p);
		p.addRoute ("A", 20);
		
		cityName.add("D");
		p = new CityNode("D");
		cityGraph.add(p);
		p.addRoute("E", 10);
		p.addRoute ("B", 5);
		p.addRoute("C", 5);


		
		for (int i = 0; i < cityGraph.size(); i++) {
			p = cityGraph.get(i);
			p.printCityNode();
		}
		
		int i = cityName.indexOf("D");
		if (i != -1) {
			p = cityGraph.get(i);
			System.out.printf("A -> D: %d\n", p.ifDirectRouteExists ("A"));
			System.out.printf("B -> D: %d\n", p.ifDirectRouteExists ("B"));
			System.out.printf("C -> D: %d\n", p.ifDirectRouteExists ("C"));
			System.out.printf("E -> D: %d\n", p.ifDirectRouteExists ("E"));
		}
	}
	
}

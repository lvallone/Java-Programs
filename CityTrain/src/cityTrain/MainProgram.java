package cityTrain;

import java.util.ArrayList;

public class MainProgram {
	
	public static void main(String[] args) {
		GraphFunctions g = new GraphFunctions();
		g.buildGraph();
		
		// find a path from A' to D
		ArrayList<String> listUnvisitedNodes = g.createListUnvisitedNodes(g.cityName, "D");
		ArrayList<String> path = new ArrayList<String>();
		int cost = g.ifPathExists("A'", "D", listUnvisitedNodes, path);
		g.printNodeList(path);  System.out.printf("Cost = %d\n", cost);
	}
}
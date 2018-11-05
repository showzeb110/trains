package com.trains;

import java.util.Arrays;
import java.util.List;

import com.trains.queries.Query;
import com.trains.queries.Query1;
import com.trains.queries.Query10;
import com.trains.queries.Query2;
import com.trains.queries.Query3;
import com.trains.queries.Query4;
import com.trains.queries.Query5;
import com.trains.queries.Query7;
import com.trains.queries.Query8;
import com.trains.queries.Query9;
import com.trains.queries.Query6;

/**
 * Class to represent a railroad service that will store the graph and 
 * process all the queries.
 * 
 * @author Showzeb
 *
 */
public class RailRoad {
	
	private Graph graph;
	private List<Query> queries;
	
	private final static String RESULT_FORMAT = "Output #%s: %s";
	public final static String INVALID_ROUTE = "NO SUCH ROUTE";
	
	public RailRoad() {
		graph = new Graph();
		initQueries();
	}
	
	private void initQueries() {
		queries = Arrays.asList(
				new Query1(),
				new Query2(),
				new Query3(),
				new Query4(),
				new Query5(),
				new Query6(),
				new Query7(),
				new Query8(),
				new Query9(),
				new Query10());
	}
	
	public void parseGraph(String graphString) {
		
		graph = new Graph();
		
		for (String edge : graphString.split(", ")) {
			String fromNode = edge.substring(0, 1);
			String toNode = edge.substring(1, 2);
			int weight = Integer.parseInt(edge.substring(2));
			graph.addEdge(fromNode, toNode, weight);
		}
	}
	
	public void processQueries() {
		
		int i = 1;
		for (Query query : queries) {
			String answer = query.result(graph);
			System.out.println(String.format(RESULT_FORMAT, i, answer));
			i++;
		}
	}
}

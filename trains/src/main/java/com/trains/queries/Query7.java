package com.trains.queries;


import com.trains.Graph;

/**
 * Query: The number of trips starting at A and ending at C with exactly 4 stops.
 *
 */
public class Query7 extends Query {

	@Override
	public String result(Graph graph) {
		
		int trips = getNumberOfPaths(graph, "A", "C", 
				(count, node) -> count == 4 ,
				(count, node) -> node.equals("C") ? 1 : 0);
		return Integer.toString(trips);
	}

}

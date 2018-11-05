package com.trains.queries;

import com.trains.Graph;

/**
 * Query: The number of trips starting at C and ending at C with a maximum of 3
 * stops
 *
 */
public class Query6 extends Query {

	@Override
	public String result(Graph graph) {
		
		int trips = getNumberOfPaths(graph, "C", "C", 
				(count, node) -> count > 3 || (count > 0 && node.equals("C")) ,
				(count, node) -> count > 3 ? 0 : 1) ;
		
		return Integer.toString(trips);
	}
}

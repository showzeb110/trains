package com.trains.queries;

import com.trains.Graph;
import com.trains.RailRoad;

/**
 * Query: The length of the shortest route (in terms of distance to travel) from A
 * to C
 *
 */
public class Query8 extends Query {

	@Override
	public String result(Graph graph) {
		
		int distance = findShortestRoute(graph, "A", "C");
		return distance == Integer.MAX_VALUE ? RailRoad.INVALID_ROUTE : Integer.toString(distance);
	}

}

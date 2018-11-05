package com.trains.queries;

import com.trains.Graph;
import com.trains.RailRoad;

/**
 * Query: The length of the shortest route (in terms of distance to travel) from B
 * to B
 *
 */
public class Query9 extends Query {

	@Override
	public String result(Graph graph) {
		
		int distance = findShortestRoute(graph, "B", "B");
		return distance == Integer.MAX_VALUE ? RailRoad.INVALID_ROUTE : Integer.toString(distance);
	}

}

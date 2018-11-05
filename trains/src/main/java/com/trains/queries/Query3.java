package com.trains.queries;

import com.trains.Graph;
import com.trains.InvalidRouteException;
import com.trains.RailRoad;

/**
 * Query: The distance of the route A-D-C
 *
 */
public class Query3 extends Query {

	@Override
	public String result(Graph graph) {
		
		try {
			return Integer.toString(
					getDistanceBetweenNodes(graph, "A", "D") +
					getDistanceBetweenNodes(graph, "D", "C"));
			
		} catch (InvalidRouteException exp) {
			return RailRoad.INVALID_ROUTE;
		}
	}

}

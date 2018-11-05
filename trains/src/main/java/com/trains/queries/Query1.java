package com.trains.queries;

import com.trains.Graph;
import com.trains.InvalidRouteException;
import com.trains.RailRoad;

/**
 * Query: The distance of the route A-B-C
 *
 */
public class Query1 extends Query {

	@Override
	public String result(Graph graph) {
		
		try {
			return Integer.toString(
					getDistanceBetweenNodes(graph, "A", "B") +
					getDistanceBetweenNodes(graph, "B", "C"));
			
		} catch (InvalidRouteException exp) {
			return RailRoad.INVALID_ROUTE;
		}
	}

}

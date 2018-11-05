package com.trains.queries;

import com.trains.Graph;
import com.trains.InvalidRouteException;
import com.trains.RailRoad;

/**
 * Query: The distance of the route A-E-D
 *
 */
public class Query5 extends Query {

	@Override
	public String result(Graph graph) {
		
		try {
			return Integer.toString(
					getDistanceBetweenNodes(graph, "A", "E") +
					getDistanceBetweenNodes(graph, "E", "D"));
			
		} catch (InvalidRouteException exp) {
			return RailRoad.INVALID_ROUTE;
		}
	}

}

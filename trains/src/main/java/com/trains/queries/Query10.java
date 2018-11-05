package com.trains.queries;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.trains.Graph;

/**
 * Query: The number of different routes from C to C with a distance of less than
 * 30
 *
 */
public class Query10 extends Query {

	@Override
	public String result(Graph graph) {
		
		Set<String> history = new HashSet<>();
		numberOfPaths(graph, "C", "", history, 0);
		return Integer.toString(history.size());
	}
	
	private void numberOfPaths(Graph graph, String node, String pathSoFar, Set<String> history, 
			int distance) {
		
		if (distance >= 30) {
			return ;
		}
		
		String newPath = pathSoFar + node;
		if (distance > 0 && node.equals("C") && !history.contains(newPath)) {
			history.add(newPath);
		}
		
		Map<String, Integer> edges = graph.getEdgesOfNode(node);
		if (edges == null) {
			return ;
		}
	
		for (Map.Entry<String, Integer> neighbour : edges.entrySet()) {
			numberOfPaths(graph, neighbour.getKey(), newPath, history, 
					distance + neighbour.getValue());
		}
	}
}

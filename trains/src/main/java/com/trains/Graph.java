package com.trains;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic implementation of a graph
 * @author Showzeb
 *
 */
public class Graph {

	private Map<String, Map<String, Integer>> edgeMap;
	
	public Graph() {
		edgeMap = new HashMap<>();
	}
	
	public void addEdge(String fromNode, String toNode, int weight) {
		
		Map<String, Integer> edges = null;
		if (edgeMap.containsKey(fromNode)) {
			edges = edgeMap.get(fromNode);
		} else {
			edges = new HashMap<>();
			edgeMap.put(fromNode, edges);
		}
		edges.put(toNode, weight);
	}
	
	public Map<String, Integer> getEdgesOfNode(String node) {
		return edgeMap.get(node);
	}
}

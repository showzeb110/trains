package com.trains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private List<String> nodes;
	private Map<String, List<Edge>> edgeMap;
	
	public Graph() {
		nodes = new ArrayList<>();
		edgeMap = new HashMap<>();
	}
	
	public void addEdge(String fromNode, String toNode, int weight) {
		if (!nodes.contains(fromNode)) {
			nodes.add(fromNode);
		}
		
		if (!nodes.contains(toNode)) {
			nodes.add(toNode);
		}
		
		List<Edge> edges = null;
		if (edgeMap.containsKey(fromNode)) {
			edges = edgeMap.get(fromNode);
		} else {
			edges = new ArrayList<>();
		}
		edges.add(new Edge(fromNode, toNode, weight));
	}
}

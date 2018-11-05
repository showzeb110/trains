package com.trains.queries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trains.Graph;

public class Query6Test {
	
	@Test
	public void onRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "E", 1);
		graph.addEdge("C", "D", 1);
		graph.addEdge("D", "C", 1);
		graph.addEdge("C", "E", 1);
		graph.addEdge("E", "B", 1);
		graph.addEdge("B", "C", 1);
		
		Query query = new Query6();
		assertEquals("2", query.result(graph));
	}
	
	@Test
	public void onNoRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "E", 1);
		graph.addEdge("E", "K", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 1);
		
		Query query = new Query6();
		assertEquals("0", query.result(graph));
		
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "A", 1);
		graph.addEdge("A", "B", 1);
		assertEquals("0", query.result(graph));
	}
}

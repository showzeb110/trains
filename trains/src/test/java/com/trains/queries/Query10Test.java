package com.trains.queries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trains.Graph;

public class Query10Test {
	
	@Test
	public void onRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("B", "A", 10);
		graph.addEdge("A", "B", 4);
		graph.addEdge("B", "C", 5);
		graph.addEdge("C", "B", 10);
		
		Query query = new Query10();
		assertEquals("2", query.result(graph));
	}
	
	@Test
	public void onNoRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "E", 1);
		graph.addEdge("E", "K", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 1);
		
		Query query = new Query10();
		assertEquals("0", query.result(graph));
	}
}

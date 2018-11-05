package com.trains.queries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trains.Graph;
import com.trains.RailRoad;

public class Query3Test {
	
	@Test
	public void onRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "D", 5);
		graph.addEdge("D", "C", 4);
		
		Query query = new Query3();
		assertEquals("9", query.result(graph));
	}
	
	@Test
	public void onNoRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 5);
		graph.addEdge("B", "D", 4);
		
		Query query = new Query3();
		assertEquals(RailRoad.INVALID_ROUTE, query.result(graph));
	}
}

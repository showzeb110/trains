package com.trains.queries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.trains.Graph;
import com.trains.RailRoad;

public class Query8Test {
	
	@Test
	public void onRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("A", "D", 1);
		graph.addEdge("D", "C", 2);
		
		Query query = new Query8();
		assertEquals("2", query.result(graph));
	}
	
	@Test
	public void onNoRouteExists() {
		Graph graph = new Graph();
		graph.addEdge("A", "E", 1);
		graph.addEdge("E", "K", 1);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 1);
		
		Query query = new Query8();
		assertEquals(RailRoad.INVALID_ROUTE, query.result(graph));
	}
}

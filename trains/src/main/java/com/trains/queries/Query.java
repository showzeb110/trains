package com.trains.queries;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import com.trains.Graph;
import com.trains.InvalidRouteException;

public abstract class Query {
	
	/**
	 * Process the result of the query given a graph
	 * @param graph The graph containing nodes and edges
	 * @return Result of the query
	 */
	public abstract String result(Graph graph) ;
	
	/**
	 * Calculate the distance between the two nodes
	 * @param graph The graph containing nodes and edges
	 * @param fromNode Src node
	 * @param toNode dest node
	 * @return the distance betweent the src and dest node
	 * @throws InvalidRouteException if no such route exists
	 */
	public int getDistanceBetweenNodes(Graph graph, String fromNode, String toNode) 
			throws InvalidRouteException {
		
		Map<String, Integer> edgesFrom = graph.getEdgesOfNode(fromNode);
		if (edgesFrom == null || !edgesFrom.containsKey(toNode)) {
			throw new InvalidRouteException();
		}
		
		return edgesFrom.get(toNode);
	}
	
	/**
	 * Find the shortest route between the two nodes
	 * @param graph The graph containing nodes and edges
	 * @param fromNode Src node
	 * @param toNode dest node
	 * @return shortest distance between the two nodes
	 */
	public int findShortestRoute(Graph graph, String fromNode, String toNode) {
		Set<String> visited = new HashSet<>();
		return recurseLength(graph, fromNode, toNode, visited, 0);
	}
	
	/**
	 * Get the number of paths between the two nodes 
	 * @param graph The graph containing nodes and edges
	 * @param fromNode Src node
	 * @param toNode dest node
	 * @param predicate Boolean value function when true will evaluate the function parameter
	 * @param function This function will return the value if the predicate is true
	 * @return number of paths between the two nodes 
	 */
	public int getNumberOfPaths(Graph graph, String fromNode, String toNode,
			BiPredicate<Integer, String> predicate, BiFunction<Integer, String, Integer> function) {
		
		return recurseCount(graph, fromNode, fromNode, toNode, 0, predicate, function);
	}

	private int recurseCount(Graph graph, String start, String fromNode, String toNode, int count,
			BiPredicate<Integer, String> predicate, BiFunction<Integer, String, Integer> function) {
		
		if (predicate.test(count, fromNode)) {
			return function.apply(count, fromNode) ;
		}
		
		Map<String, Integer> edges = graph.getEdgesOfNode(fromNode);
		if (edges == null) {
			return 0;
		}
		
		int total = 0 ;
		for (String neighbour : edges.keySet()) {
			total += recurseCount(graph, start, neighbour, toNode, count + 1,
					predicate, function);
		}
		
		return total;
	}

	private int recurseLength(Graph graph, String fromNode, String toNode, 
			Set<String> visitedStack, int length) {
		
		if (length != 0 && fromNode.equals(toNode)) {
			return length;
		}
		
		if (visitedStack.contains(fromNode)) {
			return Integer.MAX_VALUE;
		}
		
		visitedStack.add(fromNode);
		Map<String, Integer> edges = graph.getEdgesOfNode(fromNode);
		if (edges == null) {
			return Integer.MAX_VALUE;
		}
		
		int min = Integer.MAX_VALUE ;
		for (Map.Entry<String, Integer> neighbour : edges.entrySet()) {
			int distance = recurseLength(graph, neighbour.getKey(), toNode, visitedStack, length + neighbour.getValue());
			min = Math.min(min, distance);
		}
		
		visitedStack.remove(fromNode);
		return min;
	}
}

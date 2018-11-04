package com.trains;

/**
 * Class to represent a directed edge.
 * @author Showzeb
 *
 */
public class Edge {
	
	String fromNode;
	String toNode;
	int weight;
	
	public Edge(String fromNode, String toNode, int weight) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.weight = weight;
	}
}

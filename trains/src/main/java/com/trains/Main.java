package com.trains;

public class Main {

	public static void main(String[] args) {
		
		String testGraph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		Graph graph = new Graph();
		
		for (String edge : testGraph.split(", ")) {
			String fromNode = edge.substring(0, 1);
			String toNode = edge.substring(1, 2);
			int weight = Integer.parseInt(edge.substring(2));
			graph.addEdge(fromNode, toNode, weight);
		}

	}

}

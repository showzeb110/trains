package com.trains;

public class Main {

	public static void main(String[] args) {
		
		String testGraph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		
		RailRoad railRoad = new RailRoad();
		
		railRoad.parseGraph(testGraph);
		railRoad.processQueries();

	}

}

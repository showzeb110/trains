package com.trains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private List<String> nodes;
	private Map<String, List<String>> edges;
	
	public Graph() {
		nodes = new ArrayList<>();
		edges = new HashMap<>();
	}
}

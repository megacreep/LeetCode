package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        Map<UndirectedGraphNode,UndirectedGraphNode> mapping = 
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        nodes.add(node);
        mapping.put(node, new UndirectedGraphNode(node.label));
        int index = 0;
        while (index < nodes.size()) {
            UndirectedGraphNode currNode = nodes.get(index++);
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                if (!mapping.containsKey(neighbor)) {
                    nodes.add(neighbor);
                    mapping.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = mapping.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(mapping.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return mapping.get(node);
    }
    public UndirectedGraphNode cloneGraphMime(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> nodesToVisit = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> nodesVisited = new HashSet<UndirectedGraphNode>();
        nodesToVisit.offer(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = 
                new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        while (!nodesToVisit.isEmpty()) {
            UndirectedGraphNode currNode = nodesToVisit.poll();
            UndirectedGraphNode newNode = new UndirectedGraphNode(currNode.label);
            mapping.put(currNode, newNode);
            nodesVisited.add(currNode);
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                newNode.neighbors.add(neighbor);
                if (!nodesVisited.contains(neighbor)) {
                    nodesToVisit.offer(neighbor);
                }
            }
        }
        UndirectedGraphNode entryPoint = null;
        for (Entry<UndirectedGraphNode, UndirectedGraphNode> entry : mapping.entrySet()) {
            List<UndirectedGraphNode> neighbors = entry.getValue().neighbors;
            for (int i = 0; i < neighbors.size(); i++) {
                neighbors.set(i, mapping.get(neighbors.get(i)));
            }
        }
        
        return mapping.get(node);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EdgeBuilder;

import Graph.Graph;

/**
 *
 * @author Willian
 */
public class DelaunayEdgeBuilder implements EdgeBuilder {
	@Override
	public void build(Graph graph) {
		DelaunayAlgorithm d = new DelaunayAlgorithm(graph.getVertexSize());
		d.triangularizaG(graph);
	}
    
}
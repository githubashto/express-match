/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cost;

import Graph.Vertex;

/**
 *
 * @author Willian
 */
public class Cost {
     public float getCost(Vertex vm, Vertex vi){
         return vm.compareShapeContextExpression(vi);
     }
}

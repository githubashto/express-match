/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class InstanceInstanceComparator {
    private ExpressionsRelation modelInstance1Relation;
    private ExpressionsRelation modelInstance2Relation;
    private ExpressionsRelation instance1Instance2Relation;

    public InstanceInstanceComparator(ExpressionsRelation modelInstance1Relation, ExpressionsRelation modelInstance12Relation) {
        this.modelInstance1Relation = modelInstance1Relation;
        this.modelInstance2Relation = modelInstance12Relation;
    }

    public InstanceInstanceComparator() {
        modelInstance1Relation=null;
        modelInstance2Relation=null;
        instance1Instance2Relation=null;
    }

    public int determineCorrectRelations(){
        int correctRelations=0;
        for (SymbolsRelation symbolsRelation : instance1Instance2Relation) {
            if(isCorrectRelation(symbolsRelation))
                correctRelations++;
        }
        return correctRelations;
    }

    private boolean isCorrectRelation(SymbolsRelation symbolsRelation){
//        if(modelInstance2Relation.getModelOf(symbolsRelation.getModel())==
//                    modelInstance1Relation.getModelOf(symbolsRelation.getInstance()))
        if(modelInstance1Relation.getModelOf(symbolsRelation.getModel())==
                    modelInstance2Relation.getModelOf(symbolsRelation.getInstance()))
              return true;
        return false;

    }

    public ExpressionsRelation getInstance1Instance2Relation() {
        return instance1Instance2Relation;
    }

    public void setInstance1Instance2Relation(ExpressionsRelation instance1Instance2Relation) {
        this.instance1Instance2Relation = instance1Instance2Relation;
    }

    public ExpressionsRelation getModelInstance12Relation() {
        return modelInstance2Relation;
    }

    public void setModelInstance12Relation(ExpressionsRelation modelInstance12Relation) {
        this.modelInstance2Relation = modelInstance12Relation;
    }

    public ExpressionsRelation getModelInstance1Relation() {
        return modelInstance1Relation;
    }

    public void setModelInstance1Relation(ExpressionsRelation modelInstance1Relation) {
        this.modelInstance1Relation = modelInstance1Relation;
    }

}

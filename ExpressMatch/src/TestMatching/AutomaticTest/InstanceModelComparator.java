/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class InstanceModelComparator {
    private ExpressionsRelation modelInstanceRelation;
    private ExpressionsRelation instanceModelRelation;

    public InstanceModelComparator(ExpressionsRelation modelInstanceRelation,
            ExpressionsRelation instanceModelRelation) {
        this.modelInstanceRelation = modelInstanceRelation;
        this.instanceModelRelation = instanceModelRelation;
    }

    public int determineCorrectRelations(){
        int correctRelations=0;
        for (SymbolsRelation symbolsRelation : instanceModelRelation) {
            if(isCorrectRelation(symbolsRelation))
                correctRelations++;
        }
        return correctRelations;
    }

    private boolean isCorrectRelation(SymbolsRelation symbolsRelation){
        if(modelInstanceRelation.getModelOf(symbolsRelation.getModel())==
                    symbolsRelation.getInstance())
            return true;
        return false;
    }
    
    public ExpressionsRelation getInstanceModelRelation() {
        return instanceModelRelation;
    }

    public void setInstanceModelRelation(ExpressionsRelation instanceModelRelation) {
        this.instanceModelRelation = instanceModelRelation;
    }

    public ExpressionsRelation getModelInstanceRelation() {
        return modelInstanceRelation;
    }

    public void setModelInstanceRelation(ExpressionsRelation modelInstanceRelation) {
        this.modelInstanceRelation = modelInstanceRelation;
    }
}
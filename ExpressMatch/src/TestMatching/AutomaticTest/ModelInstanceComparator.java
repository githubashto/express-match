/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class ModelInstanceComparator {
    private ExpressionsRelation correctModelInstanceRelation;
    private ExpressionsRelation modelInstanceRelationResult;

    public ModelInstanceComparator(ExpressionsRelation correctModelInstanceRelation,
            ExpressionsRelation modelInstanceRelationResult) {
        this.correctModelInstanceRelation = correctModelInstanceRelation;
        this.modelInstanceRelationResult = modelInstanceRelationResult;
    }

    public int determineCorrectRelations(){
        int correctRelations=0;
        for (SymbolsRelation symbolsRelation : modelInstanceRelationResult) {
            if(isCorrectRelation(symbolsRelation))
                correctRelations++;
        }
        return correctRelations;
    }

    private boolean isCorrectRelation(SymbolsRelation symbolsRelation){
        if(correctModelInstanceRelation.has(symbolsRelation))
            return true;
        return false;
    }

    public ExpressionsRelation getCorrectModelInstanceRelation() {
        return correctModelInstanceRelation;
    }

    public void setCorrectModelInstanceRelation(ExpressionsRelation correctModelInstanceRelation) {
        this.correctModelInstanceRelation = correctModelInstanceRelation;
    }

    public ExpressionsRelation getModelInstanceRelationResult() {
        return modelInstanceRelationResult;
    }

    public void setModelInstanceRelationResult(ExpressionsRelation modelInstanceRelationResult) {
        this.modelInstanceRelationResult = modelInstanceRelationResult;
    }
}

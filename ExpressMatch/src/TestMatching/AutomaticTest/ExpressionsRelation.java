/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class ExpressionsRelation extends ArrayList<SymbolsRelation>{

    public ExpressionsRelation(int relationMatrix[][]) {
        super(relationMatrix.length);
        addRelations(relationMatrix);
    }

    private void addRelations(int relationMatrix[][]){
        int modelColumn=0;
        int instanceColumn=1;
        for (int i = 0; i < relationMatrix.length; i++) {
            int[] relation = relationMatrix[i];
            SymbolsRelation symbolRelation=new SymbolsRelation(relation[modelColumn],
                    relation[instanceColumn]);
            add(symbolRelation);
        }
    }

    public boolean has(SymbolsRelation relation){
        for (SymbolsRelation aRelation: this) {
            if(aRelation.equals(relation))
                return true;
        }
        return false;
    }

    public int getModelOf(int instance){
        for(SymbolsRelation symbolRelation:this)
            if(symbolRelation.getInstance()==instance)
                return symbolRelation.getModel();
        return -1;
    }

    public int getInstanceOf(int model){
        for(SymbolsRelation symbolRelation:this)
            if(symbolRelation.getModel()==model)
                return symbolRelation.getInstance();
        return -1;
    }
}

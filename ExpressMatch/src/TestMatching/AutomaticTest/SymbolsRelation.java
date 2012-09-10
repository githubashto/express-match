/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class SymbolsRelation {
    private int model;
    private int instance;

    public SymbolsRelation(int model, int instance) {
        this.model = model;
        this.instance = instance;
    }

    public SymbolsRelation(){
        this.instance=-1;
        this.model=-1;
    }

    @Override
    public boolean equals(Object object){
        if(object==null)
            return false;
        if(!(object instanceof SymbolsRelation))
            return false;

        final SymbolsRelation otherRelation=(SymbolsRelation) object;

        if(otherRelation.getInstance()== getInstance()&&
                otherRelation.getModel()==getModel())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.model;
        hash = 53 * hash + this.instance;
        return hash;
    }

    public int getInstance() {
        return instance;
    }

    public void setInstance(int instance) {
        this.instance = instance;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}

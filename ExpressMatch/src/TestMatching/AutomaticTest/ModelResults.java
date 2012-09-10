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
public class ModelResults extends ArrayList<MatchingResult> {

    private String idModel;

    private int numberOfSymbols;

    public ModelResults(String idModel, int numberOfSymbols) {
        super();
        this.idModel = idModel;
        this.numberOfSymbols = numberOfSymbols;
    }

    public Measures getResults(){
        float mean=getMean();
        float standarDeviation=0;

        for (MatchingResult matchingResult: this) {
            standarDeviation+=((matchingResult.getNumberOfCorrectMatches()-mean)*
                    (matchingResult.getNumberOfCorrectMatches()-mean));
        }

//        standarDeviation=(float) Math.sqrt(standarDeviation/(size()*numberOfSymbols));
        standarDeviation=(float) Math.sqrt(standarDeviation/(size()));
        Measures results=new Measures(mean, standarDeviation);
        return results;
    }

    public float getMean(){
        float sum=0;
        for (MatchingResult matchingResult : this) {
            sum+=matchingResult.getNumberOfCorrectMatches();
        }

        float mean=sum/size();
        return mean;
    }

    public String getIdModel() {
        return idModel;
    }

    public void setIdModel(String idModel) {
        this.idModel = idModel;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

}

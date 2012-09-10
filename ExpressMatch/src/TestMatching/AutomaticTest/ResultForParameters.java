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
public class ResultForParameters extends ArrayList<ModelResults>{
    private MatchingParameters parameters;

    public ResultForParameters(MatchingParameters parameters) {
        super();
        this.parameters = parameters;
    }

//  EDITING
    public Measures getResults(){
        float mean=getMean();
        float standarDeviation=0;
        for (ModelResults modelResult: this) {
            for (MatchingResult matchingResult : modelResult) {
                standarDeviation+=((matchingResult.getNumberOfCorrectMatches()-mean)*
                    (matchingResult.getNumberOfCorrectMatches()-mean));
            }
//            standarDeviation+=((matchingResult.getNumberOfCorrectMatches()-mean)*
//                    (matchingResult.getNumberOfCorrectMatches()-mean));
        }

        standarDeviation=(float) Math.sqrt(standarDeviation/(size()*(size()-1)));
        Measures results=new Measures(mean, standarDeviation);
        return results;
    }
    
    public Measures getResultsForCorrectAssigmentsPerModel(){
        float mean=getMeanCorrectAssigmentsPerModels();
        float[] correctAssigments=getCorrectAssigmentsPerModels();
        float standarDeviation=0;
        
        for (float x : correctAssigments) {
            standarDeviation+=(Math.pow(x-mean, 2));
        }
        standarDeviation=(float) Math.sqrt(standarDeviation/size());
        Measures results=new Measures(mean, standarDeviation);
        return results;
    }

    public float getMeanCorrectAssigmentsPerModels(){
        float[] correctAssigments=getCorrectAssigmentsPerModels();
        float sum=0;
        for (float x : correctAssigments) {
            sum+=x;
        }
        float mean=sum/size();
        return mean;
    }
    
    public float[] getCorrectAssigmentsPerModels(){
        float[] correctAsigmentsPerModels=new float[size()];
        float sum=0;
        int pos=0;
        for (ModelResults modelResult : this) {
            sum=0;
            for (MatchingResult matchingResult : modelResult) {
                sum+=matchingResult.getNumberOfCorrectMatches();
            }
            correctAsigmentsPerModels[pos]=sum;
            pos++;
        }
        return correctAsigmentsPerModels;
    }
    
    public int getNumberOfSymbolsOfModels(){
        return get(0).getNumberOfSymbols();
    }


    public float getMean(){
        float sum=0;
        for (ModelResults modelResult : this) {
            sum+=modelResult.getMean();
        }
        float mean=sum/size();
        return mean;
    }

    public MatchingParameters getParameters() {
        return parameters;
    }

    public void setParameters(MatchingParameters parameters) {
        this.parameters = parameters;
    }
}

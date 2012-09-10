/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class MatchingResult {

    private int numberOfCorrectMatches;

    private String idInstance;

    private boolean isPredefinedModel;

    public MatchingResult() {
        isPredefinedModel=false;
        idInstance="";
        numberOfCorrectMatches=-1;
    }

    public String getIdInstance() {
        return idInstance;
    }

    public void setIdInstance(String idInstance) {
        this.idInstance = idInstance;
    }

    public int getNumberOfCorrectMatches() {
        return numberOfCorrectMatches;
    }

    public void setNumberOfCorrectMatches(int numberOfCorrectMatches) {
        this.numberOfCorrectMatches = numberOfCorrectMatches;
    }
}

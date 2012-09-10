/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

/**
 *
 * @author frank
 */
public class Measures {

    private float mean;

    private float standardDeviation;

    public Measures(float mean, float standardDeviation) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
    }

    public String toString(){
        return (mean+"\t"+standardDeviation);
    }

    public float getMean() {
        return mean;
    }

    public void setMean(float mean) {
        this.mean = mean;
    }

    public float getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(float standardDeviation) {
        this.standardDeviation = standardDeviation;
    }



}

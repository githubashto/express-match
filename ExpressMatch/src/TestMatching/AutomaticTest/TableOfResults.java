/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import DatabaseMathExpressions.ModelExpression;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author frank
 */
public class TableOfResults extends ArrayList<ClassResults>{
    private final static String horizontalSeparator=";";
    private final static String verticalSeparator="\n";
    private final static String blank=" ";
    private ArrayList<MatchingParameters> parameterGroups;
    
    private String initialTime;
    
    private String finishTime;

    
    public String formatedTable(){
        String table="Results with correct assigments per models"+verticalSeparator;
//        String table="";
        table+=getTimes()+verticalSeparator;
        table+=getParametersAsStringTable()+verticalSeparator+verticalSeparator;
        table+=getHeadings()+verticalSeparator;
        for (ClassResults classResult : this) {
            table+=(getClassData(classResult)+horizontalSeparator);
//            table+=getGlobalResults(classResult);
            table+=getGlobalResultsCorrectAssigmentsPerModel(classResult);
            for(int i=0;i<classResult.getNumberOfExemplars();i++){
                boolean idOfModelAdded=false;
                for (ResultForParameters resultForParameters : classResult) {
                    if(!idOfModelAdded){
                        table+=(horizontalSeparator+resultForParameters.get(i).getIdModel());
                        idOfModelAdded=true;
                    }
                    table+=horizontalSeparator+getResultsOfInstanceForParameters(resultForParameters,
                            i);
                }
            }
            
            table+=verticalSeparator;
        }
        return table;
    }
    
    public String getTimes(){
        String times="";
        times+=("Started on: "+initialTime+" and finished on "+finishTime);
        return times;
    }

    public String getParametersAsStringTable(){
        String parametersAsStringTable="";
        parametersAsStringTable="#"+horizontalSeparator+"alpha"+horizontalSeparator+
                "beta"+horizontalSeparator+"gama"+horizontalSeparator+"delaunay"+verticalSeparator;
        int cont=1;
        for (MatchingParameters parameters : parameterGroups) {
            parametersAsStringTable+=(cont+horizontalSeparator+parameters.getAlpha()+
                    horizontalSeparator+parameters.getBeta()+horizontalSeparator+
                    parameters.getGamma()+horizontalSeparator+parameters.isDelaunay()+
                    verticalSeparator);
            cont++;
        }
        parametersAsStringTable+="Global Shape context (raio angulo) # regions: "+
                horizontalSeparator+
                MatchingParameters.LogPolarGlobalRegions+horizontalSeparator+
                MatchingParameters.angularGlobalRegions+
                verticalSeparator;
        parametersAsStringTable+="Local Shape context (raio angulo) #regions: "+
                horizontalSeparator+
                MatchingParameters.LogPolarLocalRegions+horizontalSeparator+
                MatchingParameters.angularLocalRegions+
                verticalSeparator;

        parametersAsStringTable+="# points per symbol "+
                horizontalSeparator+
                MatchingParameters.numberOfPointPerSymbol+verticalSeparator;
        return parametersAsStringTable;
    }

    public String getHeadings(){
        String headings="";
        headings+=(firstLineOfHeadings()+verticalSeparator);
        headings+=secondLineOfHeadings();

        return headings;
    }
    
    public String firstLineOfHeadings(){
        String headings="";
        headings+=(blank+horizontalSeparator+"Class"+horizontalSeparator+blank);
        int numberOfParameters=getNumberOfParameters();
        for (int j = 0; j < numberOfParameters; j++) {
                headings+=(horizontalSeparator+blank+horizontalSeparator+
                        "Params # "+(j+1)+
                        horizontalSeparator+blank);
            }
        
        int maxNumberOfExemplars=getMaxNumberOfExemplars();
        for (int i = 0; i < maxNumberOfExemplars; i++) {
            headings+=(horizontalSeparator+"ID of model ");
            for (int j = 0; j < numberOfParameters; j++) {
                headings+=(horizontalSeparator+"Params # "+(j+1)+
                    horizontalSeparator+blank);
            }       
        }
        return headings;
    }
    
    public String secondLineOfHeadings(){
        String headings="";
        headings+=("Model ID"+horizontalSeparator+"# exemplars"+horizontalSeparator+"# symbols");
        int numberOfParameters=getNumberOfParameters();
        for (int i = 0; i < numberOfParameters; i++) {
            headings+=(horizontalSeparator+"global mean(0-1)"+horizontalSeparator+
                    "mean"+ horizontalSeparator+
                    "s. dev.");
        }
        int maxNumberOfExemplars=getMaxNumberOfExemplars();
        for (int i = 0; i < maxNumberOfExemplars; i++) {
            headings+=(horizontalSeparator+blank);
            for (int j = 0; j < numberOfParameters; j++) {
                headings+=(horizontalSeparator+"mean"+
                    horizontalSeparator+"s. dev.");
            }
//            headings+=(horizontalSeparator+"ID of model "+"matching mean"+ horizontalSeparator+
//                    "s. dev.");
        }
        return headings;
    }

    public int getMaxNumberOfExemplars(){
        int max=0;
        for (ClassResults classResults : this) {
            if(max<classResults.getNumberOfExemplars())
                max=classResults.getNumberOfExemplars();
        }
        return max;
    }

    public int getNumberOfParameters(){
        int numberOfParameters=0;
        if(size()>0){
            numberOfParameters=get(0).size();
        }
        return numberOfParameters;
    }

    public String getResultsOfInstanceForParameters(ResultForParameters resultForParameters
            ,int indexOfModel){
        String results="";
        ModelResults modelResult= resultForParameters.get(indexOfModel);
//            results+=("ID of model: "+modelResult.getIdModel()+
//                    horizontalSeparator+", ");
            Measures measures=modelResult.getResults();
            results+=measures.getMean()+horizontalSeparator+measures.getStandardDeviation();

//        if(resultForParameters.size()>0)
//            results=results.substring(0, results.length()-1);
        return results;
    }

//    public String getResultForParameters(ResultForParameters resultForParameters){
//        String results="";
//        for (ModelResults modelResult : resultForParameters) {
////            results+=("ID of model: "+modelResult.getIdModel()+
////                    horizontalSeparator+", ");
//            Measures measures=modelResult.getResults();
//            results+=measures.getMean()+horizontalSeparator+measures.getStandardDeviation()+horizontalSeparator;
//        }
//        if(resultForParameters.size()>0)
//            results=results.substring(0, results.length()-1);
//        return results;
//    }

    private String getGlobalResults(ClassResults classResult){
        String results="";
        for (ResultForParameters resultForParameters : classResult) {
            Measures measures= resultForParameters.getResults();
            float normalizedMean=
                    measures.getMean()/resultForParameters.getNumberOfSymbolsOfModels();
            results+=normalizedMean+horizontalSeparator+
                    measures.getMean()+horizontalSeparator+measures.getStandardDeviation()+horizontalSeparator;
        }
        if(classResult.size()>0)
            results=results.substring(0, results.length()-1);
        return results;
    }
    
    private String getGlobalResultsCorrectAssigmentsPerModel(ClassResults classResult){
        String results="";
        for (ResultForParameters resultForParameters : classResult) {
            Measures measures= resultForParameters.getResultsForCorrectAssigmentsPerModel();
            float normalizedMean=
                    measures.getMean()/(resultForParameters.getNumberOfSymbolsOfModels()*(resultForParameters.size()-1));
            results+=normalizedMean+horizontalSeparator+
                    measures.getMean()+horizontalSeparator+measures.getStandardDeviation()+horizontalSeparator;
        }
        if(classResult.size()>0)
            results=results.substring(0, results.length()-1);
        return results;
    }

    public String getClassData(ClassResults classResults){
        String classData="";
        classData+=classResults.getIdModel()+horizontalSeparator;
        classData+=classResults.getNumberOfExemplars()+horizontalSeparator;
        classData+=classResults.getNumberOfSymbols();
        return classData;
    }

    public ArrayList<MatchingParameters> getParameterGroups() {
        return parameterGroups;
    }

    public void setParameterGroups(ArrayList<MatchingParameters> parameterGroups) {
        this.parameterGroups = parameterGroups;
    }

    public void setUpInitialTime(){
        this.initialTime=Calendar.getInstance().getTime().toString();
    }
    
    public void setUpFinishTime(){
        this.finishTime=Calendar.getInstance().getTime().toString();
    }
    
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }
    
}

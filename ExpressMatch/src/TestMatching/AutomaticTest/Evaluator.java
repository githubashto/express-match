/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import DatabaseMathExpressions.DBFuntions;
import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.UserExpression;
import FeatureExtractor.PreprocessingAlgorithms;
import Matching.ExpressionMatching;
import Util.Util;
import java.util.ArrayList;
import Matching.Matching;
import MathExpression.Data.DMathExpression;
import TestMatching.TestInitialMatchings.DatabaseTestFunctions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author frank
 */
public class Evaluator {
    private DBFuntions databaseMathExpressions;

    private DatabaseTestFunctions databaseTest;
    private Matching matching;


    public Evaluator(){
        databaseMathExpressions=new DBFuntions();
        matching=new ExpressionMatching();
        databaseTest=new DatabaseTestFunctions();
        databaseTest.openConnection();
    }


    public void executeEvaluation(String fileName,int fromIndex,int toIndex){

        databaseMathExpressions.openConnection();
        ArrayList<ModelExpression> allModelExpressions = databaseMathExpressions.getModelExpressions();
        //preprocessing modelsss
        preprocessModels(allModelExpressions);
        ////
        String inputFilename=fileName;//readFileName();
        ArrayList<MatchingParameters> parameters=MatchingParameters.readParameters(inputFilename);

        TableOfResults tableOfResults=new TableOfResults();
        tableOfResults.setParameterGroups(parameters);
        tableOfResults.setUpInitialTime();
        int count=1;




//        for (ModelExpression modelExpression : allModelExpressions.subList(50,51)) {
        for (ModelExpression modelExpression : allModelExpressions.subList(fromIndex, toIndex)) {
            String time=Calendar.getInstance().getTime().toString();
            System.out.println("iteration : "+(count++));
//            System.out.println("analysing model "+modelExpression.getId()+
//                    " time: "+time);
//            System.out.println("number of symbols = "+modelExpression.getdMathExpression().size());
            ArrayList<UserExpression> instances=databaseMathExpressions.getUserExpressionsForModel(modelExpression.getId());
            //preprocessing instances
            preprocessUserExpressions(instances);
            /////

            ExpressionClass expressionClass=new ExpressionClass(modelExpression, instances);

            ClassResults classResults=new ClassResults();
            classResults.setIdModel(String.valueOf(modelExpression.getId()));
            classResults.setNumberOfSymbols(modelExpression.getdMathExpression().size());
            classResults.setNumberOfExemplars(expressionClass.getExpressions().size());
            for (MatchingParameters parametersGroup:parameters) {
                ResultForParameters resultForParameters = evaluate(expressionClass, parametersGroup);
//                System.out.println("results for parameters: "+parametersGroup);
//                System.out.println(resultForParameters.getResults());
                classResults.add(resultForParameters);
            }
            tableOfResults.add(classResults);
        }
        tableOfResults.setUpFinishTime();

//        System.out.println(tableOfResults.formatedTable());
        try {
            String timeForFileSaving=Calendar.getInstance().getTime().toString();
            BufferedWriter out = new BufferedWriter(new FileWriter("results_for_"+inputFilename+
                    "_at_"+timeForFileSaving));
            out.write(tableOfResults.formatedTable());
            out.close();
        } catch (IOException e) {
        }
    }

    public void executeEvaluation(){

        databaseMathExpressions.openConnection();
        ArrayList<ModelExpression> allModelExpressions = databaseMathExpressions.getModelExpressions();
        //preprocessing modelsss
        preprocessModels(allModelExpressions);
        ////
        String inputFilename=readFileName();
        ArrayList<MatchingParameters> parameters=MatchingParameters.readParameters(inputFilename);

        TableOfResults tableOfResults=new TableOfResults();
        tableOfResults.setParameterGroups(parameters);
        tableOfResults.setUpInitialTime();
        int count=1;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String str="";
        int fromIndex=0;
        int toIndex=0;
        try {
            System.out.print("from index: ");
            str = in.readLine();
            fromIndex=Integer.valueOf(str);

            System.out.print("to index: ");
            str = in.readLine();
            toIndex=Integer.valueOf(str);
        } catch (IOException ex) {
            Logger.getLogger(Evaluator.class.getName()).log(Level.SEVERE, null, ex);
        }


//        for (ModelExpression modelExpression : allModelExpressions.subList(50,51)) {
        for (ModelExpression modelExpression : allModelExpressions.subList(fromIndex, toIndex)) {
            String time=Calendar.getInstance().getTime().toString();
            System.out.println("iteration : "+(count++));
//            System.out.println("analysing model "+modelExpression.getId()+
//                    " time: "+time);
//            System.out.println("number of symbols = "+modelExpression.getdMathExpression().size());
            ArrayList<UserExpression> instances=databaseMathExpressions.getUserExpressionsForModel(modelExpression.getId());
            //preprocessing instances
            preprocessUserExpressions(instances);
            /////

            ExpressionClass expressionClass=new ExpressionClass(modelExpression, instances);
            
            ClassResults classResults=new ClassResults();
            classResults.setIdModel(String.valueOf(modelExpression.getId()));
            classResults.setNumberOfSymbols(modelExpression.getdMathExpression().size());
            classResults.setNumberOfExemplars(expressionClass.getExpressions().size());
            for (MatchingParameters parametersGroup:parameters) {
                ResultForParameters resultForParameters = evaluate(expressionClass, parametersGroup);
//                System.out.println("results for parameters: "+parametersGroup);
//                System.out.println(resultForParameters.getResults());
                classResults.add(resultForParameters);
            }
            tableOfResults.add(classResults);
        }
        tableOfResults.setUpFinishTime();
        
//        System.out.println(tableOfResults.formatedTable());
        try {
            String timeForFileSaving=Calendar.getInstance().getTime().toString();
            BufferedWriter out = new BufferedWriter(new FileWriter("results_for_"+inputFilename+
                    "_at_"+timeForFileSaving));
            out.write(tableOfResults.formatedTable());
            out.close();
        } catch (IOException e) {
        }
    }

    public  void preprocessModels(ArrayList<ModelExpression> models){
        for (ModelExpression modelExpression : models) {
            DMathExpression expression=modelExpression.getdMathExpression();
            expression=PreprocessingAlgorithms.preprocessDMathExpression(expression);
            modelExpression.setdMathExpression(expression);
        }
    }

    public  void preprocessUserExpressions(ArrayList<UserExpression> userExpressions){
        for (UserExpression modelExpression : userExpressions) {
            DMathExpression expression=modelExpression.getdMExpression();
            expression=PreprocessingAlgorithms.preprocessDMathExpression(expression);
            modelExpression.setdMExpression(expression);
        }
    }
    
    public String readFileName(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
  
        System.out.print("Input file name: ");  
        String str="";  
        try {
            str = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Evaluator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    public ResultForParameters evaluate(ExpressionClass expressionClass,
            MatchingParameters parameters){
        setUpMatchingParameters(parameters);
        ResultForParameters resultForParameters=executeCrossMatching(expressionClass,
                parameters);
        return resultForParameters;
    }

    public ResultForParameters executeCrossMatching(ExpressionClass expressionClass,
            MatchingParameters parameters){
        ArrayList<UserExpression> instanceExpressions = expressionClass.getExpressions();
        
        ResultForParameters resultForParameters=new ResultForParameters(parameters);

        int numberOfSymbols=expressionClass.getModelExpression().getdMathExpression().size();
//        ModelExpression model=expressionClass.getModelExpression();
//        UserExpression modelAsUsedAsInstanceExpression=new UserExpression();
//        modelAsUsedAsInstanceExpression.setdMExpression(model.getdMathExpression());
//        instanceExpressions.add(modelAsUsedAsInstanceExpression);
//        modelAsUsedAsInstanceExpression.setId(model.getId());
        for (int i = 0; i < instanceExpressions.size(); i++) {
            ModelResults matchingsOfModel=new ModelResults(instanceExpressions.get(i).toString(),
                    numberOfSymbols);
            for (int j = 0; j < instanceExpressions.size(); j++) {
                if(i!=j){
                    MatchingResult resultOfModel=null;
                    if(instanceExpressions.get(i).getIdUser().equals("unknown")){
                        resultOfModel =modelVsInstanceEvaluation(instanceExpressions.get(i),
                        instanceExpressions.get(j));
                    }
                    else if (instanceExpressions.get(j).getIdUser().equals("unknown")){
                        resultOfModel =instanceVsModelEvaluation(instanceExpressions.get(i),
                        instanceExpressions.get(j));
                    }
                    else {
                        resultOfModel = instanceInstanceEvaluation(instanceExpressions.get(i),
                        instanceExpressions.get(j));
                    }
                    matchingsOfModel.add(resultOfModel);
                }
            }
            resultForParameters.add(matchingsOfModel);
//            System.out.println("model results of "+instanceExpressions.get(i).toString()+
//                    "\n "+matchingsOfModel.getResults());
        }

        return resultForParameters;
    }
    
    private String[][] getMatchingOf(DMathExpression model, DMathExpression instance){
        String[][] strMatch=null;
//        int dx=(int)(PanMatching.gapFromLeftOfPanel-model.getLtPoint().getX());
//        int dy=(int)(PanMatching.gapFromTopOfPanel-model.getLtPoint().getY());
////        if(dx!=0||dy!=0)
//            ((GMathExpression)model).translate(dx,dy);
        
        strMatch=this.matching.match(model, instance);
        return strMatch;
    }

    private MatchingResult modelVsInstanceEvaluation(UserExpression instanceAsModel,UserExpression instance){
//        int correctMatchings= databaseTest.getNumberOfCorrectMatchingsForModel(instanceAsModel.getId(),instance.getId());
//        MatchingResult resultOfModel=new MatchingResult();
//        resultOfModel.setIdInstance("predefined model");
//        resultOfModel.setNumberOfCorrectMatches(correctMatchings);
//        return resultOfModel;

        String[][] strMatch=null;
//        strMatch=this.matching.match(instanceAsModel.getdMExpression(),
//                instance.getdMExpression());
        strMatch=this.getMatchingOf(instanceAsModel.getdMExpression(),
                instance.getdMExpression());
        int[][] matchResult=Util.stringToIntMatrix(strMatch);
        int[][] storedMatching=instance.getMatch();

        ExpressionsRelation relationOfModel=new ExpressionsRelation(storedMatching);
        ExpressionsRelation relationOfResult=new ExpressionsRelation(matchResult);

        ModelInstanceComparator comparator=new ModelInstanceComparator(relationOfModel,
                relationOfResult);

//        System.out.println("stored matching");
//        Util.printMatrix(storedMatching);
//        System.out.println("matching result");
//        Util.printMatrix(matchResult);

        int correctMatchings= comparator.determineCorrectRelations();

//        System.out.println("Correct matchings :" + correctMatchings);

        MatchingResult resultOfModel=new MatchingResult();
        resultOfModel.setIdInstance(instance.toString());
        resultOfModel.setNumberOfCorrectMatches(correctMatchings);
        return resultOfModel;
    }

    private MatchingResult instanceVsModelEvaluation(UserExpression instanceAsModel,UserExpression instance){
        
        String[][] strMatch=null;
//        strMatch=this.matching.match(instanceAsModel.getdMExpression(),
//                instance.getdMExpression());
        strMatch=this.getMatchingOf(instanceAsModel.getdMExpression(),
                instance.getdMExpression());
        int[][] match=Util.stringToIntMatrix(strMatch);
        int[][] matchingOfModel=instanceAsModel.getMatch();

        ExpressionsRelation relationOfModel=new ExpressionsRelation(matchingOfModel);
        ExpressionsRelation relationOfResult=new ExpressionsRelation(match);

        InstanceModelComparator comparator=new InstanceModelComparator(relationOfModel,
                relationOfResult);
        
//                    System.out.println("matching of model");
//                    Util.printMatrix(matchingOfModel);
//                    System.out.println("matching of instance");
//                    Util.printMatrix(matchingOfInstance);
//                    System.out.println("matching result");
//                    Util.printMatrix(match);

        int correctMatchings= comparator.determineCorrectRelations();

//                    System.out.println("Correct matchings :" + correctMatchings);

        MatchingResult resultOfModel=new MatchingResult();
        resultOfModel.setIdInstance("predefined model");
        resultOfModel.setNumberOfCorrectMatches(correctMatchings);
        return resultOfModel;
    }

    private MatchingResult instanceInstanceEvaluation(UserExpression instanceAsModel,UserExpression instance){
        InstanceInstanceComparator comparator=new InstanceInstanceComparator();
        String[][] strMatch=null;
//        strMatch=this.matching.match(instanceAsModel.getdMExpression(),
//                instance.getdMExpression());
        strMatch=getMatchingOf(instanceAsModel.getdMExpression(),
                instance.getdMExpression());
        int[][] match=Util.stringToIntMatrix(strMatch);
        int[][] matchingOfModel=instanceAsModel.getMatch();
        int[][] matchingOfInstance=instance.getMatch();

//        int[][] jointmatrix=Util.jointToRight(Util.jointToRight(matchingOfModel,
//                matchingOfInstance),match);
//        System.out.println("model : "+instanceAsModel.toString()+"instance : "+
//                instance.toString());
//        Util.printMatrix(jointmatrix);
//        System.out.println("");

        ExpressionsRelation relationOfModel=new ExpressionsRelation(matchingOfModel);
        ExpressionsRelation relationOfInstance=new ExpressionsRelation(matchingOfInstance);
        ExpressionsRelation relationOfResult=new ExpressionsRelation(match);

        comparator.setModelInstance1Relation(relationOfModel);
        comparator.setModelInstance12Relation(relationOfInstance);
        comparator.setInstance1Instance2Relation(relationOfResult);

//                    System.out.println("matching of model");
//                    Util.printMatrix(matchingOfModel);
//                    System.out.println("matching of instance");
//                    Util.printMatrix(matchingOfInstance);
//                    System.out.println("matching result");
//                    Util.printMatrix(match);

        int correctMatchings= comparator.determineCorrectRelations();

//                    System.out.println("Correct matchings :" + correctMatchings);

        MatchingResult resultOfModel=new MatchingResult();
        resultOfModel.setIdInstance(instance.toString());
        resultOfModel.setNumberOfCorrectMatches(correctMatchings);
        return resultOfModel;
    }


    private void setUpMatchingParameters(MatchingParameters parameters){
        ((ExpressionMatching)matching).setAlpha(parameters.getAlpha());
        ((ExpressionMatching)matching).setBeta(parameters.getBeta());
        ((ExpressionMatching)matching).setGama(parameters.getGamma());
        ((ExpressionMatching)matching).setDelaunay(parameters.isDelaunay());
    }


//    private ArrayList<ExpressionClass> readAllExpressions(){
//        ArrayList<ExpressionClass> expressions=new ArrayList<ExpressionClass>();
//        databaseMathExpressions.openConnection();
//        ArrayList<ModelExpression> allModelExpressions = databaseMathExpressions.getModelExpressions();
//        for (ModelExpression modelExpression : allModelExpressions) {
//            ArrayList<UserExpression> userExpressionsForModel = databaseMathExpressions.getUserExpressionsForModel(modelExpression.getId());
//            ExpressionClass expressionClass=new ExpressionClass(modelExpression,
//                    userExpressionsForModel);
//            expressions.add(expressionClass);
//        }
//
//        return expressions;
//    }

}

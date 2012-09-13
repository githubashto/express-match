/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MAIN;

import DatabaseMathExpressions.Util;
import br.usp.ime.faguilar.guis.ExpressionLevelGroundTruth;
import br.usp.ime.faguilar.guis.WellComeToSystem.PanWelcome;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author frank
 */
public class Main {
    public static void main(String args[]) {
        setLookAndFeel();
        startExpressMatch();

        //TO TEST GROUND-TRUTH FRAME
//        testGroundTurhFrame();

        // TO INITIALIZE GROUNT-TRUTHEXPRESSIONs
//        Util.initializeGroundTruth();
        // TO EVALUATE MATCHING
//        automaticEvaluation();
//        //temporary code
//        args=new String[3];
//        args[0]="test3_min.txt";
//        args[1]=String.valueOf(13);
//        args[2]=String.valueOf(14);
//        automaticEvaluation(args);
    }
//
//    public static void automaticEvaluation(String args[]){
//        Evaluator evaluator=new Evaluator();
//        evaluator.executeEvaluation(args[0],Integer.valueOf(args[1]),
//                Integer.valueOf(args[2]));
//    }
//
//    public static void automaticEvaluation(){
//        Evaluator evaluator=new Evaluator();
//        evaluator.executeEvaluation();
//    }

//    public static void testGroundTurhFrame(){
//        JFrame mainFrame=new JFrame("test");
//        ExpressionLevelGroundTruth panWelcome=new ExpressionLevelGroundTruth();
////        panWelcome.setContainerFrame(mainFrame);
//        mainFrame.setContentPane(panWelcome);
//        mainFrame.pack();
//        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        mainFrame.setVisible(true);
//    }

    public static void startExpressMatch(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame mainFrame=new JFrame("ExpressMatch");
                PanWelcome panWelcome=new PanWelcome();
                panWelcome.setContainerFrame(mainFrame);
                mainFrame.setContentPane(panWelcome);
                mainFrame.pack();
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setVisible(true);
            }
        });

       // code to print all diferen labels of symbols
//        DBFuntions dbFunctions=new DBFuntions();
//        dbFunctions.openConnection();
//        ArrayList<String> labels=new ArrayList<String>();
//
//        ArrayList<ModelExpression> models=dbFunctions.getAllModelExpressions();
//        int cont=0;
//
//        for (ModelExpression modelExpression : models) {
//            DMathExpression mathExpression=modelExpression.getdMathExpression();
//            for (DSymbol symbol : mathExpression) {
//                if(!contains(labels,symbol.getLabel()))
//                    labels.add(symbol.getLabel());
//                if(symbol.getLabel().isEmpty()){
//                    cont++;
//                    System.out.println("blank for model "+modelExpression.getId());
//                }
//            }
//
//
//        }
//        System.out.println("number of blanks: "+cont);
//        Collections.sort(labels);
//
//        System.out.println("number of clases of symbols: "+labels.size());
//        for (String label:labels) {
//            System.out.println(label);
//        }


        //generate data for Marcelo
//        String stringSymbols=SymbolDataGenerator.symbolsOfModelExpressions();
//        System.out.println(stringSymbols);
    }

    public static boolean contains(ArrayList<String> labels,String label){
        for (String element : labels) {
            if(element.equals(label))
                return true;
        }
        return false;
    }

    public static void setLookAndFeel(){
        try {
                    // Set System L&F
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            }
            catch (UnsupportedLookAndFeelException e) {
               // handle exception
            }
            catch (ClassNotFoundException e) {
               // handle exception
            }
            catch (InstantiationException e) {
               // handle exception
            }
            catch (IllegalAccessException e) {
               // handle exception
            }
    }
}

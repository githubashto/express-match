package Matching;

import java.util.Iterator;
import MathExpression.Data.DMathExpression;
import MathExpression.Data.DSymbol;
import org.apache.derby.impl.store.access.btree.LeafControlRow;

public class ExpressionMatching implements Matching {

    private DMathExpression model;
    private DMathExpression input;
    private GraphMatching gm;
    private boolean matching = false;
    private float alpha;
    private float beta;
    private float gama;
    private boolean delaunay;

    public ExpressionMatching() {
        this(null, null);
        alpha = 1.0f;
        beta = 0.0f;
        gama = 0.0f;
        delaunay = false;
    }

    public ExpressionMatching(DMathExpression model, DMathExpression input) {
        this.model = model;
        this.input = input;
    }

    public int[][] getMatches(float alpha, float beta, float gama, boolean delaunay) {
        if (this.model == null || this.input == null) {
            return null;
        }
        return this.match(alpha, beta, gama, delaunay);
    }

    private int[][] match(float alpha, float beta, float gama, boolean delaunay) {
        PreProcessing pp = new PreProcessing(model.toGraph(), input.toGraph());
        this.gm = new HungarianMatching(pp.getModel(), pp.getInput(), alpha, beta, gama, delaunay);
        return this.gm.getMatch();
    }

    public DMathExpression getModelGraph() {
        return model;
    }

    public void setModel(DMathExpression model) {
        this.model = model;
    }

    public DMathExpression getInputGraph() {
        return input;
    }

    public void setInput(DMathExpression input) {
        this.input = input;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public boolean isDelaunay() {
        return delaunay;
    }

    public void setDelaunay(boolean delaunay) {
        this.delaunay = delaunay;
    }

    public float getGama() {
        return gama;
    }

    public void setGama(float gama) {
        this.gama = gama;
    }

    ///////////////////////////////////////////////////////////
    /**********************************************************/
    /**
     * FRANK'S temporary code
     * @param dExpression1
     * @param dExpression2
     * @return
     */
    public String[][] match(DMathExpression dExpression1, DMathExpression dExpression2) {
        ExpressionMatching em = new ExpressionMatching(dExpression1, dExpression2);

        int[][] m = em.getMatches(alpha, beta, gama, delaunay);
        String[][] stringMatching = new String[m.length][m[0].length];

//        for (int i = 0; i < m.length; i++) {
//            if(dExpression1.get(m[i][0]).getId() != m[i][0]){
//                System.err.println("ERRO (model)\t" + m[i][0] + "\t-\t" + i);
//            }
//            if(dExpression2.get(m[i][1]).getId() != m[i][1]){
//                System.err.println("ERRO (input)\t" + m[i][1] + "\t-\t" + i);
//            }
//        }
        
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[0].length; j++) {
                stringMatching[i][j] = String.valueOf(m[i][j]);

            }
        }
        return stringMatching;
    }
}

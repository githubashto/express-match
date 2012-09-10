/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestMatching.AutomaticTest;

import DatabaseMathExpressions.ModelExpression;
import DatabaseMathExpressions.TextualRepresentation;
import DatabaseMathExpressions.UserExpression;
import MathExpression.Data.DMathExpression;
import Util.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frank
 */

//***********
// NOT USED. WRONG CLASS
//**********
public class DatabaseLinker {
    public static final String DEFAULT_NAME_DB_CONTENT="dbContent.data";

    public static final String DEFAULT_NAME_DB_USER="users.data";

    private PreparedStatement psGetAllModels;

    private PreparedStatement psGetUserExpressionsForModel;


    private final static String url="jdbc:derby://localhost:1527/ExpressMatchTest";

    private final static String driver="org.apache.derby.jdbc.ClientDriver";

    private final static String connectionUser="frank";

    private final static String password="expressmatch";

    private Connection connection;

    private boolean openConnection;

    public DatabaseLinker(){
        connection=null;
        openConnection=false;
    }

    public void openConnection(){
        try {

          Class.forName(driver).newInstance( );
          connection = DriverManager.getConnection(url, connectionUser,password);
          psGetAllModels=connection.prepareStatement("SELECT * FROM FRANK.MODEL_MATH_EXPRESSION" );

          psGetUserExpressionsForModel=connection.prepareStatement("SELECT * FROM FRANK.USER_MATH_EXPRESSION"
                  + " WHERE idModel = ?" );

          openConnection=true;
        }
        catch( Exception e ) {
          e.printStackTrace( );
        }
    }

    public ArrayList<ModelExpression> getAllModelExpressions(){
         ArrayList<ModelExpression> almE=new  ArrayList<ModelExpression>();
         TextualRepresentation textRep=null;
         String category=null;
         int id=-1;
        try {
            ResultSet rs = psGetAllModels.executeQuery();
            while(rs.next()){
                try {
                id=rs.getInt("id");
                byte[] bytes=rs.getBytes("textualRepresentations");
                if(bytes!=null){
                        textRep=(TextualRepresentation) Util.getObject(bytes);
                    }else{
                        textRep=new TextualRepresentation();
                    }
                DMathExpression mathE=(DMathExpression)Util.getObject(rs.getBytes("mathExpression"));
                category=rs.getString("category");
                ModelExpression modE=new ModelExpression(id, textRep,mathE);
                modE.setCategory(category);
                almE.add(modE);
                }
                catch (Exception e) {
                e.printStackTrace();
                }
            }
            psGetAllModels.clearParameters();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseLinker.class.getName()).log(Level.SEVERE, null, ex);
        }
         return almE;
    }

    public ArrayList<UserExpression> getUserExpressionsForModel(int idModel){
        ArrayList<UserExpression> alUE=new ArrayList<UserExpression>();
        try {
            psGetUserExpressionsForModel.setInt(1, idModel);
            psGetUserExpressionsForModel.executeQuery();
            ResultSet rs= psGetUserExpressionsForModel.getResultSet();
            int id;
            String idUser;
            Timestamp tm;
            boolean evaluated;
            DMathExpression dme;
            int[][] matching;
            while(rs.next()){
                id=rs.getInt("id");
                idUser=rs.getString("idUser");
                tm=rs.getTimestamp("timeOfInput");
                evaluated=rs.getBoolean("evaluated");
                dme=(DMathExpression) Util.getObject(rs.getBytes("mathExpression"));
                matching=(int[][])Util.getObject(rs.getBytes("matching"));
                UserExpression ue=new UserExpression(id,idModel, matching, dme,
                        evaluated, idUser, tm);
                alUE.add(ue);
            }
            psGetUserExpressionsForModel.clearParameters();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseLinker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alUE;
    }

    public boolean isOpenConnection() {
        return openConnection;
    }

    public void setOpenConnection(boolean openConnection) {
        this.openConnection = openConnection;
    }
}

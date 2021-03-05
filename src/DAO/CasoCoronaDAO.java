package DAO;

import Model.CasoCorona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CasoCoronaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void cadastrar(CasoCorona c){

        try{
            conn = Config.createConnection();

            String sql = "INSERT INTO casocorona (confirmados, suspeitos, recuperados, obitos, dataPesquisa) VALUES (?, ?, ?, ?, ?) ";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, c.getConfirmados());
            ps.setInt(2, c.getSuspeitos());
            ps.setInt(3, c.getRecuperados());
            ps.setInt(4, c.getObitos());
            ps.setTimestamp(5, converteData(c.getDataPesquisa()));

            ps.executeUpdate();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public java.sql.Timestamp converteData(Date date){
        java.sql.Timestamp dateSql = new java.sql.Timestamp(date.getTime());
        return dateSql;
    }
}

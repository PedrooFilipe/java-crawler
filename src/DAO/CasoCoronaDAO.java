package DAO;

import Model.CasoCorona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CasoCoronaDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void cadastrar(CasoCorona c){

        try{
            conn = Config.createConnection();

            String sql = "INSERT INTO casocorona (confirmados, suspeitos, recuperados, obitos) VALUES (?, ?, ?, ?) ";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, c.getConfirmados());
            ps.setInt(2, c.getSuspeitos());
            ps.setInt(3, c.getRecuperados());
            ps.setInt(4, c.getObitos());

            ps.executeUpdate();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void atualizar(CasoCorona c){

        try{
            conn = Config.createConnection();

            String sql = "UPDATE casoCorona SET  confirmados = ?, suspeitos = ?, recuperados = ?, obitos = ?  WHERE id = 1 ";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, c.getConfirmados());
            ps.setInt(2, c.getSuspeitos());
            ps.setInt(3, c.getRecuperados());
            ps.setInt(4, c.getObitos());

            ps.executeUpdate();

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public CasoCorona procurar(){
        CasoCorona c = new CasoCorona();
        String sql = "SELECT id, confirmados, suspeitos, recuperados, obitos FROM casoCorona WHERE id = 1 ";

        try{
            conn = Config.createConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setConfirmados(rs.getInt("confirmados"));
                c.setSuspeitos(rs.getInt("suspeitos"));
                c.setRecuperados(rs.getInt("recuperados"));
                c.setObitos(rs.getInt("obitos"));
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}

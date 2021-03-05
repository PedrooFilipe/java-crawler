package principal;

import DAO.CasoCoronaDAO;
import Model.CasoCorona;
import java.util.Date;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String url = "https://acoescoronavirus.uniaodospalmares.al.gov.br";
    private static Map<String, Integer> casos = new HashMap<String, Integer>();
    private static CasoCoronaDAO casoCoronaDAO = new CasoCoronaDAO();

    public static void main(String[] args) {
        Document doc = request();

        if(doc != null){
            String key = null;
            int value = 0;
            for(Element elements : doc.select(".single-counter-box")){

                for(Element newElement : elements.select("p")){
                    key = newElement.text();
                }

                for(Element newElement : elements.select(".counter")){
                    value = Integer.parseInt(newElement.text());
                }

                casos.put(key, value);
            }
            
            CasoCorona casoCorona = new CasoCorona(
                    casos.get("Confirmados"),
                    casos.get("Suspeitos"),
                    casos.get("Recuperados"),
                    casos.get("Óbitos"),
                    new Date()
            );
            
            System.out.println("Confirmados: " + casoCorona.getConfirmados());
            System.out.println("Suspeitos: " + casoCorona.getSuspeitos());
            System.out.println("Recuperados: " + casoCorona.getRecuperados());
            System.out.println("Óbitos: " + casoCorona.getObitos());
            
            try {
                casoCoronaDAO.cadastrar(casoCorona);
                System.out.println("Dados salvos com sucesso!");
            }catch (Exception e){
                System.out.println("Erro ao salvar dados!");
            }
        }
    }

    private static Document request(){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();
            System.out.println("Conectando a URL");

            if(con.response().statusCode() == 200){
                System.out.println("Sucesso ao conectar URL");
                return doc;
            }
            return null;
        }catch (Exception e){
            System.out.println("Erro ao conectar a URL");
            return null;
        }
    }
}

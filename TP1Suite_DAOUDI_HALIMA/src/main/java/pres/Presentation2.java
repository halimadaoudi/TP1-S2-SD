package pres;
import dao.IDao;
import metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("config.txt"));

        // lit la 1er ligne du file qui represente le nom de la classe qui implemente Idao
        String daoClass = sc.nextLine();
        // instancier l'interface Idao en utilisant son nom chargé par scanner
        Class cDao = Class.forName(daoClass);
        IDao dao = (IDao) cDao.newInstance() ;
        // lit la ligne suivante du file qui represente le nom de classe qui implemente Imetier
        String Metierclass = sc.nextLine();
        // instancier l'interface Imetier en utilisant son nom chargé par scanner
        Class cMetier = Class.forName(Metierclass);
        IMetier metier = (IMetier) cMetier.newInstance() ;

        Method method = cMetier.getMethod("setDao" , IDao.class) ;
        method.invoke(metier,dao) ; // = metier.setDao(dao)
        System.out.println("Résultat : " + metier.calcul());
    }
}

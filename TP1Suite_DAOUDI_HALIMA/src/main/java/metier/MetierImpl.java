package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{

    // couplage faible
    @Autowired
    private IDao dao;
    @Override
    public double calcul() {
        double temp = dao.getData();
        return temp *1000 / Math.cos(temp * Math.PI);
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}

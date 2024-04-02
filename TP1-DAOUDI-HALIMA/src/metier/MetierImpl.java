package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    // couplage faible
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

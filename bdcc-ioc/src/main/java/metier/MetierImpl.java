package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao = null;

    public MetierImpl() {
        dao = new DaoImpl();
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public double calcul() {
        double temp = dao.gitData();
        double result = temp * 23;
        return result;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}

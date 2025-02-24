package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao {
    public double gitData() {
        System.out.println("version of database");
        double temp = 34.5;
        return temp;
    }
}

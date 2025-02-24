package presentation;

import dao.DaoImpl;
import metier.IMetier;
import metier.MetierImpl;

public class presentation1 {
    public static void main(String[] args) {
        MetierImpl  metier = new MetierImpl();
        DaoImpl dao = new DaoImpl();
        metier.setDao(dao);
        double result = metier.calcul();
        System.out.println("result = " + result);
    }
}

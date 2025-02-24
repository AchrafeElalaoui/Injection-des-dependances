package presentation;

import dao.DaoImpl;
import metier.IMetier;
import metier.MetierImpl;

public class presentation1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl  metier = new MetierImpl(dao);
        double result = metier.calcul();
        System.out.println("result = " + result);
    }
}

package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class prsentation2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);

            // using the constructor that takes an IDao object as an argument
            IMetier metierC = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            // using the default constructor and then calling the setDao method
            IMetier metierS = (IMetier) cMetier.getConstructor().newInstance();
            Method setDao = cMetier.getMethod("setDao", IDao.class);
            setDao.invoke(metierS, dao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

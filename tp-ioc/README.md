# Injection des dependances
 this project is a simple practical work for testing and see the importance of dependency injection in a project.
1. Créer l'interface IDao avec une méthode getData
```java
public interface IDao {
    public double getData();
}
```
2. Créer une implémentation de cette interface
```java
public class DaoImpl implements IDao {
    public double gitData() {
        System.out.println("version of database");
        double temp = 34.5;
        return temp;
    }
}
```
3. Créer l'interface IMetier avec une méthode calcul
```java
public interface IMetier {
    double calcul();
}
```
4. Créer une implémentation de cette interface en utilisant le couplage faible
## 
a) injection des dépendances via le setter (instonciation statique => new) 
```java
public class MetierImpl implements IMetier {
    private IDao dao = null;
    public double calcul() {
        double temp = dao.gitData();
        double result = temp * 23;
        return result;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
```
b) injection des dépendances via le constructeur (instonciation statique => new)
```java
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
}
```
5. Créer une classe de test
## instonciation statique => new
a) injection des dépendances via le setter 
```java
public class presentation1 {
    public static void main(String[] args) {
        MetierImpl  metier = new MetierImpl();
        DaoImpl dao = new DaoImpl();
        metier.setDao(dao);
        double result = metier.calcul();
        System.out.println("result = " + result);
    }
}
```
b) injection des dépendances via le constructeur 
```java
public class presentation1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl  metier = new MetierImpl(dao);
        double result = metier.calcul();
        System.out.println("result = " + result);
    }
}
```
## instonciation dunamique
```java

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
```
#### result
```text
version of database
result = 793.5
```
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
5. Créer une classe de test
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
#### result
```text
version of database
result = 793.5
```
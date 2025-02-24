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
a) injection des dépendances utilisons spring via xml
the .xml file :
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="dao" class="dao.DaoImpl"></bean>
    <bean id="metier" class="metier.MetierImpl">
        <!-- injection via setter -->
        <property name="dao" ref="dao"></property>
        <!-- injection via constructor -->
        <constructor-arg ref="dao"></constructor-arg>
    </bean>

</beans>
```
```java
public class PresSpringVXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Result"+metier.calcul());
    }
}
```
#### result
```text
version of database
result = 793.5
```
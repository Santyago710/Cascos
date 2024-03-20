package SalesPoints;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bonification  implements Serializable {
    public int bonificationID;
    public String ConsumerID;
    public String bonificationDate;
    public int redeemPoints;

    public Bonification(int bonoficationID, String consumerID, String bonoficationDate, int redeemPoints) {
        this.bonificationID = bonoficationID;
        this.ConsumerID = consumerID;
        this.bonificationDate = bonoficationDate;
        this.redeemPoints = redeemPoints;
    }

    public static int pickUpBono(String userID, int bonoOption, float bonoPoints) throws IOException, ClassNotFoundException {
        int menuBono =0;
        int bonoCode = 0;
        int spendPoints = 0;
        //Método para generar la fecha del día
        LocalDate actualDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String RedeemBonoDate = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //RECOMPENSA 1
        if(bonoOption==1){
            System.out.println("---------------ADIÓS SUEÑO (50 Puntos)-------------");
            System.out.println("Consiste en un cupón para reclamar un delicioso Tinto.");
            System.out.println("¿Desea reclamar esta recompensa? 1 para CONFIRMAR y 2 SALIR.");
            menuBono = CommonMethods.ExceptionMenuBono(menuBono);
            if(menuBono==1){
                if(bonoPoints<50){
                    System.out.println("Estimado Cliente no cuentas con los puntos suficientes");
                }
                else {
                    //Generador de código para reclamar el bono
                    bonoCode = (int) (Math.random() * 999999);
                    RedeemBonoDate = actualDate.format(formatter);
                    Bonification bono1 = new Bonification(bonoCode, userID, RedeemBonoDate, 50);
                    //Escribe los atributos de la bonificación en el fichero
                    FileOutputStream fileOutputStreamAdmin = new FileOutputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectOutputStream objectOutStreamAdmin = new ObjectOutputStream(fileOutputStreamAdmin);
                    objectOutStreamAdmin.writeObject(bono1);
                    objectOutStreamAdmin.close();
                    //Lee e imprime los atributos de la bonificación canjeada
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Bonification savedBonification = (Bonification) objectInputStream.readObject();
                    System.out.println(savedBonification);
                    objectInputStream.close();
                    spendPoints = 50;
                }
            }
        }

        //RECOMPENSA 2
        if(bonoOption==2){
            System.out.println("---------------ADIÓS HAMBRE (100 Puntos)-------------");
            System.out.println("Consiste en un cupón para reclamar una rica Empanada.");
            System.out.println("¿Desea reclamar esta recompensa? 1 para CONFIRMAR y 2 SALIR.");
            menuBono = CommonMethods.ExceptionMenuBono(menuBono);
            if(menuBono==1) {
                if (bonoPoints < 100) {
                    System.out.println("Estimado Cliente no cuentas con los puntos suficientes");
                }
                else {
                    //Generador de código para reclamar el bono
                    bonoCode = (int) (Math.random() * 999999);
                    RedeemBonoDate = actualDate.format(formatter);
                    Bonification bono2 = new Bonification(bonoCode, userID, RedeemBonoDate, 100);
                    //Escribe los atributos de la bonificación en el fichero
                    FileOutputStream fileOutputStreamAdmin = new FileOutputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectOutputStream objectOutStreamAdmin = new ObjectOutputStream(fileOutputStreamAdmin);
                    objectOutStreamAdmin.writeObject(bono2);
                    objectOutStreamAdmin.close();
                    //Lee e imprime los atributos de la bonificación canjeada
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Bonification savedBonification = (Bonification) objectInputStream.readObject();
                    System.out.println(savedBonification);
                    objectInputStream.close();
                    spendPoints = 100;
                }
            }
        }

        //RECOMPENSA 3
        if(bonoOption==3){
            System.out.println("---------------NO TRAIGO ALMUERZO (200 Puntos)-------------");
            System.out.println("Consiste en un cupón para reclamar un delicioso JugoHit y una Arepa Quesuda .");
            System.out.println("¿Desea reclamar esta recompensa? 1 para CONFIRMAR y 2 SALIR.");
            menuBono = CommonMethods.ExceptionMenuBono(menuBono);
            if(menuBono==1){
                if(bonoPoints<50){
                    System.out.println("Estimado Cliente no cuentas con los puntos suficientes");
                }
                else {
                    //Generador de código para reclamar el bono
                    bonoCode = (int) (Math.random() * 999999);
                    RedeemBonoDate = actualDate.format(formatter);
                    Bonification bono3 = new Bonification(bonoCode, userID, RedeemBonoDate, 200);
                    //Escribe los atributos de la bonificación en el fichero
                    FileOutputStream fileOutputStreamAdmin = new FileOutputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectOutputStream objectOutStreamAdmin = new ObjectOutputStream(fileOutputStreamAdmin);
                    objectOutStreamAdmin.writeObject(bono3);
                    objectOutStreamAdmin.close();
                    //Lee e imprime los atributos de la bonificación canjeada
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RedeemedBono.txt");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Bonification savedBonification = (Bonification) objectInputStream.readObject();
                    System.out.println(savedBonification);
                    objectInputStream.close();
                    spendPoints = 200;
                }
            }
        }
        return spendPoints;
    }

}

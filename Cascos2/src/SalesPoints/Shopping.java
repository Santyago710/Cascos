package SalesPoints;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Shopping implements Serializable {
    public String consumerID;
    public String consumerName;
    private String shoppingCode;
    private String shoppingDate;
    private float bonoPoints;
    private float value;

    public Shopping(String consumerID,String consumerName,String shoppingCode, String shoppingDate, float value, float bonoPoints) {
        this.consumerID = consumerID;
        this.consumerName = consumerName;
        this.shoppingCode = shoppingCode;
        this.shoppingDate = shoppingDate;
        this.bonoPoints = bonoPoints;
        this.value = value;
    }

    //Getters and Setters
    public String getShoppingCode() {
        return shoppingCode;
    }
    public void setShoppingCode(String shoppingCode) {
        this.shoppingCode = shoppingCode;
    }
    public String getShoppingDate() {
        return shoppingDate;
    }
    public void setShoppingDate(String shoppingDate) {
        this.shoppingDate = shoppingDate;
    }
    public float getBonoPoints() {return bonoPoints;}
    public void setBonoPoints(float bonoPoints) {this.bonoPoints = bonoPoints;}
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }

    public static Shopping registerBuy(String clienteId, String clienteName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el código de la compra:");
        String ShoppingCodeAux = in.readLine();
        LocalDate actualDate = LocalDate.now();
        //La fecha se asigna automáticamente
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String ShoppingDateAux = actualDate.format(formatter);
        System.out.println("Ingrese el valor de la compra:");
        float ShoppingValueAux = Float.parseFloat(in.readLine());
        //Por cada $1000 se agregan 10 bonoPoints
        float ShoppingBonoPointsAux = ShoppingValueAux / 1000;
        System.out.println("Puntos Ganados:" + ShoppingBonoPointsAux);
        Shopping buy = new Shopping(clienteId, clienteName, ShoppingCodeAux, ShoppingDateAux, ShoppingValueAux, ShoppingBonoPointsAux);
        //Lee los datos de la compra registrada
        FileOutputStream fileOutputStreamAdmin = new FileOutputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RegisteredBuys.txt");
        ObjectOutputStream objectOutStreamAdmin= new ObjectOutputStream(fileOutputStreamAdmin);
        objectOutStreamAdmin.writeObject(buy);
        objectOutStreamAdmin.close();
        return buy;
    }

    public static void showHistorial(String clienteId) {
        System.out.println("Mostrando Historial de compras registradas....");
        //Hacer una Query a la DB de todos los registros de compras de acuerdo al argumento recibido (clienteId)
    }

    @Override
    public String toString() {
        return  consumerID + '\'' +
                ";" + consumerName +'\'' +
                ";" + shoppingCode + '\'' +
                ";" + shoppingDate + '\'' +
                ";" + bonoPoints +
                ";" + value ;
    }
}

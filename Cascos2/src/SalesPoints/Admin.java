package SalesPoints;

import java.io.*;

public class Admin extends User implements Serializable{


    public Admin (String userID, String nameUser, String emailUser, String passwordUser) {
        super (userID,nameUser,emailUser,passwordUser);
    }

    @Override
    public String getUserID() {
        return super.getUserID();
    }
    @Override
    public void setUserID(String userID) {
        super.setUserID(userID);
    }
    @Override
    public String getNameUser() {
        return super.getNameUser();
    }
    @Override
    public void setNameUser(String nameUser) {
        super.setNameUser(nameUser);
    }
    @Override
    public void setPasswordUser(String passwordUser) {
        super.setPasswordUser(passwordUser);
    }
    @Override
    public String getPasswordUser() {
        return super.getPasswordUser();
    }
    @Override
    public boolean login(String userNameAux, String passwordAux) throws IOException {
        boolean VerifiedAdmin;
        if (userNameAux.equals(getNameUser()) && passwordAux.equals(getPasswordUser()))
        {
            System.out.println("Nombre y contraseña de Administrador correctos");
            return VerifiedAdmin = true;
        }
        else{
            return VerifiedAdmin = false;
        }
    }
    public void checkSales(int menu) throws IOException, ClassNotFoundException {
        System.out.println("Revisando ventas registradas....");
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\RegisteredBuys.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Shopping savedBuys = (Shopping) objectInputStream.readObject();
        System.out.println("---------VENTAS REGISTRADAS---------");
        System.out.println(savedBuys);
        objectInputStream.close();
    }
    public void checkConsumers(int menu) throws IOException, ClassNotFoundException {
        System.out.println("Revisando Clientes registrados....");
        //Lee e imprime los atributos del cliente registrado (clienteNew)
        FileInputStream fileInputStreamCliente = new FileInputStream("C:\\Users\\JAIBER DÌAZ\\IdeaProjects\\Java-Learning\\Ficheros\\ObjetoCliente.txt");
        ObjectInputStream objectInputStreamCliente = new ObjectInputStream(fileInputStreamCliente);
        Cliente savedcliente = (Cliente) objectInputStreamCliente.readObject();
        System.out.println("---------CLIENTES REGISTRADOS---------");
        //Leer base de datos
        System.out.println(savedcliente);
        objectInputStreamCliente.close();
    }
    //Formato CSV
    @Override
    public String toString() {
        return  userID +
                ';' + nameUser +
                ';' + passwordUser +
                ";" + emailUser;
    }
}

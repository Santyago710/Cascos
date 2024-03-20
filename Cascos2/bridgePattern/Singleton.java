// Singleton
class AccesoriosCascoSingleton {
    private static AccesoriosCascoSingleton instance;
    private String accesorios;

    private AccesoriosCascoSingleton() {
        accesorios = "";
    }

    public static AccesoriosCascoSingleton getInstance() {
        if (instance == null) {
            instance = new AccesoriosCascoSingleton();
        }
        return instance;
    }

    public void agregarAccesorio(String accesorio) {
        accesorios += accesorio + "\n";
    }

    public String agregarAccesorios() {
        return accesorios;
    }
}

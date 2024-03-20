//Estructura para guiarse del patron de diseño bridge

// Implementor interface

interface AccesoriosCasco {
    void agregarAccesorio(String accesorio);
    String agregarAccesorios();
}

// Concrete Implementor 1
class AccesoriosCascoBasico implements AccesoriosCasco {
    private String accesorios = "";

    @Override
    public void agregarAccesorio(String accesorio) {
        accesorios += accesorio + "\n";
    }

    @Override
    public String agregarAccesorios() {
        return "Accesorios Básicos del Casco:\n" + accesorios;
    }
}

// Concrete Implementor 2
class AccesoriosCascoPremium implements AccesoriosCasco {
    private String accesorios = "";

    @Override
    public void agregarAccesorio(String accesorio) {
        accesorios += accesorio + "\n";
    }

    @Override
    public String agregarAccesorios() {
        return "Accesorios Premium del Casco:\n" + accesorios;
    }
}
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
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

// Concrete Implementor 3
class AccesoriosCascoStandard  implements AccesoriosCasco {
    private String accesorios = "";

    @Override
    public void agregarAccesorio(String accesorio) {
        accesorios += accesorio + "\n";
    }

    @Override
    public String agregarAccesorios() {
        return "Accesorios Standard del Casco:\n" + accesorios;
    }
}

public class Estudiante {
    private String carnet;
    private int materiasInscritas;
    private int creditosInscritos;

    public Estudiante(String carnet, int materiasInscritas, int creditosInscritos) {
        this.carnet = carnet;
        this.materiasInscritas = materiasInscritas;
        this.creditosInscritos = creditosInscritos;
    }

    public String getCarnet() {
        return carnet;
    }

    public int getMateriasInscritas() {
        return materiasInscritas;
    }

    public int getCreditosInscritos() {
        return creditosInscritos;
    }

    public double getMontoPagar() {
        if (creditosInscritos < 8) {
            return creditosInscritos * 10000;
        } else if (creditosInscritos <= 12) {
            return creditosInscritos * 13000;
        } else {
            return creditosInscritos * 20000;
        }
    }
}

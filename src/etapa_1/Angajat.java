package etapa_1;
//clasa abstracta nu va avea instante
abstract public class Angajat {
    protected String nume;
    protected Integer salariu;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }
}

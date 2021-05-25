package etapa_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pacient {
    private String nume;
    private String orasDomiciliu;
    private Set<ServiciuMedical> serviciiAccesate = new HashSet<>();
    private List<Programare> listaProgramariEfectuate = new ArrayList<>();
    private List<Recenzie> listaRecenziiDate = new ArrayList<>();
    public Pacient(String nume, String orasDomiciliu) {
        this.nume = nume;
        this.orasDomiciliu = orasDomiciliu;
    }

    void adaugaRecenzie(Recenzie recenzie)
    {
        listaRecenziiDate.add(recenzie);
    }

    void adaugaProgramare(Programare programare)
    {
        listaProgramariEfectuate.add(programare);
        serviciiAccesate.add(programare.getServiciuMedical());
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOrasDomiciliu() {
        return orasDomiciliu;
    }

    public void setOrasDomiciliu(String orasDomiciliu) {
        this.orasDomiciliu = orasDomiciliu;
    }

    public Set<ServiciuMedical> getServiciiAccesate() {
        return serviciiAccesate;
    }

    public void setServiciiAccesate(Set<ServiciuMedical> serviciiAccesate) {
        this.serviciiAccesate = serviciiAccesate;
    }

    public List<Programare> getListaProgramariEfectuate() {
        return listaProgramariEfectuate;
    }

    public void setListaProgramariEfectuate(List<Programare> listaProgramariEfectuate) {
        this.listaProgramariEfectuate = listaProgramariEfectuate;
    }
}

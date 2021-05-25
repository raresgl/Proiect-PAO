package etapa_2;

public class Recenzie {
    private Integer nota;
    private Pacient pacientReviewer;
    private Medic medic;
    private ServiciuMedical serviciuMedical;


    public Recenzie(Integer nota, Pacient pacientReviewer, Medic medic, ServiciuMedical serviciuMedical) {
        this.nota = nota;
        this.pacientReviewer = pacientReviewer;
        this.medic = medic;
        this.serviciuMedical = serviciuMedical;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Pacient getPacientReviewer() {
        return pacientReviewer;
    }

    public void setPacientReviewer(Pacient pacientReviewer) {
        this.pacientReviewer = pacientReviewer;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public ServiciuMedical getServiciuMedical() {
        return serviciuMedical;
    }

    public void setServiciuMedical(ServiciuMedical serviciuMedical) {
        this.serviciuMedical = serviciuMedical;
    }
}

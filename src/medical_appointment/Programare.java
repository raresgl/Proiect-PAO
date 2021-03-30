package medical_appointment;

public class Programare {
    private Medic medic;
    private Pacient pacient;
    private Receptionist receptionist;
    private ServiciuMedical serviciuMedical;

    public Programare(Medic medic, Pacient pacient, Receptionist receptionist, ServiciuMedical serviciuMedical) {
        this.medic = medic;
        this.pacient = pacient;
        this.receptionist = receptionist;
        this.serviciuMedical = serviciuMedical;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public ServiciuMedical getServiciuMedical() {
        return serviciuMedical;
    }

    public void setServiciuMedical(ServiciuMedical serviciuMedical) {
        this.serviciuMedical = serviciuMedical;
    }
}

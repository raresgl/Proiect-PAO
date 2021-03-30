package medical_appointment;

public class ServiciuMedical {
    private Integer cost;
    private String numeServiciuMedical;

    public ServiciuMedical(Integer cost, String numeServiciuMedical) {
        this.cost = cost;
        this.numeServiciuMedical = numeServiciuMedical;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getNumeServiciuMedical() {
        return numeServiciuMedical;
    }

    public void setNumeServiciuMedical(String numeServiciuMedical) {
        this.numeServiciuMedical = numeServiciuMedical;
    }



}

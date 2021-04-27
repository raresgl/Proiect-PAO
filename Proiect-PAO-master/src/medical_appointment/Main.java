package medical_appointment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String PATH1 = "data/";
        String PATH2 = "results/";

        ReadFileService reader = ReadFileService.getInstance();
        WriteFileService writer = WriteFileService.getInstance();

        MedicalAppointmentService medicalAppointmentService = new MedicalAppointmentService();

        var cabinete = reader.readCabinete(PATH1 + "cabinete.csv");
        var pacienti = reader.readPacienti(PATH1+"pacienti.csv");
        var receptionisti = reader.readReceptionisti(PATH1+"receptionisti.csv", cabinete);
        var serviciiMedicale = reader.readServiciiMedicale(PATH1+"serviciimedicale.csv");
        var medici = reader.readMedici(PATH1+"medici.csv", cabinete, serviciiMedicale);
        var programari = reader.readProgramari(PATH1+"programari.csv",medici,
                pacienti,receptionisti,serviciiMedicale);

        var cabinet = cabinete.get(0);
        var cabinet2 = cabinete.get(1);
        var pacient = pacienti.get(0);
        var pacient2 = pacienti.get(1);
        var medic = medici.get(0);
        var serviciuMedical = serviciiMedicale.get(0);
        var receptionist = receptionisti.get(0);

        writer.writeCabinet(cabinet, PATH2+"cabinete.csv");
        writer.writeCabinet(cabinet2, PATH2+"cabinete.csv");
        writer.writePacient(pacient, PATH2+"pacienti.csv");
        writer.writePacient(pacient2, PATH2+"pacienti.csv");
        writer.writeMedic(medic,PATH2+"medici.csv");
        writer.writeReceptionist(receptionist, PATH2+"receptionisti.csv");


        medicalAppointmentService.ShowTotalSalariiCabinet(cabinet);
        medicalAppointmentService.ShowTotalSalariiCabinet(cabinet2);

        medicalAppointmentService.CreateRecenzie(pacient,cabinet,medic,serviciuMedical);
        medicalAppointmentService.CreateRecenzie(pacient2,cabinet2,medic,serviciuMedical);

        medicalAppointmentService.ShowMediciDinCabinetulDupaRecenzii(cabinet);
        medicalAppointmentService.ShowServiciiDinCabinet(cabinet);


    }
}

package medical_appointment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileService {

    private static WriteFileService instance;

    public static WriteFileService getInstance()
    {
        if (instance == null)
            instance = new WriteFileService();
        return instance;
    }




    public void writeCabinet(Cabinet cabinet, String path)
    {
        File csvFile = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.append(cabinet.getNumeCabinet() + "," + cabinet.getAdresaCabinet());
            for(var angajat : cabinet.getSetAngajati())
            {
                bw.append("," +angajat.getNume());
            }
            bw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AuditService.logAuditFile("writeCabinet");
    }

    public void writeMedic(Medic medic, String path)
    {
        File csvFile = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.append(medic.getNume() + "," + medic.getSalariu());
            for(var recenzii : medic.getListaRecenziiPrimite())
            {
                bw.append("," + recenzii.getNota() + "," + recenzii.getPacientReviewer().getNume());
            }
            bw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AuditService.logAuditFile("writeMedic");
    }

    public void writeReceptionist(Receptionist receptionist, String path)
    {
        File csvFile = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.append(receptionist.getNume() + "," + receptionist.getSalariu() + "," +
                    receptionist.getCabinet().getNumeCabinet());
            bw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AuditService.logAuditFile("writeReceptionist");
    }

    public void writePacient(Pacient pacient, String path)
    {
        File csvFile = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.append(pacient.getNume() + "," + pacient.getOrasDomiciliu() );
            for (var serviciu : pacient.getServiciiAccesate())
            {
                bw.append("," + serviciu.getNumeServiciuMedical() + "," + serviciu.getCost());
            }
            bw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AuditService.logAuditFile("writePacient");
    }





}

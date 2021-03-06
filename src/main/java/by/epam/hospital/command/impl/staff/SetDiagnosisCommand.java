package by.epam.hospital.command.impl.staff;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.command.CommandHelper;
import by.epam.hospital.entity.Diagnosis;
import by.epam.hospital.entity.Person;
import by.epam.hospital.entity.PersonDiagnosis;
import by.epam.hospital.entity.Prescription;
import by.epam.hospital.service.DiagnosisService;
import by.epam.hospital.service.PersonDiagnosisService;
import by.epam.hospital.service.PersonService;
import by.epam.hospital.service.PrescriptionService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;
import by.epam.hospital.utils.UserUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SetDiagnosisCommand implements Command {

    private static final Logger logger = Logger.getLogger(SetDiagnosisCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (!UserUtils.getInstance().hasAccess(request, PagesManager.getProperty("path.page.setDiagnosisPage"))) {
            return PagesManager.getProperty("path.page.error.accessDenied");
        }

        logger.debug("Try to set diagnosis");
        HttpSession session = request.getSession();

        List<PersonDiagnosis> diagnosisList = new ArrayList<>();
        PersonDiagnosis personDiagnosis = new PersonDiagnosis();

        Person person = (Person) session.getAttribute("newPerson");
        if (person == null) {
            diagnosisList = (List<PersonDiagnosis>) session.getAttribute("patientDiagnosis");
            personDiagnosis.setPatient((Person) session.getAttribute("person"));
        } else {
            String s = request.getParameter("chambers");
            Long idChamber = null;
            if (s != null) {
                idChamber = Long.valueOf(s);
            }

            person.setIdChamber(idChamber);
            personDiagnosis.setPatient(person);
        }

        boolean invalid = false;
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(request.getParameter("diagnosis"));
        if(diagnosis.getName().isEmpty()){
            invalid = true;
        }
        diagnosis.setDescription(request.getParameter("description").trim());

        Prescription prescription = new Prescription();
        prescription.setDrugs(request.getParameter("drugs"));
        prescription.setProcedure(request.getParameter("procedure"));
        prescription.setOperation(request.getParameter("operation"));

        DiagnosisService diagnosisService = ServiceFactory.getDiagnosisService();
        diagnosisService.insertDiagnosis(diagnosis);

        PrescriptionService prescriptionService = ServiceFactory.getPrescriptionService();
        prescriptionService.insertPrescription(prescription);

        personDiagnosis.setDoctor((Person) session.getAttribute("user"));
        personDiagnosis.setDiagnosis(diagnosis);
        personDiagnosis.setPrescription(prescription);
        personDiagnosis.setDate(new Timestamp(System.currentTimeMillis()));
        personDiagnosis.setDischargeDate(null);

        if(invalid){
            session.setAttribute("prescript", prescription);
            session.setAttribute("diagnosis", diagnosis);
            session.setAttribute("incorrectDiagnosis", "incorrectDiagnosis");
            return (String) session.getAttribute("currentPage");
        }

        PersonDiagnosisService personDiagnosisService = ServiceFactory.getPersonDiagnosisService();
        if (personDiagnosisService.insertPatientDiagnosis(personDiagnosis)) {
            logger.debug("successfull added");
            diagnosisList.add(0, personDiagnosis);
            session.setAttribute("patientDiagnosis", diagnosisList);

            if (person != null) {
                PersonService service = ServiceFactory.getPersonService();
                service.updateChamber(person);
            }
        }

        String page;
        if (person == null) {
            page = PagesManager.getProperty("path.page.editPatientPage");
            session.removeAttribute("removeNotAllowed");
        } else {
            Command redirect = CommandHelper.getInstance().defineCommand("redirect");
            return redirect.execute(request, response);
        }
        session.removeAttribute("prescript");
        session.removeAttribute("diagnosis");
        session.removeAttribute("incorrectDiagnosis");
        session.setAttribute("currentPage", page);
        return page;
    }

}

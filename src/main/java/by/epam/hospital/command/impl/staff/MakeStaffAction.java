package by.epam.hospital.command.impl.staff;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.entity.Person;
import by.epam.hospital.entity.PersonDiagnosis;
import by.epam.hospital.entity.Prescription;
import by.epam.hospital.service.PrescriptionService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;
import by.epam.hospital.utils.UserUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MakeStaffAction implements Command {

    private static final Logger logger = Logger.getLogger(MakeStaffAction.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (!UserUtils.getInstance().hasAccess(request, PagesManager.getProperty("path.page.editPatientPage"))
                && !UserUtils.getInstance().hasAccess(request, PagesManager.getProperty("path.page.nurseMainPage"))) {
            return PagesManager.getProperty("path.page.error.accessDenied");
        }

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String action = request.getParameter("whatAction");

        logger.debug("Try to make this action: " + action);

        Long prescriptionId = Long.valueOf(request.getParameter("prescriptionId"));
        List<PersonDiagnosis> diagnosisList = (List<PersonDiagnosis>) session.getAttribute("patientDiagnosis");
        PrescriptionService prescriptionService = ServiceFactory.getPrescriptionService();

        for (PersonDiagnosis personDiagnosis : diagnosisList) {
            Prescription p = personDiagnosis.getPrescription();
            if (personDiagnosis.getPrescription().getIdPrescription().equals(prescriptionId)) {
                switch (action) {
                    case "drugs":
                        p.setDrugs("");
                        break;
                    case "operation":
                        if (person.getRole().getName().equals("doctor")) {
                            p.setOperation("");
                        }
                        break;
                    case "procedure":
                        p.setProcedure("");
                        break;
                }
                if (prescriptionService.updatePrescription(p)) {
                    logger.debug("successful action");
                } else {
                    logger.debug("unsuccussful action");
                }
                break;
            }
        }

        session.setAttribute("patientDiagnosis", diagnosisList);
        return (String) session.getAttribute("currentPage");
    }

}

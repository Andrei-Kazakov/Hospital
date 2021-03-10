package by.epam.hospital.command.impl.staff;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.entity.PersonDiagnosis;
import by.epam.hospital.service.PersonDiagnosisService;
import by.epam.hospital.service.factory.ServiceFactory;
import by.epam.hospital.utils.PagesManager;
import by.epam.hospital.utils.UserUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RemovePersonDiagnosisCommand implements Command {

    private static final Logger logger = Logger.getLogger(RemovePersonDiagnosisCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (!UserUtils.getInstance().hasAccess(request, PagesManager.getProperty("path.page.editPatientPage"))) {
            return PagesManager.getProperty("path.page.error.accessDenied");
        }

        logger.debug("Try to remove person diagnosis from database");
        HttpSession session = request.getSession();

        List<PersonDiagnosis> personDiagnoses = (List<PersonDiagnosis>) session.getAttribute("patientDiagnosis");

        Long idPatient = Long.valueOf(request.getParameter("idPatient"));
        Long idStaff = Long.valueOf(request.getParameter("idStaff"));
        Long idDiagnosis = Long.valueOf(request.getParameter("idDiagnosis"));
        Long idPrescription = Long.valueOf(request.getParameter("idPrescription"));

        PersonDiagnosisService personDiagnosisService = ServiceFactory.getPersonDiagnosisService();
        PersonDiagnosis personDiagnosis = personDiagnosisService.findPersonDiagnosis(idPatient, idStaff,
                idPrescription, idDiagnosis);

        if (personDiagnosis != null) {
            logger.debug("successful");
            personDiagnoses.remove(personDiagnosis);
            personDiagnosisService.deletePatientDiagnosis(personDiagnosis);

            int openPersonDiagnoses = 0;
            for (PersonDiagnosis pd : personDiagnoses) {
                if (pd.getDischargeDate() == null) {
                    openPersonDiagnoses++;
                }
            }
            if(openPersonDiagnoses == 1){
                session.setAttribute("removeNotAllowed", "removeNotAllowed");
            }

            session.setAttribute("patientDiagnosis", personDiagnoses);
        } else {
            logger.debug("failed");
            session.setAttribute("errorPD", "Error when try to delete person diagnosis");
        }

        return (String) session.getAttribute("currentPage");
    }

}

package by.epam.hospital.command;

import org.apache.log4j.Logger;
import by.epam.hospital.command.impl.*;
import by.epam.hospital.command.impl.admin.*;
import by.epam.hospital.command.impl.authorization.LoginCommand;
import by.epam.hospital.command.impl.authorization.LogoutCommand;
import by.epam.hospital.command.impl.profile.ChangePasswordCommand;
import by.epam.hospital.command.impl.profile.UpdateProfileCommand;
import by.epam.hospital.command.impl.staff.*;
import by.epam.hospital.command.impl.util.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private static final Logger logger = Logger.getLogger(CommandHelper.class);

    private static volatile CommandHelper commandHelper;

    private final Map<String, Command> commands = new HashMap<>();

    private CommandHelper() {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("empty", new EmptyCommand());
        commands.put("redirect", new RedirectToPagesCommand());
        commands.put("registrationperson", new RegistrationPersonCommand());
        commands.put("removepersondiagnosis", new RemovePersonDiagnosisCommand());
        commands.put("registrationpatient", new RegistrationPatientCommand());
        commands.put("dischargepatient", new DischargePatientCommand());
        commands.put("setdiagnosis", new SetDiagnosisCommand());
        commands.put("makestaffaction", new MakeStaffAction());
        commands.put("changelanguage", new ChangeLanguageCommand());
        commands.put("changepassword", new ChangePasswordCommand());
        commands.put("changestaffdata", new ChangeStaffDataCommand());
        commands.put("updateprofile", new UpdateProfileCommand());
        commands.put("remove", new RemovePersonCommand());
        commands.put("removechamber", new RemoveChamberCommand());
        commands.put("addchamber", new AddChamberCommand());
    }

    public static CommandHelper getInstance() {
        CommandHelper localInstance = commandHelper;
        if (localInstance == null) {
            synchronized (CommandHelper.class) {
                localInstance = commandHelper;
                if (localInstance == null) {
                    commandHelper = localInstance = new CommandHelper();
                }
            }
        }
        return localInstance;
    }

    public Command defineCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            logger.info("Empty or invalid command " + request.getMethod() + " " + request.getRequestURI());
            action = "empty";
        } else {
            logger.info("Command: " + request.getMethod() + " " + action);
        }
        return defineCommand(action);
    }

    public Command defineCommand(String action) {
        Command current = commands.getOrDefault(action.toLowerCase(), new UnknownCommand());
        logger.debug(current);

        return current;
    }
}

package src.log;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import src.service.ComplexCalculatorService;

public class ComplexCalculatorLog {

    private static Logger LOGGER;

    static {
        try (FileInputStream stream = new FileInputStream("./src/log/log.config")) {
            LogManager.getLogManager().readConfiguration(stream);
            LOGGER = Logger.getLogger(ComplexCalculatorService.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(String msg) {
        LOGGER.info(msg);
    }
}

package utils;

import org.testng.Reporter;
import org.apache.log4j.Logger;


/**
 * Created by Lena on 09.11.2014.
 */

   public class Log4Test {
        private Log4Test() {}

        private static final Logger LOGGER =
                Logger.getLogger(Log4Test.class);

        // ****************** Default message content ********************
        private static final String INFO_LOG = "INFO: \"%s\"";
        private static final String ERROR_LOG = "ERROR: \"%s\" !";
        private static final String START_LOG = "START: \"%s\"";
        private static final String FINISH_LOG = "FINISH: \"%s\"";

    public static String start ()
    {

        String message = "****************************Start Test";
        LOGGER.info(String.format(START_LOG, message));
        Reporter.log(String.format(START_LOG, message));
        return String.format(START_LOG, message);
            }
    public static String finish ()
    {
        String message = "*****************************Finish Test";
        LOGGER.info(String.format(FINISH_LOG, message));
        Reporter.log(String.format(FINISH_LOG, message));
        return String.format(FINISH_LOG, message);
    }



        public static String error (String message)
        {

            LOGGER.error(String.format(ERROR_LOG, message));
            Reporter.log(String.format(ERROR_LOG, message));
            return String.format(ERROR_LOG, message);
        }

        public static String info(String message)
        {
            LOGGER.info(String.format(INFO_LOG, message));
            Reporter.log(String.format(INFO_LOG, message));
            return String.format(INFO_LOG, message);
        }
    }



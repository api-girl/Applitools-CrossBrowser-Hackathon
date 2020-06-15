package classUtils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerClass {

    Logger log = LoggerFactory.getLogger(Thread.currentThread().getName() + "." + getClass().getSimpleName());

    public void info(String text) {
        if (text.contains("\n")){
            log.info("-> INFO — " + text.replace("\n", " "));

        }else{
            log.info("-> INFO — " + text);
        }
    }

    public void error(String text) {
        log.error(" ! ERROR — " + text);
    }

}

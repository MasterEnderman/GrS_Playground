import com.cleanroommc.groovyscript.api.GroovyLog

public class Log {

    private static final LOGGER = GroovyLog.get()

    static void info(String msg, Object... args) {
        LOGGER.info(msg,args)
    }
    static void warn(String msg, Object... args) {
        LOGGER.warn(msg,args)
    }
    static void fatal(String msg, Object... args) {
        LOGGER.fatal(msg,args)
    }
    static void error(String msg, Object... args) {
        LOGGER.error(msg,args)
    }
}

import com.cleanroommc.groovyscript.network.NetworkUtils;
import io.sommers.packmode.PMConfig;
import net.minecraftforge.common.config.Configuration;

public class Packmode {
    protected enum Side {SERVER, CLIENT};
    protected static String[] whitelist = PMConfig.getAcceptedModes();

    public static Side side() {
        return NetworkUtils.isDedicatedClient() ? Side.CLIENT : Side.SERVER;
    }

    public static String[] getWhitelist() {
        return whitelist;
    }

    public static String get() {
        if (side() == Side.SERVER ) {
            return PMConfig.getPackMode();
        }
        // This is only here to allow reloading a different packmode
        // without having to restart the pack. As it only works on the CLIENT side.
        Configuration configuration = new Configuration(new File("config/packmode.cfg"));
        configuration.load();
        return configuration.get("general", "packMode", "normal").getString();
    }

    public static String getSide() {
        return side().name()
    }

    public static String getPackmode() {
        return get().toUpperCase()
    }

    public static boolean check(String packmode) {
        return ((packmode in getWhitelist()) && (packmode == get())) ? true : false;
    }

    public static boolean check(ArrayList<String> packmodes) {
        for (String packmode : packmodes) {
            if (check(packmode)) { return true; }
        }
        return false;
    }
}

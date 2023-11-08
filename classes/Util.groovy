import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.fml.common.FMLCommonHandler

public class Util {
    public static void command(EntityPlayerMP player, String command) {
        if (FMLCommonHandler.instance().getMinecraftServerInstance() == null) { return; }
        player.getServer().getCommandManager().executeCommand(
            FMLCommonHandler.instance().getMinecraftServerInstance(),
            command
        );
    }
}

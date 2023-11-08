import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.text.TextComponentString
import net.minecraftforge.fml.common.FMLCommonHandler

import com.cleanroommc.groovyscript.event.ScriptRunEvent
import net.minecraftforge.event.world.BlockEvent

import Packmode
import Util

// informs the player which packmode was loaded once the player reloads the registries
eventManager.listen({ ScriptRunEvent.Post event -> {
    if (FMLCommonHandler.instance().getMinecraftServerInstance() == null) { return; }
    for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
        player.sendMessage(new TextComponentString("Current Packmode: ${Packmode.getPackmode()}"));
        Util.command(player, String.format('/title @p title {"text":"Current Packmode: %s"}',Packmode.getPackmode()));
    }
}})

// the following event is only checked, when the selected packmode is "expert"
if (!Packmode.check(Global.EXPERT)) { return; }

blacklist = [
    block('minecraft:stone'),
    block('minecraft:planks'),
]
// cancels the block break event of the block listed in the blacklist above
eventManager.listen({ BlockEvent.BreakEvent event -> {
    if (event.getState().getBlock() in blacklist) {
        event.setCanceled(true)
        event.player.sendMessage(
            new TextComponentString("Breaking ${event.getState().getBlock().getLocalizedName()} is forbidden.")
        )
    }
}})

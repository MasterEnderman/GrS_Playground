import net.minecraftforge.event.world.BlockEvent
import net.minecraft.util.text.TextComponentString
import com.cleanroommc.groovyscript.network.NetworkUtils
import com.cleanroommc.groovyscript.event.ScriptRunEvent
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.FMLCommonHandler
import mod.seanld.rawinput.RawInputHandler
import Util
import Packmode
import Log
import Global

String msg = String.format('/title @p title {"text":"%s"}',Packmode.get());

eventManager.listen({ ScriptRunEvent.Post event -> {
    for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
        player.sendMessage(new TextComponentString("Current Packmode: ${Packmode.get()}"));
        // player.getServer().getCommandManager().executeCommand(FMLCommonHandler.instance().getMinecraftServerInstance(), "/title @p times 20 100 20");
        // player.getServer().getCommandManager().executeCommand(FMLCommonHandler.instance().getMinecraftServerInstance(), msg);
    }
}})

blacklist = [
    block('minecraft:stone'),
    block('minecraft:planks'),
]

crafting.addShaped(item('minecraft:dirt') * 3, [
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')],
    [null, ore('ingotIron'), null], 
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')]
])

crafting.removeByOutput(item('minecraft:diamond_pickaxe'))

crafting.shapedBuilder()                    // create a new shaped recipe
    // .name('balanced_clay')              // name the recipe 'balanced_clay'
    .output(item('minecraft:stone') * 32)      // output 32 clay
    .matrix('NIN',                      // create the layout for the recipe
            'DSD',                      // each character represents a slot
            'NIN')
    .key('N', item('minecraft:nether_star'))  // everywhere there is an 'N' in the layout, use a nether star
    .key('I', ore('ingotIron'))               // all 'I' characters are iron ingots
    .key('D', item('minecraft:diamond'))      // all 'D' characters are diamonds
    .key('S', ore('stone'))                   // all 'I' characters are stone
    .register()                         // register the recipe

if (Packmode.check(Global.EXPERT)) {
    crafting.shapedBuilder()                    // create a new shaped recipe
        // .name('balanced_clay')              // name the recipe 'balanced_clay'
        .output(item('minecraft:clay') * 32)      // output 32 clay
        .matrix('NIN',                      // create the layout for the recipe
                'DSD',                      // each character represents a slot
                'NIN')
        .key('N', item('minecraft:nether_star'))  // everywhere there is an 'N' in the layout, use a nether star
        .key('I', ore('ingotIron'))               // all 'I' characters are iron ingots
        .key('D', item('minecraft:diamond'))      // all 'D' characters are diamonds
        .key('S', ore('stone'))                   // all 'I' characters are stone
        .register()                         // register the recipe

    eventManager.listen({ BlockEvent.BreakEvent event -> {
        if (event.getState().getBlock() in blacklist) {
            event.setCanceled(true) // Many events can be canceled.
            event.player.sendMessage(new TextComponentString("Breaking ${event.getState().getBlock().getLocalizedName()} is forbidden."))
        }
    }})
}

if (!Packmode.check([Global.EXPERT, Global.SKYBLOCK])) return

crafting.addShaped(item('minecraft:clay_ball') * 3, [
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')],
    [null, ore('ingotIron'), null], 
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')]
])

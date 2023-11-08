import Packmode
import Global

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
    .key('N', Global.MC.piston)  // everywhere there is an 'N' in the layout, use a nether star
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

}

if (!Packmode.check([Global.EXPERT, Global.SKYBLOCK])) return

crafting.addShaped(item('minecraft:clay_ball') * 3, [
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')],
    [null, ore('ingotIron'), null], 
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')]
])

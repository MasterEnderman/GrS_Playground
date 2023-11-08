import Packmode
import Global

crafting.addShaped(item('minecraft:dirt') * 3, [
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')],
    [null, ore('ingotIron'), null], 
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')]
])

crafting.removeByOutput(item('minecraft:diamond_pickaxe'))

crafting.shapedBuilder()
    .name('balanced_clay')
    .output(item('minecraft:stone') * 32)
    .matrix('NIN',
            'DSD',
            'NIN')
    .key('N', Global.MC.piston
    .key('I', ore('ingotIron'))
    .key('D', item('minecraft:diamond'))
    .key('S', ore('stone'))
    .register()

// the following recipe only loads, when the selected Packmode is "expert"
if (Packmode.check(Global.EXPERT)) {
    crafting.shapedBuilder()
        .name('balanced_clay_expert')
        .output(item('minecraft:clay') * 32)
        .matrix('NIN',
                'DSD',
                'NIN')
        .key('N', item('minecraft:nether_star'))
        .key('I', ore('ingotIron'))
        .key('D', item('minecraft:diamond'))
        .key('S', ore('stone'))
        .register()
}

// the following recipe only loads, when the selected packmode is either "expert" or "skyblock"
if (!Packmode.check([Global.EXPERT, Global.SKYBLOCK])) return

crafting.addShaped(item('minecraft:clay_ball') * 3, [
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')],
    [null, ore('ingotIron'), null], 
    [item('minecraft:nether_star'), null, item('minecraft:nether_star')]
])

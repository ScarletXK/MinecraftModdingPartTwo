package net.shadow.zero.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.shadow.zero.ZeroMod;

@Mod.EventBusSubscriber(modid = ZeroMod.MOD_ID)
public class ModEvents {
    /*
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

     */

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getLevel().isClientSide()) {
            event.getPlayer().getPersistentData().putIntArray(ZeroMod.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(ZeroMod.MOD_ID + "homepos"));
        }
    }

    @SubscribeEvent
    public static void setEntityOnFireWhenHit(LivingDamageEvent event) {
        if(!event.getEntity().level.isClientSide()) {
            if(event.getSource().getDirectEntity() instanceof Player) {
                Player player = (Player)event.getSource().getDirectEntity();
                if(player.getMainHandItem().getItem() == Items.NETHER_BRICK) {
                    player.getMainHandItem().shrink(1);
                    event.getEntityLiving().setSecondsOnFire(2);
                }
            }
        }
    }

    /*
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void openGui(ScreenOpenEvent event) {
        if (MCCourseClientConfigs.CUSTOM_TITLE_SCREEN.get() &&
                event.getScreen() instanceof TitleScreen && !(event.getScreen() instanceof KaupenTitleScreen)) {
            event.setScreen(new KaupenTitleScreen());
        }
    }

     */
}
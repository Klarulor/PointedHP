package ru.lixty;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod("php")
public class PHPMain {
    public Minecraft mc = Minecraft.getInstance();

    public PHPMain() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        if (mc.player != null && mc.world != null) {
            if (mc.pointedEntity instanceof PlayerEntity) {
                String nickname = mc.pointedEntity.getScoreboardName();
                mc.fontRenderer.drawStringWithShadow("Nickname: " + nickname, 3F, 3F, new Color(Color.white.getRGB()).getRGB());
                double health_default = ((PlayerEntity) mc.pointedEntity).getHealth();
                mc.fontRenderer.drawStringWithShadow("Health Default: " + (int) health_default, 3F, 13F, new Color(Color.red.getRGB()).getRGB());
                double health_gold = ((PlayerEntity) mc.pointedEntity).getAbsorptionAmount();
                mc.fontRenderer.drawStringWithShadow("Health Gold: " + (int) health_gold, 3F, 23F, new Color(Color.orange.getRGB()).getRGB());
                String ping = mc.getConnection().getPlayerInfo(mc.pointedEntity.getUniqueID()).getResponseTime() + " ms";
                mc.fontRenderer.drawStringWithShadow("Ping: " + ping, 3F, 33F, new Color(Color.blue.getRGB()).getRGB());
            }
        }
    }
}
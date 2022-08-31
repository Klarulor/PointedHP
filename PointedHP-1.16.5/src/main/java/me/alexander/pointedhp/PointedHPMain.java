import *;

@Mod("pointedhp")
public class PointedHPMain {
    public Minecraft mc = Minecraft.getInstance();
    String nickname, ping;
    double health_default, health_golden;

    public PointedHPMain() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        if (mc.player != null && mc.level != null) {
            if (mc.crosshairPickEntity instanceof PlayerEntity) {
                nickname = mc.crosshairPickEntity.getScoreboardName();
                mc.font.drawShadow(event.getMatrixStack(), "Nickname: " + nickname, 3, 3, Color.magenta.getRGB());
                health_default = ((PlayerEntity) mc.crosshairPickEntity).getHealth();
                mc.font.drawShadow(event.getMatrixStack(), "Health Default: " + String.valueOf(health_default), 3, 13, Color.red.getRGB());
                health_golden = ((PlayerEntity) mc.crosshairPickEntity).getAbsorptionAmount();
                mc.font.drawShadow(event.getMatrixStack(), "Health Gold: " + String.valueOf(health_golden), 3, 23, Color.orange.getRGB());
                ping = String.valueOf(mc.getConnection().getPlayerInfo(mc.crosshairPickEntity.getUUID()).getLatency());
                mc.font.drawShadow(event.getMatrixStack(), "Ping: " + ping, 3, 33, Color.cyan.getRGB());
            }
        }
    }
}

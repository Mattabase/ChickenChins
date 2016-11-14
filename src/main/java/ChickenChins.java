import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by TheMattaBase on 11/14/2016.
 */
@Mod(modid = "chikenchins", name = "Chicken Chins", version = "0.1", acceptableRemoteVersions = "*")
public class ChickenChins {

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        if(event.getSide()== Side.CLIENT){
            RenderingRegistry.registerEntityRenderingHandler(EntityChicken.class, RenderChicken.factory);
        }
    }
}

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by Matt on 11/14/2016.
 */
public class RenderChicken extends RenderLiving<EntityChicken> {
    public ResourceLocation chicken = new ResourceLocation("chickenchins:textures/entity/chicken.png");

    public static Factory factory = new Factory();

    public RenderChicken(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelChicken(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChicken entity) {
        return chicken;
    }

    protected float handleRotationFloat(EntityChicken livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }

    public static class Factory implements IRenderFactory<EntityChicken>
    {
        @Override
        public Render<? super EntityChicken> createRenderFor(RenderManager manager)
        {
            return new RenderChicken(manager);
        }
    }
}

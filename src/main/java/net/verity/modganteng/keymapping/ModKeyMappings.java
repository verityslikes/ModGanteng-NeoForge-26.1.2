package net.verity.modganteng.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    private static final KeyMapping KEY_MAPPING_DASH = new KeyMapping("key.modganteng.dash",
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KeyMapping.Category.MISC);

    public static final Lazy<KeyMapping> PRESS_DASH = Lazy.of(() -> KEY_MAPPING_DASH);


    public static void register() {

    }
}

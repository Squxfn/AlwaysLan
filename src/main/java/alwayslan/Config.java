package alwayslan;

import net.minecraft.world.level.GameType;
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.EnumValue<GameType> MODE;
    public static final ForgeConfigSpec.BooleanValue CHEATS;
    public static final ForgeConfigSpec.IntValue PORT;

    static {
        var b = new ForgeConfigSpec.Builder();
        MODE = b.defineEnum("mode", GameType.SURVIVAL);
        CHEATS = b.define("cheats", false);
        PORT = b.defineInRange("port", 25565, 1024, 65535);
        SPEC = b.build();
    }
}
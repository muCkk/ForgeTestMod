package muCkk;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.player.BlockBreakEvent;
import net.minecraftforge.event.entity.player.PlayerShootBowEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "ForgeTestMod", name = "ForgeTestMod", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ForgeTestMod {

	@Init
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onBlockBreak(BlockBreakEvent event) {
		System.out.println("BlockBreakEvent - " + event.entityPlayer.username
							+ " (" + event.blockX + ", " 
							+ event.blockY + ", "
							+ event.blockZ);
	}

	@ForgeSubscribe
	public void onLivingShootBow(PlayerShootBowEvent event) {
		System.out.println("LivingShootBowEvent - "+event.entityPlayer.username);
	}

	@ForgeSubscribe
	public void onLivingHeal(LivingHealEvent event) {
		System.out.println("LivingHealEvent - "+ event.entityLiving +" - "+event.amount + " - "+event.reason);
	}
}

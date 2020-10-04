package npc;

import java.util.UUID;

import org.bukkit.craftbukkit.v1_16_R2.CraftServer;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.authlib.GameProfile;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.EntityPlayer;
import net.minecraft.server.v1_16_R2.MinecraftServer;
import net.minecraft.server.v1_16_R2.PlayerInteractManager;
import net.minecraft.server.v1_16_R2.WorldServer;

public class Launcher extends JavaPlugin {
	@Override
	public void onEnable() {
		EntityPlayer npc;
		MinecraftServer server = ((CraftServer)this.getServer()).getServer();
		WorldServer worldServer = ((CraftWorld)this.getServer().getWorlds().get(0)).getHandle();
		npc = new EntityPlayer(server,worldServer,new GameProfile(UUID.randomUUID(),ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Hello"), new PlayerInteractManager(worldServer));
		
		this.getServer().getPluginManager().registerEvents(new NPC(npc), this);
	}
}

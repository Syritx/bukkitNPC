package npc;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_16_R2.EntityPlayer;
import net.minecraft.server.v1_16_R2.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_16_R2.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_16_R2.PlayerConnection;
import net.minecraft.server.v1_16_R2.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

public class NPC implements Listener {
	
	EntityPlayer npc;
	public NPC(EntityPlayer npc) {
		this.npc = npc;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Location playerLocation = event.getPlayer().getLocation();
		npc.setLocation(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), playerLocation.getYaw(), playerLocation.getPitch());
		
		PlayerConnection playerConnection = ((CraftPlayer)event.getPlayer()).getHandle().playerConnection;
		playerConnection.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, npc));
		playerConnection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
	}
}

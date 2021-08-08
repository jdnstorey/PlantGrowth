package me.polo.plantgrowth;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.material.Crops;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    public void onDisable(){}

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();

        if(p.isSneaking()){
            Location loc = p.getLocation();
            World world = p.getWorld();
            int X = (int) loc.getBlockX();
            int Y = (int) loc.getBlockY();
            int Z = (int) loc.getBlockZ();
            Location loc2 = new Location(world, X, Y + 1, Z);

            //Block b = p.getLocation().getBlock().getRelative(X, Y + 1, Z);
            Block b = loc2.getBlock();
            BlockFace f = b.getFace(b);
            Material m = b.getType();

            if(m == Material.POTATOES || m == Material.CARROTS || m == Material.WHEAT || m == Material.SUGAR_CANE || m == Material.BEETROOTS) {
                b.applyBoneMeal(BlockFace.DOWN);
            }
        } else {}
    }

}

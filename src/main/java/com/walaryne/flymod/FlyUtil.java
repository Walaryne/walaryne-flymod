package com.walaryne.flymod;

import net.minecraft.entity.player.EntityPlayer;

public class FlyUtil {
	private static String toggleString;

	public static String toggleFlight(EntityPlayer player) {
		if (player.capabilities.allowFlying == false) {
			player.capabilities.allowFlying = true;
			toggleString = "commands.fly.successfulon";
		} else {
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			toggleString = "commands.fly.successfuloff";
		}
		player.sendPlayerAbilities();
		return toggleString;
	}
}

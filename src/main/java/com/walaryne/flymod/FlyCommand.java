package com.walaryne.flymod;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class FlyCommand extends CommandBase{
	
	@Override
	public String getName() {
		return "fly";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.fly.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) {
			EntityPlayer entityplayer = getCommandSenderAsPlayer(sender);
			String response = FlyUtil.toggleFlight(entityplayer);
			notifyCommandListener(sender, this, response, new Object[] {entityplayer.getDisplayName()});
		} else {
			Entity entity = getEntity(server, sender, args[0]);
			String response = FlyUtil.toggleFlight((EntityPlayer) entity);
			notifyCommandListener(sender, this, response, new Object[] {entity.getDisplayName()});
		}
	}
	
	@Override
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 0;
    }
	
	@Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
    }
}

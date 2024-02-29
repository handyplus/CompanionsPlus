package cn.handyplus.companions.command.player;

import cn.handyplus.companions.inventory.OpenGui;
import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.expand.adapter.HandySchedulerUtil;
import cn.handyplus.lib.util.AssertUtil;
import cn.handyplus.lib.util.BaseUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class OpenCommand implements IHandyCommandEvent {

    @Override
    public String command() {
        return "open";
    }

    @Override
    public String permission() {
        return "companionsPlus.open";
    }

    @Override
    public boolean isAsync() {
        return true;
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = AssertUtil.notPlayer(sender, BaseUtil.getMsgNotColor("noPlayerFailureMsg"));
        Inventory inventory = OpenGui.getInstance().createGui(player);
        HandySchedulerUtil.runTask(() -> player.openInventory(inventory));
    }

}
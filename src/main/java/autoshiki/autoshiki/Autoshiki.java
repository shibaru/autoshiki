package autoshiki.autoshiki;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public final class Autoshiki extends JavaPlugin {


    Random autoR;
    int number;
    boolean bosyu = false;
    List<Player> playerlist;


    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("自動式システム起動");
        autoR = new Random();
        number = 0;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("自動式システム終了");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getName().equals("shiki")) {
            if (args.length == 0) {
                sender.sendMessage("式を募集するには/shiki new と入力してください");
                sender.sendMessage("式に参加するには/shiki join と入力してください");
                return true;
            }
            if (args[0].equals("new")){
                if (args.length != 1) {
                    sender.sendMessage("式を募集するには/shiki new と入力してください");
                    return true;
                }
                if (bosyu){
                    sender.sendMessage("現在募集されています");
                    return true;
                }
                Bukkit.broadcastMessage(sender.getName() + "が" + args[1] + "円6式を募集しています。/shiki join で参加");
                playerlist.add(p.getName());
                bosyu = true;
            }
            Bukkit.broadcastMessage(sender.getName()+"は6面さいころを振って"+(autoR.nextInt(6)+1)+"を出した");
        }
        return true;

    }
}

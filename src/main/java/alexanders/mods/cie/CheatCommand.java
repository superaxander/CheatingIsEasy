package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.net.chat.Command;
import de.ellpeck.rockbottom.api.net.chat.IChatLog;

public class CheatCommand extends Command
{
    public CheatCommand(String name, String description, int level)
    {
        super(name, description, level);
    }

    @Override
    public String execute(String[] args, AbstractEntityPlayer player, String playerName, IGameInstance game, IAssetManager assetManager, IChatLog chatLog)
    {
        game.scheduleAction(() ->
                            {
                                if (game.getPlayer().getUniqueId() != player.getUniqueId())
                                    player.sendPacket(new GuiOpenPacket());
                                else
                                {
                                    new GuiOpenPacket().handle(game, null);
                                }
                                return true;
                            });
        return null;
    }
}

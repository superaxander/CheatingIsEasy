package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.net.packet.IPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

public class GuiOpenPacket implements IPacket
{

    @Override
    public void toBuffer(ByteBuf buffer) throws IOException
    {
    }

    @Override
    public void fromBuffer(ByteBuf buffer) throws IOException
    {
    }

    @Override
    public void handle(IGameInstance game, ChannelHandlerContext channelHandlerContext)
    {
        game.scheduleAction(() ->
                            {
                                game.getPlayer().openGuiContainer(new CheatGui(game.getPlayer()), new CheatContainer(game.getPlayer(), game.getPlayer().getInv(), new CheatInventory(), new TrashInventory()));
                                return true;
                            });
    }
}

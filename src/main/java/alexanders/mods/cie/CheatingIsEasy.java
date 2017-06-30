package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.IApiHandler;
import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.event.IEventHandler;
import de.ellpeck.rockbottom.api.mod.IMod;
import de.ellpeck.rockbottom.api.net.chat.IChatLog;

import static alexanders.mods.cie.Reference.*;

public class CheatingIsEasy implements IMod
{
    public static CheatingIsEasy instance;

    private CheatCommand cheatCommand;

    public CheatingIsEasy()
    {
        instance = this;
    }

    @Override
    public String getDisplayName()
    {
        return NAME;
    }

    @Override
    public String getId()
    {
        return ID;
    }

    @Override
    public String getVersion()
    {
        return VERSION;
    }

    @Override
    public String getResourceLocation()
    {
        return RESOURCE_LOCATION;
    }

    @Override
    public String getDescription()
    {
        return RockBottomAPI.getGame().getAssetManager().localize(RockBottomAPI.createRes(this, "desc.mod"));
    }

    @Override
    public void initAssets(IGameInstance game, IAssetManager assetManager, IApiHandler apiHandler)
    {
        cheatCommand = new CheatCommand("c", assetManager.localize(RockBottomAPI.createRes(this, "desc.command")), 10);
    }

    @Override
    public void init(IGameInstance game, IApiHandler apiHandler, IEventHandler eventHandler)
    {
        RockBottomAPI.PACKET_REGISTRY.register(RockBottomAPI.PACKET_REGISTRY.getNextFreeId(), GuiOpenPacket.class);
        IChatLog.registerCommand(cheatCommand);
    }
}

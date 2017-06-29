package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.gui.container.ItemContainer;
import de.ellpeck.rockbottom.api.inventory.IInventory;

public class CheatContainer extends ItemContainer
{
    public CheatContainer(AbstractEntityPlayer player, IInventory... containedInventories)
    {
        super(player, containedInventories);
        this.addPlayerInventory(player, (148) - ((8 * 20) / 2), 0);
        this.addSlotGrid(containedInventories[1], 0, containedInventories[1].getSlotAmount(), 0, 86, 14);
        this.addSlot(new TrashSlot(containedInventories[2],0, 0));
    }
    // %
}

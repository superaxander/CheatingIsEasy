package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.gui.container.ContainerSlot;
import de.ellpeck.rockbottom.api.inventory.IInventory;
import de.ellpeck.rockbottom.api.item.ItemInstance;

public class TrashSlot extends ContainerSlot
{
    public TrashSlot(IInventory inventory, int x, int y)
    {
        super(inventory, 0, x, y);
    }

    public boolean canPlace(ItemInstance instance)
    {
        return true;
    }

    public boolean canRemove()
    {
        return false;
    }

    public void set(ItemInstance instance)
    {
    }

    public ItemInstance get()
    {
        return null;
    }
}

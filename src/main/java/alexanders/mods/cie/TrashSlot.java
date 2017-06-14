package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.gui.container.ContainerSlot;
import de.ellpeck.rockbottom.api.item.ItemInstance;

public class TrashSlot extends ContainerSlot
{
    public TrashSlot(int x, int y)
    {
        super(null, 0, x, y);
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

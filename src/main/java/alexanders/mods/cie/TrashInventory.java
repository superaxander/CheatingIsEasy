package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.inventory.IInvChangeCallback;
import de.ellpeck.rockbottom.api.inventory.IInventory;
import de.ellpeck.rockbottom.api.item.ItemInstance;

public class TrashInventory implements IInventory
{

    @Override
    public void set(int i, ItemInstance itemInstance)
    {
    }

    @Override
    public ItemInstance add(int i, int i1)
    {
        return null;
    }

    @Override
    public ItemInstance remove(int i, int i1)
    {
        return null;
    }

    @Override
    public ItemInstance get(int i)
    {
        return null;
    }

    @Override
    public int getSlotAmount()
    {
        return 1;
    }

    @Override
    public void notifyChange(int i)
    {

    }

    @Override
    public void addChangeCallback(IInvChangeCallback iInvChangeCallback)
    {

    }

    @Override
    public void removeChangeCallback(IInvChangeCallback iInvChangeCallback)
    {

    }
}

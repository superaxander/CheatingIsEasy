package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.inventory.IInvChangeCallback;
import de.ellpeck.rockbottom.api.inventory.IInventory;
import de.ellpeck.rockbottom.api.item.Item;
import de.ellpeck.rockbottom.api.item.ItemInstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheatInventory implements IInventory
{
    private static List<Item> itemList = null;
    
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
    public ItemInstance remove(int i, int amount)
    {
        return get(i).setAmount(amount);
    }

    @Override
    public ItemInstance get(int i)
    {
        Item item = getById(i);
        return new ItemInstance(item, item.getMaxAmount());
    }

    @Override
    public int getSlotAmount()
    {
        return RockBottomAPI.ITEM_REGISTRY.getSize();
    }

    @Override
    public void notifyChange(int slot)
    {
        
    }

    @Override
    public void addChangeCallback(IInvChangeCallback callback)
    {

    }

    @Override
    public void removeChangeCallback(IInvChangeCallback callback)
    {

    }
    
    public static Item getById(int index) {
        if(itemList == null)
        {
            itemList = new ArrayList<>(RockBottomAPI.ITEM_REGISTRY.getUnmodifiable().values());
        }
        return itemList.get(index);
    }
}

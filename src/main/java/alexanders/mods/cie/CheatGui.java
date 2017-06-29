package alexanders.mods.cie;

import de.ellpeck.rockbottom.api.IGameInstance;
import de.ellpeck.rockbottom.api.RockBottomAPI;
import de.ellpeck.rockbottom.api.assets.IAssetManager;
import de.ellpeck.rockbottom.api.entity.player.AbstractEntityPlayer;
import de.ellpeck.rockbottom.api.gui.GuiContainer;
import de.ellpeck.rockbottom.api.gui.component.ComponentButton;
import de.ellpeck.rockbottom.api.gui.component.ComponentSlot;
import de.ellpeck.rockbottom.api.gui.component.GuiComponent;
import de.ellpeck.rockbottom.api.gui.container.ContainerSlot;
import de.ellpeck.rockbottom.api.gui.container.ItemContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class CheatGui extends GuiContainer
{
    private AbstractEntityPlayer player;
    private ArrayList<ComponentSlot[]> rows = new ArrayList<>();
    private ComponentButton upButton;
    private ComponentButton downButton;
    private ComponentSlot trashSlot;
    private int currentIndex = 0;

    public CheatGui(AbstractEntityPlayer player)
    {
        super(player, 296, 143);
        this.player = player;
    }

    @Override
    public void initGui(IGameInstance game)
    {
        super.initGui(game);
        
        rows.clear();

        ItemContainer container = this.player.getContainer();
        
        ArrayList<ComponentSlot> currentRow = new ArrayList<>(14);

        for (int i = 32; i < container.getSlotAmount() - 2; i++)
        {
            if (currentRow.size() >= 14)
            {
                rows.add(currentRow.toArray(new ComponentSlot[currentRow.size()]));
                currentRow = new ArrayList<>(14);
            }
            ContainerSlot slot = container.getSlot(i);
            currentRow.add(new ComponentSlot(this, slot, i, this.guiLeft + slot.x, this.guiTop + slot.y));
        }
        rows.add(currentRow.toArray(new ComponentSlot[currentRow.size()]));
        trashSlot = new ComponentSlot(this, new TrashSlot(container.containedInventories[2], 0, 0), container.getSlotAmount(), guiLeft, guiTop);
        upButton = new ComponentButton(this, 1, guiLeft + 286, guiTop + 83, 10, 10, "");
        downButton = new ComponentButton(this, 2, guiLeft + 286, guiTop + 133, 10, 10, "");
        updateComponents();
    }

    private void updateComponents()
    {
        ItemContainer container = this.player.getContainer();
        components.clear();
        for (int i = 0; i < 32; ++i)
        {
            ContainerSlot slot = container.getSlot(i);
            this.components.add(new ComponentSlot(this, slot, i, this.guiLeft + slot.x, this.guiTop + slot.y));
        }
        
        outer_loop:
        for (int i = currentIndex; i < currentIndex + 3; i++)
        {
            for (int j = 0; j < 14; j++)
            {
                try
                {
                    GuiComponent c = rows.get(i)[j];
                    c.y = guiTop + 86 + 20 * (i - currentIndex);
                    components.add(c);
                } catch (IndexOutOfBoundsException ignored)
                {
                    break outer_loop;
                }
            }
        }
        components.add(trashSlot);
        components.add(upButton);
        components.add(downButton);
    }

    @Override
    public void renderOverlay(IGameInstance game, IAssetManager manager, Graphics g)
    {
        super.renderOverlay(game, manager, g);
        manager.getTexture(RockBottomAPI.createRes(CheatingIsEasy.instance, "button.trash_can")).draw(trashSlot.x, trashSlot.y, trashSlot.sizeX, trashSlot.sizeY);
        manager.getTexture(RockBottomAPI.createRes(CheatingIsEasy.instance, "button.up")).draw(upButton.x, upButton.y, upButton.sizeX, upButton.sizeY);
        manager.getTexture(RockBottomAPI.createRes(CheatingIsEasy.instance, "button.down")).draw(downButton.x, downButton.y, downButton.sizeX, downButton.sizeY);
    }

    @Override
    public boolean onButtonActivated(IGameInstance game, int button)
    {
        if (button == 1)
            game.scheduleAction(() ->
                                {
                                    scrollUp();
                                    return true;
                                });
        else if (button == 2)
            game.scheduleAction(() ->
                                {
                                    scrollDown();
                                    return true;
                                });
        return super.onButtonActivated(game, button);
    }

    private void scrollDown()
    {
        if (currentIndex + 1 < rows.size() - 3)
        {
            currentIndex++;
            updateComponents();
        }
    }

    private void scrollUp()
    {
        if (currentIndex - 1 >= 0)
        {
            currentIndex--;
            updateComponents();
        }
    }
}

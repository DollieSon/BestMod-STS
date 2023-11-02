package BestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;

import java.util.Iterator;
import java.util.UUID;

public class ModifyMagicNumberAction extends AbstractGameAction {
    private final UUID uuid;

    public ModifyMagicNumberAction(UUID targetUUID, int amount){
        this.setValues(this.target,this.source,amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.uuid = targetUUID;
    }

    public void update() {
        Iterator<AbstractCard> var1 = GetAllInBattleInstances.get(this.uuid).iterator();

        while(var1.hasNext()) {
            AbstractCard c = var1.next();
            c.magicNumber += this.amount;
        }
        this.isDone = true;
    }
}

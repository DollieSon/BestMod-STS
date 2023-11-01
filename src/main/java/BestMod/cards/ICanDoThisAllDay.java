package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.Iterator;

public class ICanDoThisAllDay extends BaseCard{
    public static final String ID = makeID(ICanDoThisAllDay.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            1
    );

    public ICanDoThisAllDay(){
        super(ID,info);
        setCostUpgrade(0);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        int Amount = 0;
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()){
            var3.next();
            Amount++;
        }
        addToBot(new GainEnergyAction(Amount));
    }
}

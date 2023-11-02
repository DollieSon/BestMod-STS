package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import java.util.Iterator;

public class IEatFear extends BaseCard{
    public static final String ID = makeID(IEatFear.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            2
    );

    public static final int MAGIC_NUMBER = 5;
    public static final int UPG_MAGIC_NUMBER = -2;

    public IEatFear(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int Total =0;
        int Indiv =0;
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()){
            AbstractMonster mo = (AbstractMonster) var3.next();
            Indiv = mo.getPower(VulnerablePower.NAME).amount;
            addToBot(new ReducePowerAction(mo,p, VulnerablePower.NAME,Indiv));
            Total+=Indiv;
        }
        addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,Total/magicNumber),Total/magicNumber));
    }

}

package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.Iterator;

public class Slip extends BaseCard{
    public static final String ID = makeID(Slip.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            1
    );

    public static final int MAGIC_NUMBER = 1;
    public static final int UPG_MAGIC_NUMBER = 1;
    public static final int DRAW = 1;
    public static final int UPG_DRAW = 1;

    public Slip(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
        setCustomVar("Draw",DRAW,UPG_DRAW);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();
        while(var3.hasNext()){
            AbstractMonster mo = (AbstractMonster) var3;
            addToBot(new ApplyPowerAction(mo,p,new VulnerablePower(m,this.magicNumber,false),this.magicNumber));
        }
        addToBot(new DrawCardAction(p,this.customVar("Draw")));
    }
}

package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class PowerIsDefense extends BaseCard{
    public static final String ID = makeID(PowerIsDefense.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.SKILL,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.NONE,
            2
    );
    public static final int MAGIC_NUMBER = 20;
    public static final int UPG_MAGIC_NUMBER = 20;
    public PowerIsDefense(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int amt = p.getPower(StrengthPower.POWER_ID).amount;
        if(amt > this.magicNumber){
            amt = this.magicNumber;
        }
        addToBot(new ReducePowerAction(p,p,StrengthPower.NAME,amt));
        addToBot(new GainBlockAction(p,p,amt*5));
    }
}

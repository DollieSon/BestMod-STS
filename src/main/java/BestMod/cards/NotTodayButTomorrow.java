package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class NotTodayButTomorrow extends BaseCard{
    public static final String ID = makeID(NotTodayButTomorrow.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.POWER,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.NONE,
            2
    );
    public static final int MAGIC_NUMBER = 10;
    public static final int UPG_MAGIC_NUMBER = 5;
    public NotTodayButTomorrow(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower(StrengthPower.POWER_ID)){
            int amt = p.getPower(StrengthPower.POWER_ID).amount;
            int var1 = amt/5;
            if(var1 > this.magicNumber){
                var1 = this.magicNumber;
            }
            addToBot(new ReducePowerAction(p,p,StrengthPower.NAME,var1 * 5));
            addToBot(new ApplyPowerAction(p, p, new DemonFormPower(p, var1), var1));
        }
    }


}

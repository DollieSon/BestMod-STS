package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import java.util.Iterator;

public class PowerNow extends BaseCard{
    public static final String ID = makeID(PowerNow.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.POWER,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            2
    );

    public static final int MAGIC_NUMBER = 3;
    public static final int UPG_MAGIC_NUMBER = 3;

    public PowerNow(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int amt = p.getPower(DemonFormPower.POWER_ID).amount;
        addToBot( new ReducePowerAction(p,p,DemonFormPower.POWER_ID,amt));
        addToBot( new ApplyPowerAction(p,p,new StrengthPower(p,amt * magicNumber),amt * magicNumber));
    }

}

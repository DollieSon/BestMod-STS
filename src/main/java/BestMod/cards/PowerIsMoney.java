package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class PowerIsMoney extends BaseCard{
    public static final String ID = makeID(PowerIsMoney.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            2
    );

    public static final int MAGIC_NUMBER = 10;
    public static final int UPG_MAGIC_NUMBER = 10;
    public static final int MONEY = 30;
    public static final int UPG_MONEY = 30;


    public PowerIsMoney(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
        setCustomVar("Money",MONEY,UPG_MONEY);
        setExhaust(true);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int amt = p.getPower(StrengthPower.NAME).amount;
        if( amt > magicNumber){
            amt = magicNumber;
        }
        addToBot( new ReducePowerAction(p,p,StrengthPower.NAME,amt));
        addToBot( new GainGoldAction(amt * customVar("Money")));
    }
}

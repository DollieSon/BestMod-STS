package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import java.util.Iterator;

public class HealthOverPower extends BaseCard{
    public static final String ID = makeID(HealthOverPower.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            2
    );

    public static final int MAGIC_NUMBER = 10;
    public static final int UPG_MAGIC_NUMBER = -5;


    public HealthOverPower(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot( new ReducePowerAction(p,p, StrengthPower.NAME,magicNumber));
        p.powers.stream().filter((pow)-> {
            return pow.type == AbstractPower.PowerType.DEBUFF;
        }).forEach((pow) -> {
            pow.amount = 0;
        });
    }
}

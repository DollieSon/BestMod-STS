package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DemonFormPower;

public class EnoughWeakness extends BaseCard{
    public static final String ID = makeID(EnoughWeakness.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.POWER,
            CardRarity.COMMON,
            CardTarget.NONE,
            3
    );

    public static final int MAGIC_NUMBER = 1;
    public static final int UPG_MAGIC_NUMBER = 2;

    public EnoughWeakness(){
        super(ID,info);
        this.baseMagicNumber = MAGIC_NUMBER;
        this.magicNumber = this.baseMagicNumber;
    }


    public void use(AbstractPlayer p, AbstractMonster m) {
        p.powers.stream().filter((pow)-> {
            return pow.type == AbstractPower.PowerType.DEBUFF;
        }).forEach((pow) -> {
            this.addToBot(new ApplyPowerAction(p, p, new DemonFormPower(p, this.magicNumber), this.magicNumber));
        });
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPG_MAGIC_NUMBER);
            this.initializeDescription();
        }
    }
}

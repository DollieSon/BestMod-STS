package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Stroid extends BaseCard{
    public static final String ID = makeID(Stroid.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            0
    );
    public static final int MAGIC_NUMBER = 6;
    public static final int UPG_MAGIC_NUMBER = 2;

    public Stroid(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,this.magicNumber),this.magicNumber));
        addToBot(new ApplyPowerAction(p,p,new LoseStrengthPower(p,10),10));

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPG_MAGIC_NUMBER);
            this.initializeDescription();
        }
    }
}

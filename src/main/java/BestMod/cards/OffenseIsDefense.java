package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MetallicizePower;

public class OffenseIsDefense extends BaseCard{
    public static final String ID = makeID(OffenseIsDefense.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.POWER,
            CardRarity.COMMON,
            CardTarget.NONE,
            3
    );
    public static final int MAGIC_NUMBER = 20;

    public static final int UPG_MAGIC_NUMBER = 20;

    public OffenseIsDefense(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int MetalAmt = (int) (p.getPower("Strength").amount * (this.magicNumber/100.0));
        addToBot(new ApplyPowerAction(p,p,new MetallicizePower(p,MetalAmt),MetalAmt));
    }
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPG_MAGIC_NUMBER);
            this.initializeDescription();
        }
    }
}

package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DemonFormPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class DevilsDance extends BaseCard{
    public static final String ID = makeID(DevilsDance.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.POWER,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.NONE,
            1
    );
    public static final int MAGIC_NUMBER = 3;
    public static final int UPG_MAGIC_NUMBER = -2;
    public DevilsDance(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new DemonFormPower(p, 1), 1));
        this.addToBot(new ApplyPowerAction(p,p, new WeakPower(p,this.magicNumber,false),this.magicNumber));
        this.addToBot(new ApplyPowerAction(p,p, new VulnerablePower(p,this.magicNumber,false),this.magicNumber));
    }


}

package BestMod.cards;

import BestMod.actions.ModifyMagicNumberAction;
import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class BulkTrain extends BaseCard{
    public static final String ID = makeID(BulkTrain.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            2
    );
    public static final int MAGIC_NUMBER = 1;
    public static final int UPG_MAGIC_NUMBER = 1;

    public BulkTrain(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
        setCustomVar("Increase",1,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new StrengthPower(p,this.magicNumber),this.magicNumber));
        addToBot(new ModifyMagicNumberAction(this.uuid,customVar("Increase")));
    }

}

package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class CoverFace extends BaseCard{
    public static final String ID = makeID(CoverFace.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            1
    );

    public static final int MAGIC_NUMBER = 15;
    public static final int UPG_MAGIC_NUMBER = 15;


    public CoverFace(){
        super(ID,info);
        setBlock(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot( new ReducePowerAction(p,p,StrengthPower.NAME,3));
        addToBot( new GainBlockAction(p,block));
    }
}

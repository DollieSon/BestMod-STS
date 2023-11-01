package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import java.util.Iterator;
public class LowerYourselves extends BaseCard  {
    public static final String ID = makeID(LowerYourselves.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            2
    );
    public static final int MAGIC_NUMBER = 1;
    public static final int UPG_MAGIC_NUMBER = 3;

    public LowerYourselves(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ReducePowerAction(m, p, StrengthPower.NAME, magicNumber));
        addToBot(new ReducePowerAction(m, p, DexterityPower.NAME, magicNumber));

        for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            addToBot(new ReducePowerAction(mo, p, StrengthPower.NAME, magicNumber));
            addToBot(new ReducePowerAction(mo, p, DexterityPower.NAME, magicNumber));
        }
    }
}

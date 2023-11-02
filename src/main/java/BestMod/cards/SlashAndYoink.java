package BestMod.cards;

import BestMod.actions.FinalStrikeAction;
import BestMod.actions.SlashAndYoinkAction;
import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class SlashAndYoink extends BaseCard{
    public static final String ID = makeID(SlashAndYoink.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    public static final int MAGIC_NUMBER = 2;
    public static final int UPG_MAGIC_NUMBER = 2;
    public static final int DAMAGE =10;
    public static final int UPG_DAMAGE =10;

    public SlashAndYoink(){
        super(ID,info);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
        setDamage(DAMAGE,UPG_DAMAGE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SlashAndYoinkAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn),magicNumber));
    }
}

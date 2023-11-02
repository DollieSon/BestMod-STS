package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class PoisonStrike extends BaseCard{
    public static final String ID = makeID(TestCard.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 5;

    public PoisonStrike(){
        super(ID,info);
        setDamage(DAMAGE);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m,p,new PoisonPower(m,p,damage),damage));
    }
}

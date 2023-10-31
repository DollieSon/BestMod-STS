package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class TestCard extends BaseCard{

    public static final String ID = makeID(TestCard.class.getSimpleName());
    public static final CardStats info = new CardStats(
        CardColor.RED,
        CardType.ATTACK,
        CardRarity.COMMON,
        CardTarget.ENEMY,
            1
    );
    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 2;

    public TestCard(){
        super(ID,info);

        setDamage(DAMAGE,UPG_DAMAGE);
        setBlock(BLOCK,UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p,p,block));
        addToBot(new DamageAction(m, new DamageInfo(p,damage,DamageInfo.DamageType.NORMAL)));
    }
}

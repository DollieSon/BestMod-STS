package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class MyTurn extends BaseCard{
    public static final String ID = makeID(MyTurn.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            0
    );
    public static final int BLOCK = 14;

    public MyTurn(){
        super(ID,info);
        setBlock(BLOCK);
        this.exhaust = true;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p,this.block,true));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.setInnate(true);
            this.initializeDescription();
        }
    }
}

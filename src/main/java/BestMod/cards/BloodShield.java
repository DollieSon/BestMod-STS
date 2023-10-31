package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BloodShield extends BaseCard {
    public static final String ID = makeID(BloodShield.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            AbstractCard.CardType.SKILL,
            AbstractCard.CardRarity.COMMON,
            AbstractCard.CardTarget.ENEMY,
            1
    );
    public static final int BLOCK = 9;
    public static final int UPG_BLOCK = 9;
    public BloodShield(){
        super(ID,info);
        setBlock(BLOCK,UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new LoseHPAction(p,p,3));
        addToBot(new GainBlockAction(p,this.block));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(UPG_BLOCK);
            this.initializeDescription();
        }
    }
}

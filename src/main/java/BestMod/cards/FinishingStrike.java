package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.red.PerfectedStrike;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class FinishingStrike extends BaseCard{
    public static final String ID = makeID(FinishingStrike.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ENEMY,
            3
    );
    public static final int DAMAGE = 5;
    public static final int UPG_DAMAGE = 8;
    public FinishingStrike(){
        super(ID,info);
        setDamage(DAMAGE,UPG_DAMAGE);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int repeats = PerfectedStrike.countCards();
        for(int x=0;x<repeats;x++){
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }
}

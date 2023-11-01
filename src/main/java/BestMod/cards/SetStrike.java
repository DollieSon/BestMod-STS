package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SetStrike extends BaseCard{
    public static final String ID = makeID(SetStrike.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 20;
    public static final int UPG_DAMAGE = 20;
    public SetStrike(){
        super(ID,info);
        setDamage(DAMAGE,UPG_DAMAGE);
        tags.add(CardTags.STRIKE);
        setMagic(1,1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new MakeTempCardInDrawPileAction(new SetStrike(),magicNumber,true,false));
    }
}

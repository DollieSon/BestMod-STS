package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FrailPower;

public class AllStrikeNoDefense extends BaseCard{
    public static final String ID = makeID(AllStrikeNoDefense.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public AllStrikeNoDefense(){
        super(ID,info);
        setDamage(10,5);
        setCostUpgrade(1);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p,p,new FrailPower(p,3,false)));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}

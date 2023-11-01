package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class CleansingStrike extends BaseCard{
    public static final String ID = makeID(CleansingStrike.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );
    public static final int DAMAGE = 15;
    public static final int MAGIC = 2;
    public static final int UPG_MAGIC = 2;
    public CleansingStrike(){
        super(ID,info);
        setDamage(DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ReducePowerAction(p,p, WeakPower.NAME,magicNumber));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
}

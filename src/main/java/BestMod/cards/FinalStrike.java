package BestMod.cards;

import BestMod.actions.FinalStrikeAction;
import BestMod.util.CardStats;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class FinalStrike extends BaseCard{
    public static final String ID = makeID(FinalStrike.class.getSimpleName());
    public static final CardStats info = new CardStats(
            AbstractCard.CardColor.RED,
            CardType.ATTACK,
            AbstractCard.CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 5;
    public static final int MAGIC = 1;
    public static final int UPG_MAGIC = 2;
    public FinalStrike(){
        super(ID,info);
        setDamage(DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        setExhaust(true,false);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new FinalStrikeAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn),magicNumber));
    }
}

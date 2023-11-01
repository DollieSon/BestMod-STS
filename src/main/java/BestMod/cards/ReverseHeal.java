package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ReverseHeal extends BaseCard{
    public static final String ID = makeID(ReverseHeal.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );
    public static final int DAMAGE = 3;
    public static final int UPG_DAMAGE = 2;
    public static final int MULT_ATTACK = 3;
    public static final int UPG_MULT_ATTACK = 3;
    public ReverseHeal(){
        super(ID,info);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(MULT_ATTACK,UPG_MULT_ATTACK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new LoseHPAction(p,p,4));
        for(int x =0; x<this.magicNumber;x++){
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPG_DAMAGE);
            this.upgradeMagicNumber(UPG_MULT_ATTACK);
            this.initializeDescription();
        }
    }

}

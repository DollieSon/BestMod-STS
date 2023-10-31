package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class Retaliate extends BaseCard{
    public static final String ID = makeID(Retaliate.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 6;
    public static final int MAGIC_NUMBER = 1;

    public static final int UPG_MAGIC_NUMBER = 1;

    public Retaliate(){
        super(ID,info);
        setDamage(DAMAGE);
        setMagic(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        if (p.powers.stream().anyMatch((pow)->{
            return pow.type == AbstractPower.PowerType.DEBUFF;
        })){
           addToBot(new GainEnergyAction(this.magicNumber));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPG_MAGIC_NUMBER);
            this.initializeDescription();
        }
    }

}

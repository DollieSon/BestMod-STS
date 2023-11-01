package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class Spit extends BaseCard{
    public static final String ID = makeID(Spit.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 15;
    public static final int UPG_DAMAGE = 10;

    public Spit(){
        super(ID,info);
        setDamage(DAMAGE,UPG_DAMAGE);
        this.magicNumber = this.baseMagicNumber = 4;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p,damage,DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(p, p, new WeakPower(p,this.magicNumber,false),this.magicNumber));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(UPG_DAMAGE);
            this.initializeDescription();
        }
    }
}

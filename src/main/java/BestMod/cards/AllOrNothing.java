package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class AllOrNothing extends BaseCard{
    public static final String ID = makeID(AllOrNothing.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    public static final int MAGIC_NUMBER = 15;
    public static final int UPG_MAGIC_NUMBER = 15;
    public static final int DAMAGE = 70;
    public static final int REBUTAL = 40;
    public static final int UPG_REBUTAL = 80;
    public AllOrNothing(){
        super(ID,info);
        setBlock(MAGIC_NUMBER,UPG_MAGIC_NUMBER);
        setDamage(DAMAGE);
        setCustomVar("Rebutal",REBUTAL,UPG_REBUTAL);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot( new ApplyPowerAction(p,p, new StrengthPower(p,magicNumber),magicNumber));
        addToBot( new DamageAction(m,new DamageInfo(p,damage,DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot( new ReducePowerAction(p,p,StrengthPower.NAME,customVar("Rebutal")));
    }

}

package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

public class UnrelentingAttack extends BaseCard{
    public static final String ID = makeID(UnrelentingAttack.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 3;
    public static final int UPG_DAMAGE = 2;

    public UnrelentingAttack(){
        super(ID,info);
        setDamage(DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        int repeats = 0;
        AbstractCard c;

        Iterator var1 = AbstractDungeon.player.hand.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof UnrelentingAttack){
                repeats ++;
            }
        }

        var1 = AbstractDungeon.player.drawPile.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof UnrelentingAttack){
                repeats ++;
            }
        }

        var1 = AbstractDungeon.player.discardPile.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof UnrelentingAttack){
                repeats ++;
            }
        }

        for(int x=0;x<repeats;x++){
            addToBot(new DamageRandomEnemyAction(new DamageInfo(p,this.damage,this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(UPG_DAMAGE);
            this.initializeDescription();
        }
    }
}

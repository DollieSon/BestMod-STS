package BestMod.cards;

import BestMod.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.red.SearingBlow;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import java.util.Iterator;
public class OilSplash extends BaseCard{
    public static final String ID = makeID(OilSplash.class.getSimpleName());
    public static final CardStats info = new CardStats(
            CardColor.RED,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );
    public static final int DAMAGE = 5;

    public OilSplash(){
        super(ID,info);
        setDamage(DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m,new DamageInfo(p,damage,DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        AbstractCard c;
        Iterator var1 = AbstractDungeon.player.hand.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof SearingBlow){
                specialUpgrade(c);
                return;
            }
        }var1 = AbstractDungeon.player.drawPile.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof SearingBlow){
                specialUpgrade(c);
                return;
            }
        }var1 = AbstractDungeon.player.discardPile.group.iterator();
        while(var1.hasNext()){
            c = (AbstractCard) var1.next();
            if(c instanceof SearingBlow){
                specialUpgrade(c);
                return;
            }
        }
    }
    public void specialUpgrade(AbstractCard c){
        if(this.upgraded){
            c.upgrade();
        }
        c.upgrade();
    }
}

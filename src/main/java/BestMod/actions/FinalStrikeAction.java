package BestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.beyond.Donu;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class FinalStrikeAction extends AbstractGameAction {
    private final int regainAmount;
    private final DamageInfo info;
    private static final float DURATION = 0.1F;

    public FinalStrikeAction(AbstractCreature target, DamageInfo info, int regainAmount) {
        this.info = info;
        this.setValues(target, info);
        this.regainAmount = regainAmount;
        this.actionType = ActionType.DAMAGE;
        this.duration = 0.1F;
    }
    public void update() {
        if (this.duration == 0.1F && this.target != null) {
            this.target.damage(this.info);
            if ((((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) && !this.target.halfDead) {
                AbstractDungeon.player.gainEnergy(regainAmount);
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
        }

        this.tickDuration();
    }
}

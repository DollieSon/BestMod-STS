package BestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SlashAndYoinkAction extends AbstractGameAction {
    private final int DrawAmt;
    private final DamageInfo info;
    private static final float DURATION = 0.1F;

    public SlashAndYoinkAction(AbstractCreature target, DamageInfo info, int DrawAmt) {
        this.info = info;
        this.setValues(target, info);
        this.DrawAmt = DrawAmt;
        this.actionType = ActionType.DAMAGE;
        this.duration = 0.1F;
    }
    public void update() {
        if (this.duration == 0.1F && this.target != null) {
            this.target.damage(this.info);
            if ((((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) && !this.target.halfDead) {
                AbstractDungeon.player.draw(DrawAmt);
            }
            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
        }
        this.tickDuration();
    }
}

package BestMod.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static BestMod.BasicMod.makeID;

public class Scarred extends BasePower implements CloneablePowerInterface {
    private static final String PowerID = makeID("Scarred");
    public static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    public static final boolean TURN_BASED = false;

    public Scarred(AbstractCreature own, int amt){
        super(PowerID,TYPE,TURN_BASED,own,amt);
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type){
        return damage + this.amount;
    }

    public AbstractPower makeCopy(){
        return  new Scarred(owner, amount);
    }
}

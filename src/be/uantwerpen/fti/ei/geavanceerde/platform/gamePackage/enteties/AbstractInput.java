package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

public abstract class AbstractInput {

    public enum Inputs {LEFT, RIGHT, JUMPING, ATTACKING, IDLE};
    public abstract Inputs getInputs();
}

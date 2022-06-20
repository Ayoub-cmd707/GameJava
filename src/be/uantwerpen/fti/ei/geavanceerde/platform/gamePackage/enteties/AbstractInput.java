package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

public abstract class AbstractInput {

    public enum Inputs {LEFT, RIGHT,JUMP, IDLE};
    public abstract Inputs getInputs();
}

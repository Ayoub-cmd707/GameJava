package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;
/**
 * AbstractInput
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractInput {
    /**
     * Clas for controlling the inputs
     */
    public enum Inputs {LEFT, RIGHT, JUMP, SHOOT, IDLE};
    public abstract Inputs getInputs();
}

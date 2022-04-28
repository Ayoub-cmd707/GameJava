package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

public abstract class AbstractInput {
    public enum Inputs { LEFT, RIGHT, DOWN, UP};
    public abstract boolean inputAvailable();
    public abstract AbstractInput.Inputs getInputs();
}

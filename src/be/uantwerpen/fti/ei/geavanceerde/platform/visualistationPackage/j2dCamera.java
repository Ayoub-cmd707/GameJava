package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMovingCamera;

public class j2dCamera extends AbstractMovingCamera {
    private final GraphicsContext graphicsContext;
    @Override
    public void visualize() {

    }

    public j2dCamera(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}

package JualanYuk.ui.component;

import net.rim.device.api.ui.container.VerticalFieldManager;

public class FixedHeightVerticalFieldManager extends VerticalFieldManager {

    private int height;

    public FixedHeightVerticalFieldManager(int height) {
         super(VERTICAL_SCROLL | VERTICAL_SCROLLBAR);
         this.height = height;
    }

    protected void sublayout(int maxWidth, int maxHeight) {
        super.sublayout(maxWidth, height);
        setExtent(maxWidth, height);
    }
}
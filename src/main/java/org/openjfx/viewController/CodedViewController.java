package org.openjfx.viewController;

import java.io.IOException;

public class CodedViewController extends MyViewController {

    public void moveBack() {
        try {
            this.mainApp.showPrimaryScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

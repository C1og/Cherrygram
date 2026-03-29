package uz.unnarsx.cherrygram.camera;

import android.graphics.SurfaceTexture;
import android.util.Range;

import org.telegram.ui.Components.InstantCameraView;

public class VideoMessagesHelper {

    public CameraXController cameraXController = new CameraXController(null, null, null);

    public int getSliderW() {
        return 180;
    }

    public int getSliderH() {
        return 24;
    }

    public int getSliderBM() {
        return 110;
    }

    public void setZoom(float zoom) {
        cameraXController.setZoom(zoom);
    }

    public void showExposureControls(InstantCameraView view, boolean show) {
    }

    public void switchCameraX(InstantCameraView view) {
        cameraXController.switchCamera();
    }

    public void checkFlash(InstantCameraView view) {
    }

    public boolean createFlashConfigurator(InstantCameraView view) {
        return true;
    }

    public void destroyCameraX(InstantCameraView view) {
    }

    public void updateCameraXFlash(InstantCameraView view) {
    }

    public void createCameraX(InstantCameraView view, SurfaceTexture[] cameraSurface) {
    }

    public static Range<Integer> getCameraXFpsRange() {
        return new Range<>(30, 30);
    }
}

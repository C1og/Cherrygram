package uz.unnarsx.cherrygram.camera;

import android.content.Context;

import androidx.annotation.IntDef;
import androidx.camera.core.ImageCapture;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import org.telegram.messenger.camera.Size;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CameraXController {

    public static final int CAMERA_NONE = 0;
    public static final int CAMERA_HDR = 1;
    public static final int CAMERA_NIGHT = 2;
    public static final int CAMERA_AUTO = 3;
    public static final int CAMERA_WIDE = 4;
    public static final int CAMERA_ASPECT_RATIO_SELECTOR = 5;

    @IntDef({
            CAMERA_NONE,
            CAMERA_HDR,
            CAMERA_NIGHT,
            CAMERA_AUTO,
            CAMERA_WIDE,
            CAMERA_ASPECT_RATIO_SELECTOR
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface EffectFacing {
    }

    public static class CameraLifecycle implements LifecycleOwner {
        private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

        public CameraLifecycle() {
            lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
        }

        @Override
        public Lifecycle getLifecycle() {
            return lifecycleRegistry;
        }

        public void stop() {
            lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        }
    }

    private boolean frontFace;
    private boolean initiated = true;
    private int cameraEffect = CAMERA_NONE;
    private int flashMode = ImageCapture.FLASH_MODE_AUTO;
    private float zoom;

    public CameraXController(Object lifecycle, Object meteringPointFactory, Object surfaceProvider) {
    }

    public void setTargetOrientation(int rotation) {
    }

    public void setWorldCaptureOrientation(int rotation) {
    }

    public boolean isFrontface() {
        return frontFace;
    }

    public void bindUseCases() {
    }

    public void closeCamera() {
    }

    public void switchCamera() {
        frontFace = !frontFace;
    }

    public void setCameraEffect(@EffectFacing int effect) {
        cameraEffect = effect;
    }

    public int getCameraEffect() {
        return cameraEffect;
    }

    public void setFrontFace(boolean frontface) {
        frontFace = frontface;
    }

    public void initCamera(Context context, boolean frontface, Runnable onReady) {
        frontFace = frontface;
        initiated = true;
        if (onReady != null) {
            onReady.run();
        }
    }

    public boolean hasFrontFaceCamera() {
        return true;
    }

    public static boolean hasGoodCamera(Context context) {
        return true;
    }

    public int setNextFlashMode() {
        if (flashMode == ImageCapture.FLASH_MODE_AUTO) {
            flashMode = ImageCapture.FLASH_MODE_ON;
        } else if (flashMode == ImageCapture.FLASH_MODE_ON) {
            flashMode = ImageCapture.FLASH_MODE_OFF;
        } else {
            flashMode = ImageCapture.FLASH_MODE_AUTO;
        }
        return flashMode;
    }

    public int getCurrentFlashMode() {
        return flashMode;
    }

    public static boolean isFlashAvailable() {
        return true;
    }

    public void setZoom(float value) {
        zoom = value;
    }

    public float resetZoom() {
        zoom = 0f;
        return zoom;
    }

    public boolean isAvailableHdrMode() {
        return false;
    }

    public boolean isAvailableWideMode() {
        return false;
    }

    public boolean isAvailableNightMode() {
        return false;
    }

    public boolean isAvailableAutoMode() {
        return false;
    }

    public boolean isExposureCompensationSupported() {
        return false;
    }

    public void setExposureCompensation(float value) {
    }

    public void focusToPoint(int x, int y) {
    }

    public Size getPreviewSize() {
        return new Size(1, 1);
    }

    public void recordVideo(File path, boolean mirrorThumb, CameraXView.VideoSavedCallback onStop) {
    }

    public void stopVideoRecording(boolean abandon) {
    }

    public void takePicture(File file, Runnable onTake) {
        if (onTake != null) {
            onTake.run();
        }
    }

    public boolean isInitiated() {
        return initiated;
    }

    public int getDisplayOrientation() {
        return 0;
    }
}

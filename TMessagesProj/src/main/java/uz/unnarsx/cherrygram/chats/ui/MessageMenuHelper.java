package uz.unnarsx.cherrygram.chats.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

import org.telegram.messenger.MessageObject;
import org.telegram.messenger.UserConfig;

public class MessageMenuHelper {

    private static final MessageMenuHelper[] INSTANCES = new MessageMenuHelper[UserConfig.MAX_ACCOUNT_COUNT];

    public static MessageMenuHelper getInstance(int account) {
        MessageMenuHelper instance = INSTANCES[account];
        if (instance == null) {
            instance = new MessageMenuHelper();
            INSTANCES[account] = instance;
        }
        return instance;
    }

    public boolean allowNewMessageMenu() {
        return false;
    }

    public boolean allowNewMessageMenu(boolean fromBackground) {
        return false;
    }

    public boolean allowNewMessageMenu(MessageObject messageObject) {
        return false;
    }

    public boolean showDivider() {
        return false;
    }

    public boolean showCustomDivider(boolean thick) {
        return false;
    }

    public int getMessageMenuAlpha(boolean thick) {
        return 255;
    }

    public boolean allowUnifiedScroll(boolean fromLayout) {
        return false;
    }

    public void checkBlur(Activity activity, boolean enable, boolean animated, float amount) {
    }

    public void createMenu(Object chatActivity, View anchor, View contentView, Object popupContainer, Object reactionsLayout, MessageObject messageObject, Object popupLayout) {
    }

    public void hideMessageView(View anchor, Object chatActivity, Object adapter, MessageObject messageObject, Activity activity, boolean immediate) {
    }

    public static class MaxHeightLinearLayout extends LinearLayout {
        private int maxWidth = Integer.MAX_VALUE;
        private int maxHeight = Integer.MAX_VALUE;

        public MaxHeightLinearLayout(Context context) {
            super(context);
        }

        public void setMaxWidth(int maxWidth) {
            this.maxWidth = maxWidth;
            requestLayout();
        }

        public void setMaxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
            requestLayout();
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int width = MeasureSpec.makeMeasureSpec(
                    Math.min(MeasureSpec.getSize(widthMeasureSpec), maxWidth),
                    MeasureSpec.getMode(widthMeasureSpec)
            );
            int height = MeasureSpec.makeMeasureSpec(
                    Math.min(MeasureSpec.getSize(heightMeasureSpec), maxHeight),
                    MeasureSpec.getMode(heightMeasureSpec)
            );
            super.onMeasure(width, height);
        }
    }
}

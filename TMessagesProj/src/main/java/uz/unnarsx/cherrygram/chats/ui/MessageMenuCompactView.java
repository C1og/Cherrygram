package uz.unnarsx.cherrygram.chats.ui;

import android.view.View;
import android.widget.FrameLayout;

import org.telegram.messenger.MessageObject;
import org.telegram.ui.ChatActivity;

public class MessageMenuCompactView extends FrameLayout {

    public MessageMenuCompactView(
            ChatActivity chatActivity,
            MessageObject selectedObject,
            int optionsCount,
            boolean allowReply,
            boolean allowEdit,
            boolean allowForward,
            boolean allowCopy,
            boolean allowCopyPhoto,
            boolean allowCopyLink,
            boolean allowDelete
    ) {
        super(chatActivity.getContext());
        setVisibility(View.GONE);
    }

    public static boolean allowCompactStyle() {
        return false;
    }
}

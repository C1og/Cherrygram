package uz.unnarsx.cherrygram.preferences.tabs;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.telegram.ui.ActionBar.Theme;

import java.util.List;

import uz.unnarsx.cherrygram.core.ui.mainTabs.MainTabsManager;

public class MainTabsPreviewCell extends FrameLayout {

    private boolean editMode;

    public MainTabsPreviewCell(Context context) {
        super(context);
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public void setTabs(
            List<MainTabsManager.Tab> tabs,
            Context context,
            Theme.ResourcesProvider resourceProvider,
            int currentAccount,
            boolean fromSettings,
            boolean showSearch
    ) {
        removeAllViews();

        LinearLayout row = new LinearLayout(context);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);

        for (MainTabsManager.Tab tab : tabs) {
            if (!tab.getEnabled()) {
                continue;
            }
            TextView textView = new TextView(context);
            textView.setText(tab.getType().name());
            textView.setAlpha(editMode ? 0.85f : 1f);
            row.addView(textView);
        }

        addView(row, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
    }
}

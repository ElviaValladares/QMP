package com.efisys.quienmepresta.swipe;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.efisys.quienmepresta.R;
import com.xenione.libs.swipemaker.AbsCoordinatorLayout;
import com.xenione.libs.swipemaker.SwipeLayout;

public class RightCoordinatorLayout extends AbsCoordinatorLayout {

    public interface OnDismissListener {
        void onDismissed();
    }

    private View mBackgroundView;
    private SwipeLayout mForegroundView;
    private OnDismissListener mOnDismissListener;

    public RightCoordinatorLayout(Context context) {
        super(context);
    }

    public RightCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RightCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RightCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void doInitialViewsLocation() {
        mBackgroundView = findViewById(R.id.backgroundView);
        mForegroundView = (SwipeLayout) findViewById(R.id.foregroundView);
        mForegroundView.anchor(this.getRight(), this.getLeft());
    }

    public void setOnDismissListener(OnDismissListener listener) {
        mOnDismissListener = listener;
    }

    @Override
    public void onTranslateChange(float global, int index, float relative) {
        mBackgroundView.setAlpha(global);
        mForegroundView.setAlpha(1 - global);
        if (global == 1) {
            mOnDismissListener.onDismissed();
        }
    }
}

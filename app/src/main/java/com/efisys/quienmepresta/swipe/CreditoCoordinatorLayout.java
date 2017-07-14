package com.efisys.quienmepresta.swipe;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.efisys.quienmepresta.R;
import com.xenione.libs.swipemaker.AbsCoordinatorLayout;
import com.xenione.libs.swipemaker.SwipeLayout;


public class CreditoCoordinatorLayout extends AbsCoordinatorLayout {

    private View mBackgroundView;
    private SwipeLayout mForegroundView;

    public CreditoCoordinatorLayout(Context context) {
        super(context);
    }

    public CreditoCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CreditoCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CreditoCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void doInitialViewsLocation() {
        mForegroundView = (SwipeLayout) findViewById(R.id.foregroundView);
        mBackgroundView = findViewById(R.id.backgroundView);
        mForegroundView.anchor(mBackgroundView.getRight(), mBackgroundView.getLeft());
    }

    @Override
    public void onTranslateChange(float global, int index, float relative) {
    }
}


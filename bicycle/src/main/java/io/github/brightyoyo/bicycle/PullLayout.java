package io.github.brightyoyo.bicycle;

import android.content.Context;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author goodev
 * @since 15/9/17
 */
public class PullLayout extends ViewGroup {

    private ScrollerCompat mScroller;
    private float mLastY;

    public PullLayout(Context context) {
        super(context);
        initView(context);
    }

    public PullLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context pContext) {
        mScroller = ScrollerCompat.create(pContext);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}

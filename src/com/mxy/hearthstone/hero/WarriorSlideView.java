package com.mxy.hearthstone.hero;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.mxy.hearthstone.utils.ScrollerUtil;


public class WarriorSlideView extends ViewGroup {

    private ScrollerUtil scroller;
    private View description;
    private View cards;
    private Context ctx;
    private GestureDetector gestureDetector;

    /**
     * 判断当前是否发生快速滑动事件
     */
    private boolean isFling = false;
    /**
     * 当前屏幕显示的子view的下标
     */
    private int curIndex;

    public WarriorSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init();
    }

    private void init() {
        scroller = new ScrollerUtil(ctx);

        gestureDetector = new GestureDetector(ctx, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            /*
              当手指在屏幕上平滑移动的时候，回调
             */
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                scrollBy((int) distanceX, 0);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            /*
                当手指在屏幕上快速滑动时，回调
            */
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                isFling = true;
                if (velocityX > 0 && curIndex > 0) {
                    curIndex--;
                } else if (velocityX < 0 && curIndex < getChildCount() - 1) {
                    curIndex++;
                }
                moveToDest(curIndex);
                return false;
            }
        });

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        description = getChildAt(1);
        cards = getChildAt(0);

        description.measure(widthMeasureSpec, heightMeasureSpec);
        cards.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        description.layout(0, 0, getWidth(), getHeight());
        cards.layout(getWidth(), 0, getWidth() * 2, getHeight());
    }

    private int onInterDownX;
    private int onInterDownY;

    /*
        ViewGroup分发事件的过程
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /*
     * down时的X坐标
	 */
    private int firstX;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onInterDownX = (int) ev.getX();
                onInterDownY = (int) ev.getY();

                gestureDetector.onTouchEvent(ev);
                firstX = (int) ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int distanceX = (int) Math.abs(ev.getX() - onInterDownX);
                int distanceY = (int) Math.abs(ev.getY() - onInterDownY);
                //当水平方向滑动的距离大于竖直方向移动的距离，并且手指不是抖动
                if (distanceX > distanceY && distanceX > 10) {
                    //此时水平移动
                    result = true;
                } else {
                    result = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*
         * 当点击scrollview的时候，down事件按照默认的规则传递给了scrollview来处理
		 * 当水平滑动的时候，onInterceptTouchEvent方法，返回true,中断事件，
		 * onTouchEvent才开始执行，此时，onTouchEvent方法，收到的第一个事件，是MOVE事件
		 * ，该情况会导致 gestureDetector解析手势时，计算位移量，出现错误
		 */
        gestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                //只有没发生快速滑动事件时，才按点击的位置来判断页面切换
                if (!isFling) {
                    int tempIndex = curIndex;
                    // 点下时x的坐标 - 抬起时x的坐标 > 屏幕宽度的一半 index值应该+1
                    if (firstX - event.getX() > getWidth() / 2) {
                        tempIndex++;
                    }
                    // 抬起时x的坐标 - 点下时x的坐标 > 屏幕宽度的一半 index值应该-1
                    if (event.getX() - firstX > getWidth() / 2) {
                        tempIndex--;
                    }
                    moveToDest(tempIndex);

                }
                isFling = false;
                break;
        }
        return true;
    }


    /**
     * 将指定下标的图片，移动到屏幕上
     *
     * @param tempIndex 指定下标
     */
    private void moveToDest(int tempIndex) {
        if (tempIndex < 0) {
            tempIndex = 0;
        }
        if (tempIndex > getChildCount() - 1) {
            tempIndex = getChildCount() - 1;
        }
        curIndex = tempIndex;

        //将下标为curIndex 的子view显示在屏幕上。

        //瞬间移动效果
        //scrollTo(curIndex*getWidth(),0);

        int distance = curIndex * getWidth() - getScrollX();// 移动的距离 = 目标位置 - 当前的位置

        scroller.startScroll(getScrollX(), 0, distance, 0);

		/*
		 * invalidate 刷新页面视图  会导致 computeScroll 方法的执行
		 */
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        /**
         * 使用工具计算当前位置
         */
        if (scroller.computeScrollOffset()) {
            int currX = scroller.getCurrX();
            scrollTo(currX, 0);
            invalidate();
        }
    }
}

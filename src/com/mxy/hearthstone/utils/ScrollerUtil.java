package com.mxy.hearthstone.utils;

import android.content.Context;
import android.os.SystemClock;

/**
 * 用于计算移动距离的工具
 */
public class ScrollerUtil {
    private int startX;
    private int startY;
    private int distanceX;
    private int distanceY;

    /**
     * 现在的X坐标
     */
    private int currX;
    /**
     * 现在的Y坐标
     */
    private int currY;

    public ScrollerUtil(Context ctx){

    }

    /**
     * 开始移动
     * @param startX 基准点的X坐标
     * @param startY 基准点的Y坐标
     * @param distanceX  X方向移动的距离
     * @param distanceY	Y 方向移动的距离
     */
    public void startScroll(int startX,int startY,int distanceX,int distanceY){
        this.startX = startX;
        this.startY = startY;
        this.distanceX = distanceX;
        this.distanceY = distanceY;

        // 从手机开机，到现在的毫秒值，不包括手机睡眠的时间
        startTime = SystemClock.uptimeMillis();

        isFinish = false;
    }

    private final long TOTLE_TIME = 500;

    /**
     * 判断移动是否完成
     */
    private boolean isFinish = false;

    private long startTime;

    /**
     * 计算当前移动的偏移量
     * @return
     * true 说明还在移动
     * false 说明移动已经结束
     */
    public boolean computeScrollOffset(){
        if(isFinish){
            return false;
        }

		/*
		 * 已经运行的时间
		 */
        long passTime = SystemClock.uptimeMillis() - startTime;

        if(passTime < TOTLE_TIME){ // 还在运动

            setCurrX((int) (startX+passTime*distanceX/TOTLE_TIME));
            setCurrY((int) (startY+passTime* distanceY/TOTLE_TIME));

        }else{//时间到了，移动也该结束了
            setCurrX(startX+distanceX);
            setCurrY(startY+distanceY);
            isFinish = true;
        }


        return true;
    }

    public int getCurrX() {
        return currX;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public int getCurrY() {
        return currY;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }
}

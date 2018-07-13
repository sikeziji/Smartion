package com.wangj.smartion.smartion.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class DragLayout extends FrameLayout{


    private boolean isShowShadow = true;
    //手势处理类
    private GestureDetectorCompat gestureDetector;
    //试图拖拽移动帮助类
    private ViewDragHelper dragHelper;
    //滑动监听器
    private DragListener mDragListener;
    //水平拖拽的距离
    private int range;



    private Context context;


    public DragLayout(@NonNull Context context) {
        this(context,null);
    }

    public DragLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        this.context = context;
    }

    public DragLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        gestureDetector = new GestureDetectorCompat(context,new YScrollDetector());
        dragHelper = ViewDragHelper.create(this,dragHelperCallback);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                      int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 滑动相关回调接口
     */
    public interface DragListener {
        //界面打开
        public void onOpen();
        //界面关闭
        public void onClose();
        //界面滑动过程
        public void onDrag(float percent);
    }

     class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
         @Override
         public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
             return Math.abs(distanceY) <= Math.abs(distanceX);
         }
     }

    /**
     * 关于子View的拖拽滑动，实现Callback当中的方法
     */
    private ViewDragHelper.Callback dragHelperCallback = new ViewDragHelper.Callback() {

        /**
         * 水平方向上的移动
         * @param child
         * @param left
         * @param dx
         * @return
         */
        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            return super.clampViewPositionHorizontal(child, left, dx);
        }

        @Override
        public int getOrderedChildIndex(int index) {
            return super.getOrderedChildIndex(index);
        }

        @Override
        public int getViewHorizontalDragRange(@NonNull View child) {
            return super.getViewHorizontalDragRange(child);
        }

        @Override
        public int getViewVerticalDragRange(@NonNull View child) {
            return super.getViewVerticalDragRange(child);
        }

        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return false;
        }
    };
}

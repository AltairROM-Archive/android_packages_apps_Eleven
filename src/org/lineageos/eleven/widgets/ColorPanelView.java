/*
 * Copyright (C) 2010 Daniel Nilsson
 * Copyright (C) 2012 The CyanogenMod Project
 * Copyright (C) 2021 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lineageos.eleven.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * This class draws a panel which which will be filled with a color which can be
 * set. It can be used to show the currently selected color.
 *
 * @author Daniel Nilsson
 */
public class ColorPanelView extends View {

    /**
     * The width in pixels of the border surrounding the color panel.
     */
    private final static float BORDER_WIDTH_PX = 1;

    private final static int BORDER_COLOR = 0xff6E6E6E;

    private final static int PAINT_COLOR = 0xff000000;

    private static float mDensity = 1f;

    private Paint mBorderPaint;

    private Paint mColorPaint;

    private RectF mDrawingRect;

    private RectF mColorRect;

    private AlphaPatternDrawable mAlphaPattern;

    public ColorPanelView(final Context context) {
        this(context, null);
    }

    public ColorPanelView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorPanelView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mBorderPaint = new Paint();
        mColorPaint = new Paint();
        mDensity = getContext().getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        final RectF rect = mColorRect;
        mBorderPaint.setColor(BORDER_COLOR);
        canvas.drawRect(mDrawingRect, mBorderPaint);

        if (mAlphaPattern != null) {
            mAlphaPattern.draw(canvas);
        }

        mColorPaint.setColor(PAINT_COLOR);
        canvas.drawRect(rect, mColorPaint);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        final int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mDrawingRect = new RectF();
        mDrawingRect.left = getPaddingLeft();
        mDrawingRect.right = w - getPaddingRight();
        mDrawingRect.top = getPaddingTop();
        mDrawingRect.bottom = h - getPaddingBottom();

        setUpColorRect();
    }

    private void setUpColorRect() {
        final RectF dRect = mDrawingRect;

        final float left = dRect.left + BORDER_WIDTH_PX;
        final float top = dRect.top + BORDER_WIDTH_PX;
        final float bottom = dRect.bottom - BORDER_WIDTH_PX;
        final float right = dRect.right - BORDER_WIDTH_PX;

        mColorRect = new RectF(left, top, right, bottom);

        mAlphaPattern = new AlphaPatternDrawable((int) (5 * mDensity));

        mAlphaPattern.setBounds(Math.round(mColorRect.left), Math.round(mColorRect.top),
                Math.round(mColorRect.right), Math.round(mColorRect.bottom));
    }

}

package controld.android.com.customcontrols;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by rahul.raja on 4/3/16.
 */
public class CustomControlView extends View {

    private float mDensity;
    private float mXOffsetFromCenter;
    private float mYOffsetFromCenter;
    private float mViewCenter;
    private float mViewRadius;
    private IconType mIconType;
    private Paint mPaint;
    private Path mpath;
    private int mSize;


    private CustomControlView(Context context) {
        super(context);
    }

    public CustomControlView(Context context, int size, float density, IconType switchtype) {
        this(context);
        mIconType = switchtype;
        mDensity = density;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mpath = new Path();
        mSize = size;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.reset();
        switch (mIconType) {

            case CLOSE_BUTTON:
                mPaint.setColor(Color.WHITE);
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setStrokeWidth(4);
                mViewCenter = (mSize * mDensity) / 2;
                mViewRadius = (int) ((3.0 / 5) * mSize * mDensity) / 2;
                canvas.drawCircle(mViewCenter, mViewCenter, mViewRadius, mPaint);

                mXOffsetFromCenter = mViewCenter / 3;
                mYOffsetFromCenter = mViewCenter / 3;

                mpath.moveTo(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);

                canvas.drawPath(mpath, mPaint);


                break;

            case BACKWARD_BUTTON:
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.WHITE);
                mViewCenter = (mSize * mDensity) / 2;
                mXOffsetFromCenter = mViewCenter / 2;
                mYOffsetFromCenter = mViewCenter / 2;

                mpath.moveTo(mViewCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter);
                mpath.lineTo(mViewCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter, mViewCenter - mYOffsetFromCenter);

                //canvas.drawPath(path, paint);

                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter, mViewCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);

                canvas.drawPath(mpath, mPaint);


                break;

            case FORWARD_BUTTON:
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.WHITE);
                mPaint.setStrokeWidth(6);
                mViewCenter = (mSize * mDensity) / 2;
                mXOffsetFromCenter = mViewCenter / 2;
                mYOffsetFromCenter = mViewCenter / 2;

                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter);
                canvas.drawPath(mpath, mPaint);

                canvas.drawLine(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter, mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter, mPaint);

                break;

            case MINIMIZE_BUTTON:
                mViewCenter = (mSize * mDensity) / 2;
                mXOffsetFromCenter = 3 * mDensity;
                mYOffsetFromCenter = 3 * mDensity;

                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setStrokeWidth(4);
                mPaint.setColor(Color.WHITE);

                mpath.moveTo(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter - (5 * mDensity));
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter - (5 * mDensity), mViewCenter - mYOffsetFromCenter);

                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter - (5 * mDensity));

                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter + (5 * mDensity), mViewCenter - mYOffsetFromCenter);

                mpath.moveTo(mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter + (5 * mDensity));

                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter - (5 * mDensity), mViewCenter + mYOffsetFromCenter);

                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter + (5 * mDensity));

                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter + (5 * mDensity), mViewCenter + mYOffsetFromCenter);

                canvas.drawPath(mpath, mPaint);

                break;
            case UNMUTE_BUTTON:
                addMuteButton(canvas);
                canvas.drawLine(mViewCenter + (15 * mDensity), mViewCenter - (5 * mDensity), mViewCenter - (5 * mDensity), mViewCenter + (5 * mDensity), mPaint);
                break;

            case MUTE_BUTTON:
                addMuteButton(canvas);
                break;
            case PAUSE_BUTTON:
                addPlayButtonCircle(canvas);
                mXOffsetFromCenter = mViewRadius / 4;
                mYOffsetFromCenter = mViewRadius / 3;

                canvas.drawLine(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter, mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter, mPaint);
                canvas.drawLine(mViewCenter + mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter, mViewCenter + mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter, mPaint);

                break;
            case PLAY_BUTTON:
                addPlayButtonCircle(canvas);
                mXOffsetFromCenter = mViewRadius / 3;
                mYOffsetFromCenter = mViewRadius / 3;

                mPaint.setStyle(Paint.Style.FILL);

                mpath.moveTo(mViewCenter + mXOffsetFromCenter, mViewCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter - mYOffsetFromCenter);
                mpath.lineTo(mViewCenter - mXOffsetFromCenter, mViewCenter + mYOffsetFromCenter);
                mpath.lineTo(mViewCenter + mXOffsetFromCenter, mViewCenter);
                canvas.drawPath(mpath, mPaint);
                break;


        }


    }

    private void addMuteButton(Canvas canvas) {
        mViewCenter = (mSize * mDensity) / 2;
        RectF innerRect = new RectF(mViewCenter - (10 * mDensity), mViewCenter - (5 * mDensity), mViewCenter, mViewCenter + (5 * mDensity));
        RectF middleRect = new RectF(mViewCenter - (10 * mDensity), mViewCenter - (10 * mDensity), mViewCenter + (5 * mDensity), mViewCenter + (10 * mDensity));
        RectF outerRect = new RectF(mViewCenter - (10 * mDensity), mViewCenter - (15 * mDensity), mViewCenter + (10 * mDensity), mViewCenter + (15 * mDensity));

        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(innerRect, -45, 90, false, mPaint);
        canvas.drawArc(middleRect, -45, 90, false, mPaint);
        canvas.drawArc(outerRect, -45, 90, false, mPaint);
    }

    private void addPlayButtonCircle(Canvas canvas) {
        mViewRadius = (int) (5.0 * mSize / 12) * mDensity;
        mViewCenter = mSize / 2 * mDensity;
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(7);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mViewCenter, mViewCenter, mViewRadius, mPaint);
    }
}

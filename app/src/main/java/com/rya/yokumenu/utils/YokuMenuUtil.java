package com.rya.yokumenu.utils;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Rya32 on 广东石油化工学院.
 * Version 1.0
 */
public class YokuMenuUtil {
    private static int isRunning = 0;

    public static void viewOut(RelativeLayout relativeLayout, long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, -180,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);

        relativeLayout.startAnimation(rotateAnimation);

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isRunning += 1;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isRunning -= 1;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public static int getIsRunning() {
        return isRunning;
    }

    public static void viewIn(RelativeLayout relativeLayout, long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(-180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);

        relativeLayout.startAnimation(rotateAnimation);

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isRunning += 1;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isRunning -= 1;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

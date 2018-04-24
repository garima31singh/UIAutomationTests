package com.example.garimasingh.gif_scroll;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class GifScroll {

    private UiDevice mDevice;

    @Before
    public void before() {
        // Initialize UiDevice Instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        assertThat(mDevice, notNullValue());

        // Start from the home screen
        mDevice.pressHome();
    }

    @org.junit.Test

    public void test() throws InterruptedException, UiObjectNotFoundException {
        openApp("com.google.android.talk");
        Thread.sleep(5000);
        UiObject hangouts = mDevice.findObject(new UiSelector().text("Hangouts"));
        if (hangouts.exists() && hangouts.isEnabled()) {
            hangouts.click();
            sleepthread();
        }
        UiObject selectrecipient = mDevice.findObject(new UiSelector().
                resourceId("com.google.android.talk:id/conversationContent"));

        // Simulate a user-click on the button
        if (selectrecipient.exists() && selectrecipient.isEnabled()) {
            selectrecipient.click();
            sleepthread();
        }

        // click on text field
        UiObject textbox = mDevice.findObject(new UiSelector()
                .resourceId("com.google.android.talk:id/message_text"));
        if (textbox.exists() && textbox.isEnabled()) {
            textbox.click();
            sleepthread();
        }

//        Click GIF icon

        boolean Gificon = mDevice.click(999, 1007);
        sleepthread();

        //Click Buggy tab

//        boolean buggy = mDevice.click(850, 1726);
//        sleepthread();

        //scroll till end
//        UiScrollable scroll = new UiScrollable(new UiSelector().scrollable(true));
//        scroll.setAsVerticalList();
//
//        UiObject apps = scroll.getChildByText(new UiSelector()
//        .className(android.widget.LinearLayout.class.getName()),"apps");
//        apps.clickAndWaitForNewWindow();

//        boolean scrollgif = mDevice.click(523, 1470);

        int num = 50;
        for (int scrollCount = 0; scrollCount < num; scrollCount++) {
            sleepthread();
            mDevice.swipe(523, 1590, 523, 1180, num);
        }

        for (int scrollCount = 0; scrollCount < num; scrollCount++) {
            sleepthread();
            mDevice.swipe(523, 1180, 523, 1590, num);
        }
//
//        for (int scrollCount = 0; scrollCount < 20; scrollCount++) {
//            sleepthread();
//            mDevice.swipe(523, 1590, 523, 1180, 20);
//        }
//
//        for (int scrollCount = 0; scrollCount < 20; scrollCount++) {
//            sleepthread();
//            mDevice.swipe(523,1180, 523,1590,20);
//        }


    }

    private void openApp(String packageName) {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
//
    public void sleepthread() throws InterruptedException {
        Thread.sleep(2000);

    }


}

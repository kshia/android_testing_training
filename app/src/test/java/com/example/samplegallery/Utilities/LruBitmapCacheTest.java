package com.example.samplegallery.Utilities;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Kristina on 1/22/17.
 */

public class LruBitmapCacheTest {

    @Mock
    Context mMockContext;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCacheSizeTest() throws Exception {
        mMockContext = Mockito.mock(Context.class, Mockito.RETURNS_DEEP_STUBS);
        DisplayMetrics mockDM = Mockito.mock(DisplayMetrics.class, Mockito.RETURNS_DEEP_STUBS);
        mockDM.widthPixels = 50;
        mockDM.heightPixels = 100;
        Mockito.when(mMockContext.getResources().getDisplayMetrics()).thenReturn(mockDM);
        assertThat(LruBitmapCache.getCacheSize(mMockContext),  is(equalTo(3 * mockDM.widthPixels * mockDM.heightPixels * 4)));
    }
}

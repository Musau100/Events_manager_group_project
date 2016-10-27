package com.ryle_tech.materialdesign;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by lenik on 6/13/2016.
 */
public class App  extends Application{

    public static final String TAG ="material";
    private ImageLoader mImageLoader;
    LruBitmapCache mLruBitmapCache;
    private RequestQueue mRequestQueue;
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public static synchronized App getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getBaseContext());
        }

        return mRequestQueue;
    }
   public ImageLoader getImageLoader() {
       getRequestQueue();
    if (mImageLoader == null) {
        mImageLoader = new ImageLoader(this.mRequestQueue,
                new LruBitmapCache());
    }
    return this.mImageLoader;
}
    public LruBitmapCache getLruBitmapCache() {
        if (mLruBitmapCache == null)
            mLruBitmapCache = new LruBitmapCache();
        return this.mLruBitmapCache;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

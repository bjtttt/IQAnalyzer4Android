package com.keysight.guozhitao.commondrawengine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.view.View;

/**
 * Created by cn569363 on 3/26/2016.
 */
public class CommonDrawEngine extends GLSurfaceView {
    public CommonDrawEngine(Context context) {
        super(context);

        try {
            // Create an OpenGL ES 2.0 context
            setEGLContextClientVersion(2);
            // Set the Renderer for drawing on the GLSurfaceView
            setRenderer(new CommonDrawEngineRender());
            // Render the view only when there is a change in the drawing data
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.keysight.guozhitao.commondrawengine;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by cn569363 on 3/26/2016.
 */
public class CommonDrawEngineRender implements GLSurfaceView.Renderer {
    public void onDrawFrame(GL10 gl) {
        // 清除屏幕和深度缓存
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // 重置当前的模型观察矩阵
        gl.glLoadIdentity();
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Set OpenGL view size
        gl.glViewport(0, 0, width, height);

        //设置投影矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵
        gl.glLoadIdentity();
        // 设置视口的大小
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
        // 选择模型观察矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // 重置模型观察矩阵
        gl.glLoadIdentity();
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glShadeModel(GL10.GL_SMOOTH);
        // Black background
        gl.glClearColor(0, 0, 0, 0);
        // Set deep buffer
        gl.glClearDepthf(1.0f);
        // Enable deep test
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // Set deep test type
        gl.glDepthFunc(GL10.GL_LEQUAL);

        // Tell system to do correction on perspective
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);    }
}

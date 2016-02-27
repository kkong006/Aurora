package com.hacktech2016.aurora;

import android.os.Bundle;

import com.google.vrtoolkit.cardboard.CardboardActivity;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.cardboard.RajawaliCardboardView;
public class renderImage extends CardboardActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RajawaliCardboardView view = new RajawaliCardboardView(this);
        setContentView(view);
        setCardboardView(view);

        RajawaliCardboardRenderer renderer = new MyRenderer(this);
        view.setRenderer(renderer);
        view.setSurfaceRenderer(renderer);
    }
    // private static class MyRenderer extends RajawaliCardboardRenderer {
//        public MyRenderer(Context context) {
//            super(context);
//        }
//
//        @Override
//        protected void initScene() {
//
//            // create your scene
//
//        }
//    }
}



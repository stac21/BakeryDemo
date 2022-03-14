package com.mygdx.game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.mygdx.game.BakeryDemo;

public class AndroidLauncher extends FragmentActivity implements AndroidFragmentApplication.Callbacks {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bakery);

		// create libgdx fragment
		GameFragment libgdxFragment = new GameFragment();

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.content_frame_layout, libgdxFragment);
		transaction.commit();
	}

	public static class GameFragment extends AndroidFragmentApplication {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View view = initializeForView(new BakeryDemo());
			view.setBackgroundColor(Color.TRANSPARENT);

			return view;
		}
	}

	@Override
	public void exit() {

	}
}

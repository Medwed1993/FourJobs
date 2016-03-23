package  app.ua.cert.medwed.fourjobs;

import java.io.IOException;
import app.ua.cert.medwed.view.*;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//Activity ��� �������� �������
public class CubeActivity extends Activity {
	// ��� ��������������� �����
	SoundPool mSoundPool;
	AssetManager assets;
	int sound;
	// view
	View cubeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// �������� �����
		mSoundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		mSoundPool.load(getApplicationContext(),R.raw.sounds,1);

		AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		
		super.onCreate(savedInstanceState);
		cubeView = new CubeView(this, audioManager, mSoundPool);
		setContentView(cubeView);
	}

	// �������� �����
	private int loadSound(String fileName) {
		AssetFileDescriptor afd = null;
		try {
			afd = assets.openFd(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this,
					"Отсутсвует звуковой файл '" + fileName + "'",
					Toast.LENGTH_SHORT).show();
			return -1;
		}
		return mSoundPool.load(afd, 1);
	}

}
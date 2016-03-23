package  app.ua.cert.medwed.fourjobs;
import java.util.Random;



import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


//Activity ��� ������� �������
public class TrLightActivity extends Activity {
	//������ �����-�������
	int[] balls_res;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trlight);


		balls_res = new int[5];
		balls_res[0] = R.drawable.ball1;
		balls_res[1] = R.drawable.ball2;
		balls_res[2] = R.drawable.ball3;
		balls_res[3] = R.drawable.ball4;
		balls_res[4] = R.drawable.ball5;

		//������ ������� � ��������� ������
		BlinkingClass workingClass1 = new BlinkingClass(findViewById(R.id.bv1), 600);
		Thread thread1 = new Thread(workingClass1);
		thread1.start();

		BlinkingClass workingClass2 = new BlinkingClass(findViewById(R.id.bv2), 1500);
		Thread thread2 = new Thread(workingClass2);
		thread2.start();

		BlinkingClass workingClass3 = new BlinkingClass(findViewById(R.id.bv3), 3300);
		Thread thread3 = new Thread(workingClass3);
		thread3.start();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"TrLight Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app deep link URI is correct.
				Uri.parse("android-app://app.ua.cert.medwed.fourjobs/http/host/path")
		);
		AppIndex.AppIndexApi.start(client, viewAction);
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"TrLight Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app deep link URI is correct.
				Uri.parse("android-app://app.ua.cert.medwed.fourjobs/http/host/path")
		);
		AppIndex.AppIndexApi.end(client, viewAction);
		client.disconnect();
	}

	//�����, ����������� ������ � ��������� ������
	class BlinkingClass implements Runnable {
		View ball_obj;
		int duration_value;
		Random r;

		//�����������
		public BlinkingClass(View ball, int duration) {
			ball_obj = ball;
			duration_value = duration;
			r = new Random();
		}

		@Override
		public void run() {
			// ������� ������
			while (true) {
				try {
					//������������ ������ �� �������� �����
					Thread.sleep(duration_value);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ��������� � UI ����� ����� Runnable
				TrLightActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						//��������� ������� ������ ���� �� ��������� ������
						ball_obj.setBackgroundResource(balls_res[r.nextInt(5)]);
					}
				});
			}
		}
	}
}

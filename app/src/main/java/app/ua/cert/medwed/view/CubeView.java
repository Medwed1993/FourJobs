package  app.ua.cert.medwed.view;

import java.util.ArrayList;
import app.ua.cert.medwed.canvas.Cube;
import app.ua.cert.medwed.canvas.WindBorder;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;

//view ����� ��� �������� �������
public class CubeView extends View {
	private ArrayList<Cube> cube_list; // ������ �����
	private WindBorder winbord; // ������� ����
	int sound; // ����
	SoundPool mSoundPool; // ��� ��������������� �����

	int back_color ; // ���� ���� (������� �� ��������)
	int cube_color ; // ���� ������� (������� �� ��������)
	int cube_a = 1; // �������� ������� (������� �� ��������)

	// �����������
	public CubeView(Context context, int sound_val, SoundPool sp) {
		super(context);
		// �������� ���������
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(context);
		back_color = Integer.parseInt(settings.getString("pref_cb", "-1"));
		cube_color = Integer.parseInt(settings.getString("pref_c", "-12303292"));
		cube_a = Integer.parseInt(settings.getString("pref_a", "30"));
		// ����
		sound = sound_val;
		mSoundPool = sp;//katerina___protsenko  meda4ka
		cube_list = new ArrayList<Cube>();
		// ������� ����
		winbord = new WindBorder(back_color);
		// ��������� � ������ ������ ���
		cube_list.add(new Cube(cube_color, 200, 200, 1, cube_a));

		// �������� ���
		this.setFocusable(true);
		this.requestFocus();
		this.setFocusableInTouchMode(true);
	}

	// ��������� �����
	@Override
	protected void onDraw(final Canvas canvas) {
		winbord.draw(canvas);
		for (final Cube b : cube_list) {
			b.draw(canvas);
			// ���������� ���������
			if (b.moveWithCollisionDetection(winbord))
				// ����������� ���� ��� �������������� ���� � ������ ������
				mSoundPool.play(sound, 1, 1, 1, 0, 1);
		}
		invalidate(); // �������������� �����������
	}

	// ��� ������ �������� view, ��� ����� ������� ����������
	@Override
	public void onSizeChanged(int w, int h, int oldW, int oldH) {
		// ������������� �������
		winbord.set(0, 0, w, h);
	}

	// ��������� ������������� � ������
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// ���������� ����
		float currentX = event.getX();
		float currentY = event.getY();
		if (currentY < 100)
			currentY += 50;

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// ����� ��� ��������� � ������
			cube_list.add(new Cube(cube_color, currentX, currentY, 1, cube_a));
			break;
		}
		return true;
	}
}
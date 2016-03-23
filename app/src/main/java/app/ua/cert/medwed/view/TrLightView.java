package  app.ua.cert.medwed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

//view ����� ��� ������� �������
public class TrLightView extends View {
	private ShapeDrawable down; //íèæíåå îñíîâàíèå
	private ShapeDrawable midle; //ñðåäíåå îñíîâàíèå
	private ShapeDrawable up; //âåðõíåå îñíîâàíèå
	private ShapeDrawable road; //äîðîãà

	//êîíñòðóêòîð
	public TrLightView(Context v, AttributeSet as) {
		super(v, as);
		drawShape(as);
	}

	//îòðèñîâêà ñâåòîôîðà
	public void drawShape(AttributeSet ast) {

		DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
		int maxWidth=displaymetrics.widthPixels;
		int maxHeight=displaymetrics.heightPixels;

		int x = maxWidth/2;
		int y = maxHeight/2;

		//road = new ShapeDrawable(new RectShape());
		//road.getPaint().setColor(Color.GRAY);
		//road.setBounds(0, y + (int) (maxHeight / 7), maxWidth, y + (int) (maxHeight / 3));

		midle = new ShapeDrawable(new RectShape());
		midle.getPaint().setColor(Color.BLACK);
		midle.setBounds((int) (maxWidth / 5), y - (int) (maxHeight / 2.5), (int) (maxWidth / 3), y + (int) (maxHeight / 4));

		down = new ShapeDrawable(new RectShape());
		down.getPaint().setColor(Color.BLACK);
		down.setBounds((int) (maxWidth / 10), y + (int) (maxHeight / 5), (int) (maxWidth / 2), y + (int) (maxHeight / 4));


		up = new ShapeDrawable(new RectShape());
		up.getPaint().setColor(Color.LTGRAY);
		up.setBounds(160, y - (int) (maxHeight / 2.5), 290, y - (int) (maxHeight / 15));


	}

	protected void onDraw(Canvas canvas) {
	//	road.draw(canvas);
		midle.draw(canvas);
		down.draw(canvas);
		up.draw(canvas);
	}}
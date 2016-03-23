package  app.ua.cert.medwed.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

//view ����� ��� ������� �������
public class TrLightView extends View {
	private ShapeDrawable osn_down; //������ ���������
	private ShapeDrawable osn_midle; //������� ���������
	private ShapeDrawable osn_up; //������� ���������
	
	private Paint paint; //����� ��� ���������
	
	//�����������
	public TrLightView(Context v, AttributeSet as) {
		super(v, as);  
		drawShape(as);
	}
	
	//��������� ���������
	public void drawShape(AttributeSet ast) {
		int x = 400;
		int y = 600;
	
		osn_midle = new ShapeDrawable(new RectShape());
		osn_midle.getPaint().setColor(Color.BLACK);
		osn_midle.setBounds(x+10 , y, x + 20, y + 170);
		
		osn_down = new ShapeDrawable(new RectShape());
		osn_down.getPaint().setColor(Color.BLACK);
		osn_down.setBounds(x-30 , y+170, x + 60, y + 200);
		
		osn_up = new ShapeDrawable(new RectShape());
		osn_up.getPaint().setColor(Color.GRAY);
		osn_up.setBounds(x-30 , y-250, x + 60, y );
		
		paint=new Paint();
		paint.setColor(0xFF00FF00);
	}

	protected void onDraw(Canvas canvas) {
		osn_midle.draw(canvas);
		osn_down.draw(canvas);
		osn_up.draw(canvas);
	}
	
	
}
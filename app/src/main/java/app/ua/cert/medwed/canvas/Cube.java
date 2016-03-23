package  app.ua.cert.medwed.canvas;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;

//����� ��������� ��� (��� �������� �������)
public class Cube {
	float radius = 50; // ������
	float x = radius + 200; // ����� �������� ������� ����, x
	float y = radius + 200; // ����� �������� ������� ����, y 
	float speedX = 1; // �������� ����������� �� �����������
	float speedY = 5; // �������� ����������� �� ���������
	float a=1;		  //���������
	float bordery;
	   float sm;//������� �������, �� ������� ����� ������������ ���

	private RectF bounds; // ��� ��������� �������� ������� ����
	private Paint paint;  // ����� ��� ��������� ������
	private Paint paint2; // ����� ��� ��������� �����
	private Paint paint3;

	// �����������
	public Cube(int c,int color, float xcoord, float ycoord, int speedx_val, int speedy_val) {
		//���������� ���������� ���������, �������� ����������� � ���� ��������
		x = xcoord;
		y = ycoord;
		sm=c;
		bordery = y-radius;
		speedX = speedx_val;
		speedY = speedy_val;
		bounds = new RectF();
		paint = new Paint();
		paint.setColor(color);
		paint2 = new Paint();
		paint2.setColor(Color.GRAY);
		paint3=new Paint();
	}

	//����� �������� ���������� ����, � ������ �������� � ������������ � ���������
	//���������� ������ ���� ��� ������ �� ������ �������
	public Boolean moveWithCollisionDetection(WindBorder box) {
		if (bordery<0)
			bordery=box.yMin+1;
		Boolean collision=false;
		//�������� ����������
		x += speedX;
		y += speedY;
		//������� ������� ���������� � ������������ ������ �� ����
		if (box.yMax-bordery<=radius){
			speedY = 0;
		}
		else {
			//��������� ������� �� ������ �������
			if (x + radius > box.xMax) {
				speedX = -speedX;
		         x = box.xMax-radius;
		      }
			//��������� ������� �� ����� �������
			else if (x - radius < box.xMin) {
		    	  speedX = -speedX;
		         x = box.xMin+radius;
		      }
			//��������� ������� �� ������ �������
			if (y + radius > box.yMax) {
				speedY = -speedY;
				speedY=speedY+2*a;
				y = box.yMax - radius;
				bordery = bordery + 2*radius;
				collision=true;
			}
			//��������� ������� �� ������� �������
			else if (y - radius < bordery) {
				speedY = -speedY;
				speedY=speedY+5*a;
			}
		}
		return collision;
	}

	//��������� ����
	public void draw(Canvas canvas) {


		//���� �������� �� ��������� �� 0
		if (speedY!=0){
			//�������� ������
			bounds.set(x - sm, y - 2 * sm, x + 2 * sm, y + sm);
			paint.setStyle(Style.FILL_AND_STROKE);

			Path p = new Path();
			p.reset();
			p.moveTo(x - sm, y - sm / 3);
			p.lineTo(x + sm / 6, (float) (y - 1.5 * sm));
			p.lineTo(x, y);

			p.close();

			Path p3 = new Path();
			p3.reset();
			p3.moveTo(x + sm / 6, (float) (y - 1.5 * sm));
			p3.lineTo((float) (x+ 1.5*sm), y - sm/3);
			p3.lineTo(x, y);

			p3.close();


			Path p2 = new Path();
			p2.reset();
			p2.moveTo(x - sm, y - sm / 3);
			p2.lineTo(x + sm / 6, y + sm);
			p2.lineTo(x, y);
						p2.close();


			Path p4 = new Path();
			p4.reset();
			p4.moveTo((float) (x + 1.5 * sm), y - sm / 3);
			p4.lineTo(x + sm / 6, y + sm);
			p4.lineTo(x, y);

			p4.close();

			canvas.drawPath(p, paint);
			canvas.drawPath(p2,paint2);
		//	canvas.drawPath(p3,paint);
			//�������� �����
			//paint2.setStyle(Style.STROKE);
		//	canvas.drawPath(p,paint2);
			canvas.drawPath(p4,paint);
			canvas.drawPath(p3,paint2);
			//canvas.drawPath(p3,paint2);
			bounds.set(x - sm, y - 2*sm, x + 2*sm, y + sm);
		}
	}



}
package  app.ua.cert.medwed.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

//����� ��������� �������, � �������� ������� ������ ���
public class WindBorder {
   int xMin, xMax, yMin, yMax;
   private Paint paint; 
   private Rect bounds;
   
   //�����������
   public WindBorder(int color) {
      paint = new Paint();
      paint.setColor(color);
      bounds = new Rect();
   }
   
   //��������� ������
   public void set(int x, int y, int width, int height) {
      xMin = x;
      xMax = x + width;
      yMin = y;
      yMax = y + height;
      bounds.set(xMin, yMin, xMax, yMax);
   }
   //���������
   public void draw(Canvas canvas) {
      canvas.drawRect(bounds, paint);
   }
}
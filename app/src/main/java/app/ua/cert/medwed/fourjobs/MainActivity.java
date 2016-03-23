package  app.ua.cert.medwed.fourjobs;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

	Button btnActZ1;
	Button btnActZ2;
	Button btnActZ3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//�������� ����������� ������� � �������
		btnActZ1 = (Button) findViewById(R.id.btnAct1);
		btnActZ1.setOnClickListener(this);
		btnActZ2 = (Button) findViewById(R.id.btnAct2);
		btnActZ2.setOnClickListener(this);
		btnActZ3 = (Button) findViewById(R.id.btnAct3);
		btnActZ3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAct1:
			//������� � ������� �������
			startActivity(new Intent(this, CalcActivity.class));
			break;
		case R.id.btnAct2:
			//������� �� ������� �������
			startActivity(new Intent(this, TrLightActivity.class));
			break;
		case R.id.btnAct3:
			//������� � �������� �������
			startActivity(new Intent(this,CubeActivity.class));
			break;
		}

	}
	
	public static final int IDM_PREF = 101;
	
	@Override
	  //����
	  public boolean onCreateOptionsMenu(Menu menu ) 
	  {
	     menu.add(0,IDM_PREF, 0, "Настройка");
	     return super.onCreateOptionsMenu(menu);
	  }
	  
	  @Override 
	  //����� ������ ����
	  public boolean onOptionsItemSelected(MenuItem item) 
	  {
	     Intent intent = new Intent();
	     switch (item.getItemId())
	     {
	        case IDM_PREF: 
	        intent.setClass(this, SettingsActivity.class);
	        //������� � ����������
	        startActivity(intent); 
	        break; 
	      }
	     return true;
	  }
}

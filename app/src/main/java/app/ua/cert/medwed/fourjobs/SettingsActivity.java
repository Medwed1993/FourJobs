package  app.ua.cert.medwed.fourjobs;




import android.os.Bundle;
import android.preference.PreferenceActivity;

//Activity  ��� ��������
public class SettingsActivity extends PreferenceActivity  {
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	   super.onCreate(savedInstanceState);
	   addPreferencesFromResource(R.xml.settings);
	}

}

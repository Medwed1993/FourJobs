package  app.ua.cert.medwed.fourjobs;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

//Activity ��� ������� �������
public class CalcActivity extends Activity {

	private OnClickListener oclNumbBtn;

	String currentNumber; // ������� �������� �����
	String firstVal; // ������ ����� � ���������
	Boolean needEvaluate; // ������� ����, ��� ���������� ��������� ���������
	int operationType; // ��� �������� (1-4)

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		final EditText et = (EditText) findViewById(R.id.editText1);
		et.setEnabled(false);
		et.setText("");
		et.setClickable(false);
		currentNumber = "";
		needEvaluate = false;
		// ���������� ������� �� ������
		oclNumbBtn = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (et.getText().toString().compareTo("������� �� 0!") == 0) {
					et.setText("");
					currentNumber = "";
				}
				switch (v.getId()) {
				// ��������� ������� �� �������� ������
				case R.id.button1:
					et.setText(et.getText() + "7");
					currentNumber += "7";
					break;
				case R.id.button2:
					et.setText(et.getText() + "8");
					currentNumber += "8";
					break;
				case R.id.button3:
					et.setText(et.getText() + "9");
					currentNumber += "9";
					break;
				case R.id.button5:
					et.setText(et.getText() + "4");
					currentNumber += "4";
					break;
				case R.id.button6:
					et.setText(et.getText() + "5");
					currentNumber += "5";
					break;
				case R.id.button7:
					et.setText(et.getText() + "6");
					currentNumber += "6";
					break;
				case R.id.button9:
					et.setText(et.getText() + "1");
					currentNumber += "1";
					break;
				case R.id.button10:
					et.setText(et.getText() + "2");
					currentNumber += "2";
					break;
				case R.id.button11:
					et.setText(et.getText() + "3");
					currentNumber += "3";
					break;
				case R.id.button13:
					if (currentNumber.toString().compareTo("") == 0) {
						et.setText(et.getText() + "0");
						currentNumber += "0";
					}
					if (currentNumber.indexOf('.') == -1) {
						et.setText(et.getText() + ".");
						currentNumber += ".";
					}
					break;
				case R.id.button14:
					if (currentNumber.compareTo("0") != 0) {
						et.setText(et.getText() + "0");
						currentNumber += "0";
					}
					break;
				case R.id.button17:
					et.setText("");
					currentNumber = "";
					needEvaluate = false;
					break;
				// ����� ��������� ������� ������ - �������������� ��������
				case R.id.button4:
					if (currentNumber != "" && !needEvaluate) {
						// ��� ��������=1 (�������)
						operationType = 1;
						// ���������� ������ �����
						firstVal = currentNumber;
						currentNumber = "";
						et.setText(et.getText() + "/");
						needEvaluate = true;
					}
					break;
				case R.id.button8:
					if (currentNumber != "" && !needEvaluate) {
						operationType = 2;
						firstVal = currentNumber;
						currentNumber = "";
						et.setText(et.getText() + "*");
						needEvaluate = true;
					}
					break;
				case R.id.button12:
					if (currentNumber != "" && !needEvaluate) {
						operationType = 3;
						firstVal = currentNumber;
						currentNumber = "";
						et.setText(et.getText() + "-");
						needEvaluate = true;
					}
					break;
				case R.id.button16:
					if (currentNumber != "" && !needEvaluate) {
						operationType = 4;
						firstVal = currentNumber;
						currentNumber = "";
						et.setText(et.getText() + "+");
						needEvaluate = true;
					}
					break;
				// ��������� ���
				case R.id.button1_stepen:
					if (currentNumber != "" && !needEvaluate) {
						operationType = 5;
						firstVal = currentNumber;
						currentNumber = "";
						et.setText(et.getText() + "^");
						needEvaluate = true;
					}
					break;
					//���� ������ =
				case R.id.button15:
					try {
						// ���� ���� ������� �������� � ������� ������ �����
						if (currentNumber != "" && needEvaluate) {
							// ��������� ���������
							double result = 0;
							switch (operationType) {
							case 1:
								result = Double.parseDouble(firstVal)
										/ Double.parseDouble(currentNumber);
								break;
							case 2:
								result = Double.parseDouble(firstVal)
										* Double.parseDouble(currentNumber);
								break;
							case 3:
								result = Double.parseDouble(firstVal)
										- Double.parseDouble(currentNumber);
								break;
							case 4:
								result = Double.parseDouble(firstVal)
										+ Double.parseDouble(currentNumber);
								break;
								case 5:
									result = Math.pow(Double.parseDouble(firstVal),Double.parseDouble(currentNumber));
									break;
							}
							et.setText(Double.toString(result));
							// ��������� ������� �� 0
							if (et.getText().toString().compareTo("Infinity") == 0
									|| et.getText().toString().compareTo("NaN") == 0
									|| et.getText().toString()
											.compareTo("-NaN") == 0
									|| et.getText().toString()
											.compareTo("-Infinity") == 0)
								et.setText("������� �� 0!");
							else {
								currentNumber = et.getText().toString();
							}
							needEvaluate = false;
							firstVal = "";
						}
					} catch (Exception exc) {
						et.setText(exc.getMessage());
					}
					break;
				}
			}
		};

		// �������� ����������� ������� � ������ ������
		findViewById(R.id.button1).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button2).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button3).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button5).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button6).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button7).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button9).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button10).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button11).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button13).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button14).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button17).setOnClickListener(oclNumbBtn);

		findViewById(R.id.button4).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button8).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button12).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button16).setOnClickListener(oclNumbBtn);

		findViewById(R.id.button15).setOnClickListener(oclNumbBtn);
		findViewById(R.id.button1_stepen).setOnClickListener(oclNumbBtn);
	}
}
